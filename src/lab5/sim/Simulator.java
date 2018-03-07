package lab5.sim;

import lab5.smallStore.SmallStoreState;

/**
 * Simulation of the program that takes all events that has been performed from
 * the eventQueue.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class Simulator {
	private SmallStoreState state;
//	public SmallStoreState state;
	private EventQueue eventQueue;

	/**
	 * Constructor, creates a new dynamic SmallStoreState object and assigns private
	 * variable eventQueue to the states eventQueue.
	 */
	public Simulator(SmallStoreState state) {
		this.state = state;
		this.eventQueue = state.eventQueue;
	}

	/**
	 * Takes the events from eventQueue and calls performEvent().
	 */
	public void run() {
		while (state.stopFlag == false) {
			while (eventQueue.queue.size() > 0) {
				eventQueue.getEvent().performEvent();

			}
			state.storeView.printResult();

		}
	}
	public void runOptimize() {
		while (state.stopFlag == false) {
			while (eventQueue.queue.size() > 0) {
				eventQueue.getEvent().performEvent();

			}
			state.storeView.printResultOpt();

		}
	}

}
