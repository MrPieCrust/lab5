package lab5.sim;

import lab5.smallStore.SmallStoreState;
import lab5.smallStore.TimeKeeper;

public class Event {
	protected String name;
	protected SmallStoreState state;
	protected double timeToEx;
	protected TimeKeeper timeKeeper;
	
	public String getName() {
		return name;
	}
	public double getExTime() {
		return timeToEx;
	}
	protected void addToEventQueue() {
		state.eventQueue.eventQueue.add(this);
	}
	protected void performEvent() {
		
	}
	
}
