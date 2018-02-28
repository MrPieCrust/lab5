package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class CustomerPays extends Event{
	private Customer customer;
	
	public CustomerPays(SmallStoreState state, double timeToEx, Customer customer) {
		this.state = state;
		this.timeToEx = timeToEx;
		name = "Payed at the register";
		addToEventQueue(this);
	}
	
	protected void performEvent() {
		state.eventHappened(customer);
		state.numberOfCustomersNow--;
		state.payedCustomers++;
		state.regQueue.freeRegisters++;
		if(state.regQueue.size()>0) {
			state.regQueue.removeFirst();			
		}
		else if (state.regQueue.freeRegisters>1){
			state.regQueue.openRegisters--;
		}
		else {
			
		}
	}
}
