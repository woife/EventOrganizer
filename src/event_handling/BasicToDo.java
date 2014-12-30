package event_handling;

public class BasicToDo {

	private	String	Name;
	private String	Description;
	private Boolean	allDay;
	
	public BasicToDo() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Boolean isAllDay() {
		return allDay;
	}

	public void setIsAllDay(Boolean isAllDay) {
		allDay = isAllDay;
	}
}
