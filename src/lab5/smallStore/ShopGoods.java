package lab5.smallStore;
import lab5.sim.Event;

public class ShopGoods extends Event{
	private double timeToEx;
	private double timeNextEvent;
	private SmallStoreState state;
	private TimeKeeper timeKeeper;
	
	public ShopGoods(SmallStoreState state, double timeToEx) {
		this.timeToEx = timeToEx;
		this.state = state;
		state.timeKeeper = timeKeeper;
		
	}
	
	public double getExTime() {
		return timeToEx;
	}
	void preformEvent() {
		timeNextEvent = timeKeeper.calcPay();
		new CustomerPays(state, timeNextEvent);
	}
	
}
