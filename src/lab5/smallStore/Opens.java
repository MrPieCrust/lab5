package lab5.smallStore;

import lab5.sim.Event;

public class Opens extends Event{
	
	public Opens(SmallStoreState state) {
		timeToEx = 0;
		name = "The Store opens";
		new CustomerArrives(state).preformEvent();
		state.eventHappened();
	}
}
