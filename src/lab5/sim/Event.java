package lab5.sim;

import lab5.smallStore.SmallStoreState;

public class Event {
	protected String name;
	protected SmallStoreState state;
	protected double timeToEx;
	
	public String getName() {
		return name;
	}
	public double getExTime() {
		return timeToEx;
	}
	protected void addToEventQueue(Event event) {
		state.eventQueue.queue.add(event);

	}
	protected void performEvent() {
		
	}
	
}
