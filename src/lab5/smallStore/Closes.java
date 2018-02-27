package lab5.smallStore;
import lab5.sim.Event;

public class Closes extends Event{
	
	
	public Closes(SmallStoreState state) {
		this.state = state;
		timeToEx = state.closingTime;
		name = "The Store closes";
	}
}
