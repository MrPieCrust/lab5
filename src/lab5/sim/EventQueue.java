package lab5.sim;

import java.util.ArrayList;
import java.util.Collections;
import lab5.sim.*;
import lab5.smallStore.Closes;
import lab5.smallStore.FIFO;
import lab5.smallStore.SmallStoreState;

/**
 * Keeps track of all events and sort them after time executed.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class EventQueue {
	public ArrayList<Event> queue;
	private SmallStoreState state;

	/**
	 * Constructor, keeps parameter intern and creates a new ArrayList with an
	 * appropriate pointer.
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 */
	public EventQueue(SmallStoreState state) {
		this.state = state;
		queue = new ArrayList<Event>();
	}

	/**
	 * First creates a new temporary ArrayList with the exTimes then sorts them and
	 * puts them back in the right order for the eventQueue
	 * 
	 * @return The sorted eventQueue
	 */
	private ArrayList<Event> sort() {
		ArrayList<Double> temp = new ArrayList<Double>();
		ArrayList<Event> sortedQueue = new ArrayList<Event>();

		for (Event event : queue) {
			temp.add(event.getExTime());
		}
		Collections.sort(temp);
		for (double exTime : temp) {
			for (Event event : queue) {
				if (exTime == event.getExTime()) {
					sortedQueue.add(event);
				}
			}
		}
		return sortedQueue;
	}

	/**
	 * Gets the event from the queue that's in the first place.
	 * 
	 * @return event that should be performed.
	 */
	public Event getEvent() {
		queue = sort();
		double timeBetween = queue.get(0).getExTime() - state.timeElapsed;
		state.timeElapsed = queue.get(0).getExTime();
		
		if (queue.size() > 0) {
			if(state.isfree()) {
				state.totTimeFreeReg += timeBetween * state.regQueue.getFreeReg();
			}
			return queue.remove(0);
		}
		else {

			return new Closes(state);
		}
//	}

	}}
