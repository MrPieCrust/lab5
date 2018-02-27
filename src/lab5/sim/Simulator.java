package lab5.sim;

import lab5.smallStore.SmallStoreState;

public class Simulator { 
	private SmallStoreState state;
	private EventQueue eventQueue;
	public Simulator() {
		this.state= new SmallStoreState();
		this.eventQueue =new EventQueue();
	}
	public void run() {
		while (state.stopFlag==false) {
			while (eventQueue.eventQueue.size()>0) {
				eventQueue.sortList();				
				eventQueue.eventQueue.get(0).performEvent();

			}
		}
	}

}
