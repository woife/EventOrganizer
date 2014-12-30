package template_input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import event_handling.EventTemplate;
import event_handling.RelativeToDo;

public class TemplateFileParser {

	public static EventTemplate ParseFile( File file ) throws IOException
	{
		String line;
		EventTemplate template = new EventTemplate();		
		
		BufferedReader br = new BufferedReader(new FileReader( file ));
		
		// Check if this is an event description
		line = br.readLine();
		
		if( !line.equals( "EVENT_DESCRIPTION" ) )
		{
			template.setValid( false );
			return template;
		}		
		
		// Check version number
		line = br.readLine();
		
		if( !line.equals( "1.0" ) )
		{
			template.setValid( false );
			return template;
		}
		
		// Read event description
		String name = br.readLine();
		
		template.setFilepath( file.getAbsolutePath() );
		template.setName( name );

		String sRelativeOffset;
		String sTime;
		String sName;
		String sDescription;
		
		// Read events
		try
		{
			String sCurrentLine;
			
			// Get empty line
			if( (sCurrentLine = br.readLine()) == null )
			{
				throw new Exception( "Missing empty line" );
			}
			if( !sCurrentLine.equals( "" ) )
			{
				throw new Exception( "Expected empty line was not empty" );
			}			
			
			while( (sCurrentLine = br.readLine()) != null )
			{
				sRelativeOffset = sCurrentLine;
				sTime 			= br.readLine();
				sName 			= br.readLine();
				sDescription 	= br.readLine();
				
				// Get empty line
				if( (sCurrentLine = br.readLine()) == null )
				{
					throw new Exception( "Missing empty line" );
				}
				if( !sCurrentLine.equals( "" ) )
				{
					throw new Exception( "Expected empty line was not empty" );
				}
				
				if( sTime == null )
					throw new Exception( "Time not valid" );
				
				if( sName == null )
					throw new Exception( "Name not valid" );
				
				if( sDescription == null )
					throw new Exception( "Description not valid" );
				
				/*
				System.out.println( "Offset: " + sRelativeOffset );
				System.out.println( "Time: " + sTime );
				System.out.println( "Name: " + sName );
				System.out.println( "Description: " + sDescription );
				*/
				
				RelativeToDo todo = new RelativeToDo();
				
				todo.setName( sName );
				todo.setDescription( sDescription );
				todo.setRelativeOffsetInDays( Integer.parseInt( sRelativeOffset ) );
				
				if( sTime.equals( "-" ) )
				{
					todo.setHours( 0 ); 
					todo.setIsAllDay( true );	
				}
				else
				{
					todo.setHours( Integer.parseInt( sTime ) );
					todo.setIsAllDay( false );
				}
				
				template.addRelativeToDo( todo );
			}
		}
		catch( Exception e )
		{
			System.out.println( "Failed to parse file: " + e.getMessage() );
			
			template.setValid( false );
			return template;
		}
		
		template.setValid( true );
		
//		System.out.println( "Finished parsing" );
		
		return template;
	}

}
