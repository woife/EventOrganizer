package template_input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TemplateParser {

	public static TemplateDesc ParseFile( File file ) throws IOException
	{
		String line;
		TemplateDesc desc = new TemplateDesc();		
		
		BufferedReader br = new BufferedReader(new FileReader( file ));
		
		// Check if this is an event description
		line = br.readLine();
		
		if( !line.equals( "EVENT_DESCRIPTION" ) )
		{
			return desc;
		}		
		
		// Check version number
		line = br.readLine();
		
		if( !line.equals( "1.0" ) )
		{
			return desc;
		}
		
		// Read event description
		String Description = br.readLine();
		
		desc.SetFilepath( file.getAbsolutePath() );
		desc.SetDescription( Description );
		
		
		desc.SetValid( true );
		
		return desc;
	}

}
