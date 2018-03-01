package lab5.smallStore;

import lab5.sim.Event;
/**
 * The Class Opens represents the event that the store opens
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg.
 *
 */
public class Opens extends Event{
	/**
	 * The Constructor creates a CustomerArrives event that should execute directly
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 */
	public Opens(SmallStoreState state) {
		timeToEx = 0;
		name = "Opens";
		state.eventHappened(this);
		new CustomerArrives(state, "förstakunden");
		state.status = "Ö";
		new Closes(state);
	}
}
