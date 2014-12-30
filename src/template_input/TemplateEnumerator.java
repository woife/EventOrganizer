package template_input;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Vector;

import event_handling.EventTemplate;
import event_handling.RelativeToDo;

public class TemplateEnumerator {

	private Vector<EventTemplate> TemplateList;
	
	public TemplateEnumerator()  throws IOException
	{
		TemplateList = new Vector<EventTemplate>(1);
		
		Reload();
	}
	
	public void Reload() throws IOException
	{
		File dir = new File("./event_templates");
		File[] files = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".txt");
		    }
		});
		
		for(File file : files)
		{
		    EventTemplate tmp = TemplateFileParser.ParseFile( file );
		    
		    if( tmp.isValid() )
		    {
		    	TemplateList.add( tmp );
		    }
		}
	}
	
	public Vector<EventTemplate> GetTemplateList()
	{
		return TemplateList;
	}
	
	public String[] GetDescStringArray()
	{
		if( TemplateList.size() == 0 )
		{
			String[] str = new String[1];
			str[0] = "No template files found";
			
			return str;
		}
		
		String str[] = new String[TemplateList.size()];

		for( int i = 0; i < TemplateList.size(); i++ )
		{
			str[i] = TemplateList.get(i).getName();
		}
		
		return str;
	}
	
	public String GetStringAt( int idx )
	{
		if
		(
			( idx >= 0 )	&&
			( idx <  TemplateList.size() )
		)
		{
			return TemplateList.get( idx ).getName();
		}
		else
		{
			return "";
		}
	}
}
