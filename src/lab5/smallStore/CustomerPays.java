package lab5.smallStore;
import lab5.sim.Event;

public class CustomerPays extends Event{
	private SmallStoreState state;
	private double timeToEx;
	private TimeKeeper timeKeeper;
	
	public CustomerPays(SmallStoreState state, double timeToEx) {
		this.state = state;
		this.timeToEx = timeToEx;
		state.timeKeeper = timeKeeper;
	}
	
	public double getExTime() {
		return timeToEx;
	}
	
	void preformEvent() {
		if(state.regQueue.isEmpty()) {
			
		}
	}
}
