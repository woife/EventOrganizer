package event_handling;

import java.util.Vector;

public class EventTemplate {
	
	private String	filepath;
	private String	name;
	private Boolean	valid;
	
	private Vector<RelativeToDo> todos;
	
	public EventTemplate()
	{
		valid = false;
		
		todos = new Vector<RelativeToDo>(2);
	}	
	
	public EventTemplate( String filepath, String name )
	{
		this.filepath	= filepath;
		this.name		= name;
		
		valid = true;
	}
	
	public void setFilepath( String filepath )
	{
		this.filepath = filepath;
	}
	
	public void setName( String name )
	{
		this.name = name;
	}
	
	public void setValid( Boolean valid )
	{
		this.valid = valid;
	}
	
	public String setFilepath()
	{
		return filepath;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addRelativeToDo( RelativeToDo todo )
	{
		todos.add( todo );
	}
	
	public Vector<RelativeToDo> getRelativeToDos()
	{
		return todos;
	}
	
	public Boolean isValid()
	{
		return valid;
	}
}
