package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class ShopGoods extends Event{
	private double timeToEx;
	private double timeNextEvent;
	private SmallStoreState state;
	private TimeKeeper timeKeeper;
	private Customer customer;
	
	public ShopGoods(SmallStoreState state, double timeToEx, Customer customer) {
		this.timeToEx = timeToEx;
		this.state = state;
		this.customer = customer;
		state.timeKeeper = timeKeeper;
		addToEventQueue();
		
	}
	
	public double getExTime() {
		return timeToEx;
	}
	void preformEvent() {
		state.eventHappened();
		timeNextEvent = state.timeElapsed + timeKeeper.calcPay();
		new CustomerPays(state, timeNextEvent, customer);
	}
	
}
