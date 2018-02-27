package lab5.smallStore;

public class CustomerPays {
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
