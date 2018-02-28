package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class CustomerPays extends Event{
	private Customer customer;
	private int custID;
	
	public CustomerPays(SmallStoreState state, double timeToEx, Customer customer) {
		this.state = state;
		this.timeToEx = timeToEx;
		name = "Payed";
		addToEventQueue(this);
		custID = customer.getCustomerID();
	}
	
	protected void performEvent() {
		state.eventHappened(this);
		state.numberOfCustomersNow--;
		state.payedCustomers++;
		state.regQueue.freeRegisters++;
		if(state.regQueue.size()>0) {
			state.regQueue.removeFirst();			
		}
		else if (state.regQueue.freeRegisters>1){
			state.regQueue.openRegisters--;
			state.regQueue.freeRegisters--;
		}
		else {
			
		}
	}
	public int getCustID() {
		return custID;
	}
}
