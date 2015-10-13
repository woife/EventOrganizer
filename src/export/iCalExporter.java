package export;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.DateStart;
import biweekly.util.Duration;
import biweekly.util.Recurrence;
import biweekly.util.Recurrence.Frequency;
import event_handling.AbsoluteToDo;
import event_handling.EventSchedule;

public class iCalExporter {

	public iCalExporter() {

	}
	
	public static void ExportSchedule( EventSchedule schedule, File file )
	{
		
		ICalendar ical = new ICalendar();
		
		for( AbsoluteToDo todo : schedule.getToDos() )
		{
			VEvent event = new VEvent();
			
			if( todo.isAllDay() )
			{
				event.setDateStart(new DateStart(todo.getDateTime().toDate(), false));
				event.setDuration(new Duration.Builder().days(1).build());
			}
			else
			{
				event.setDateStart(new DateStart(todo.getDateTime().toDate()));
				event.setDuration(new Duration.Builder().hours(1).build());
			}
			
			event.setSummary( todo.getName() );
			event.setDescription( todo.getDescription() );

			ical.addEvent(event);			
		}
		
		// Write to file
		try
		{
			Biweekly.write(ical).go(file);	
		}
		catch( IOException e )
		{
			System.out.println( "Failed to export iCal file." );
		}
	}
}
