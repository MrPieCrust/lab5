package lab5.sim;

public class Event {
	protected String name;
	
	public void addElapsedTime(double currentTime){
		State.timeElapsed+=currentTime;
	}
	
	public String getName() {
		return name;
	}
	
	protected void performEvent() {
		
	}
}
