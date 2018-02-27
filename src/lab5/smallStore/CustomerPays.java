package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class CustomerPays extends Event{
	private SmallStoreState state;
	private TimeKeeper timeKeeper;
	
	public CustomerPays(SmallStoreState state, double timeToEx, Customer customer) {
		this.state = state;
		this.timeToEx = timeToEx;
		state.timeKeeper = timeKeeper;
		name = "Payed at the register";
		addToEventQueue();
	}
	
	void preformEvent() {
		state.eventHappened();
		state.numberOfCustomersNow--;
		state.payedCustomers++;
		state.regQueue.freeRegisters++;
		if(state.regQueue.size()>0) {
			state.regQueue.removeFirst();
			
		}
	}
}
