package lab5.smallStore;
import lab5.sim.Event;
/**
 * The Class Closes represents the event of the store closing
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg.
 *
 */
public class Closes extends Event{
	
	/**
	 * The Constructor creates the event and adds it to the queue.
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 */
	public Closes(SmallStoreState state) {
		this.state = state;
		timeToEx = state.closingTime;
		name = "Closes";
		addToEventQueue(this);
	}
	/**
	 * The method performEvent executes the code for the specific event.
	 * 
	 * This event changes the status of the store to closed and changes the stopflag to true.
	 */
	protected void performEvent() {
		state.eventHappened(this);
		state.status = "S";
		state.stopFlag = true;
	}
}
