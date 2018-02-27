package lab5.sim;

import java.util.ArrayList;
import java.util.Collections;

public class EventQueue {
	public ArrayList<Event> eventQueue;
	
	public EventQueue() {
		
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

		for(Event event : eventQueue) {
			temp.add(event.getExTime());
		}
		Collections.sort(temp);
		for(double exTime : temp) {
			for(Event event : eventQueue) {
				if(exTime==event.getExTime()) {
					sortedQueue.add(event);
				}
			}
		}
		return sortedQueue;
	}
	public Event getEvent() {
		eventQueue = sort();
		return eventQueue.get(0);
	}
//	void sortList() {
//		for (int i=0;i<eventQueue.size();i++) {
//			
//		}
//	}
}
