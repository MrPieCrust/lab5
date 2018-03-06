package lab5.sim;

import java.util.ArrayList;
import java.util.Collections;
import lab5.sim.*;
import lab5.smallStore.Closes;
import lab5.smallStore.FIFO;
import lab5.smallStore.SmallStoreState;

public class EventQueue {
	public ArrayList<Event> eventQueue;
	public ArrayList<Event> queue;
	private SmallStoreState state;
	
	public EventQueue(SmallStoreState state) {
		this.state = state;
		queue = new ArrayList<Event>();
	}

	/**
	 * First creates a new temp ArrayList with the exTimes then sorts them and puts them 
	 * back in the right order for the eventQueue
	 * 
	 * @return The sorted eventQueue
	 */
	private ArrayList<Event> sort() {
		ArrayList<Double> temp = new ArrayList<Double>();
		ArrayList<Event> sortedQueue = new ArrayList<Event>();

		for(Event event : queue) {
			temp.add(event.getExTime());
		}
		Collections.sort(temp);
		for(double exTime : temp) {
			for(Event event : queue) {
				if(exTime==event.getExTime()) {
					sortedQueue.add(event);
				}
			}
		}
		return sortedQueue;
	}
	public Event getEvent() {
		queue = sort();
		state.timeBetween = queue.get(0).getExTime() - state.timeElapsed;
		state.timeElapsed = queue.get(0).getExTime();	
		if (queue.size() > 0) {
			return queue.remove(0);
		}
		else {
			return new Closes(state);
		}
	}
	public ArrayList<Event> getQueue() {
		return queue;
	}
}
