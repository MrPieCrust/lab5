package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class CustomerPays extends Event{
	private SmallStoreState state;
	private double timeToEx;
	private TimeKeeper timeKeeper;
	private Customer customer;
	
	public CustomerPays(SmallStoreState state, double timeToEx, Customer customer) {
		this.state = state;
		this.timeToEx = timeToEx;
		this.customer = customer;
		state.timeKeeper = timeKeeper;
		addToEventQueue();
	}
	
	public double getExTime() {
		return timeToEx;
	}
	
	void preformEvent() {
		state.eventHappened();
		if(state.regQueue.isEmpty()) {
			
		}
		else {
			state.regQueue.add(customer);
		}
	}
}
