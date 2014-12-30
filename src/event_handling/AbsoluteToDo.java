package event_handling;

import java.util.Date;

import org.joda.time.DateTime;

public class AbsoluteToDo extends BasicToDo {

	private DateTime dateTime;
	private Boolean  isAllDay;
	
	public AbsoluteToDo( RelativeToDo relToDo, Date eventDate ) {

		setName( relToDo.getName() );
		setDescription( relToDo.getDescription() );
		
		dateTime = new DateTime( eventDate );
		dateTime = dateTime.plusDays( relToDo.getRelativeOffsetInDays() );
		
		if( relToDo.isAllDay() )
		{
			dateTime = dateTime.withHourOfDay( 0 );
			dateTime = dateTime.withMinuteOfHour( 0 );
		}
		else
		{
			dateTime = dateTime.withHourOfDay( relToDo.getHours() );
			dateTime = dateTime.withMinuteOfHour( 0 );
		}
		setIsAllDay( relToDo.isAllDay() );
	}
	
	public DateTime getDateTime()
	{
		return dateTime;
	}
}
