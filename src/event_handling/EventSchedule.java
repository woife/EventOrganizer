package event_handling;

import java.util.Date;
import java.util.Vector;

public class EventSchedule {

	private String	name;
	private Vector<AbsoluteToDo> todos;
	
	public EventSchedule( String eventName, EventTemplate template, Date eventDate ) {
		
		setName( eventName );
		
		todos = new Vector<AbsoluteToDo>(10);
		for( RelativeToDo relToDo : template.getRelativeToDos() )
		{
			AbsoluteToDo	todo = new AbsoluteToDo( relToDo, eventDate );
		
			todos.add( todo );
		}
	}
	
	public Vector<AbsoluteToDo>getToDos()
	{
		return todos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
