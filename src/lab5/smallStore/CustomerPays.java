package lab5.smallStore;

public class CustomerPays {
	private SmallStoreState state;
	private double timeToEx;
	private double timeToNext;
	private TimeKeeper timeKeeper;
	
	public CustomerPays(SmallStoreState state, double timeToEx) {
		this.state = state;
		this.timeToEx = timeToEx;
		state.timeKeeper = timeKeeper;
	}
}
