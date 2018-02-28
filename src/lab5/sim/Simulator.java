package lab5.sim;

import lab5.smallStore.SmallStoreState;

public class Simulator { 
	private SmallStoreState state;
	private EventQueue eventQueue;
	
	public Simulator() {
		this.state= new SmallStoreState();
		this.eventQueue = state.eventQueue;
	}
	public void run() {
		while (state.stopFlag==false) {
			while (eventQueue.queue.size()>0) {
				eventQueue.getEvent().performEvent();

			}
		}
	}

}
