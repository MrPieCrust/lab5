package lab5.sim;

import java.util.ArrayList;
import java.util.Collections;

import lab5.smallStore.Closes;
import lab5.smallStore.SmallStoreState;

public class EventQueue {
<<<<<<< HEAD
	public ArrayList<Event> eventQueue;
=======
	public ArrayList<Event> queue;
	private SmallStoreState state;
	
	public EventQueue(SmallStoreState state) {
		this.state = state;
		queue = new ArrayList<Event>();
	}
>>>>>>> ce5c124727884b4ea3e416376b2cf958a9cc4bb0
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
		state.timeElapsed = queue.get(0).getExTime();
		if(queue.size()>0) {
		return queue.remove(0);
		}
		else {
			return new Closes(state);
		}
	}
//	void sortList() {
//		for (int i=0;i<eventQueue.size();i++) {
//			
//		}
//	}
}
