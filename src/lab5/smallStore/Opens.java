package lab5.smallStore;

import lab5.sim.Event;

public class Opens extends Event{
	
	public Opens(SmallStoreState state) {
		this.state = state;
		this.timeKeeper = state.timeKeeper;
		timeToEx = 0;
		new CustomerArrives(state).preformEvent();
	}
}
