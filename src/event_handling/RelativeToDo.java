package event_handling;

public class RelativeToDo extends BasicToDo {

	private int		relativeOffsetInDays;
	private	int		hours;
	
	public RelativeToDo() {
		// TODO Auto-generated constructor stub
	}

	public int getRelativeOffsetInDays() {
		return relativeOffsetInDays;
	}

	public void setRelativeOffsetInDays(int relativeOffsetInDays) {
		this.relativeOffsetInDays = relativeOffsetInDays;
	}
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
}
