package lab5.sim;

import lab5.smallStore.SmallStoreState;

/**
 * General class that other classes extends. Contains the method getName(),
 * getExTime(), getCustID().
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class Event {
	protected String name;
	protected SmallStoreState state;
	protected double timeToEx;

	/**
	 * Get the names of each event that have happened.
	 * 
	 * @return name of each event.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the time when an event should be executed.
	 * 
	 * @return the time it takes to execute.
	 */

	public double getExTime() {
		return timeToEx;
	}

	protected void addToEventQueue(Event event) {
		state.eventQueue.queue.add(event);

	}

	protected void performEvent() {

	}

	/**
	 * Customer ID for the first person that arrives to the store.
	 * 
	 * @return 0
	 */
	public int getCustID() {
		return 0;
	}

}
