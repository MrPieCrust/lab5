package lab5.smallStore;

import lab5.sim.Event;

public class Opens extends Event{
	
	public Opens(SmallStoreState state) {
		timeToEx = 0;
		name = "Opens";
		state.eventHappened(this);
		new CustomerArrives(state, "förstakunden");
		state.status = "Ö";
		new Closes(state);
	}
}
