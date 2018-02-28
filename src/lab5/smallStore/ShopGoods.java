package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class ShopGoods extends Event{
	private double timeNextEvent;
	private SmallStoreState state;
	private Customer customer; 
	
	public ShopGoods(SmallStoreState state, double timeToEx, Customer customer) {
		this.timeToEx = timeToEx;
		this.state = state;
		this.customer = customer;
		state.eventQueue.queue.add(this);
//		addToEventQueue(this);
		
	}
	
	protected void performEvent() {
		if(state.regQueue.isEmpty() && state.regQueue.freeRegisters>0) {
			name = "Customer goes to pay";
			state.eventHappened(customer);
			double tempPay = state.timeKeeper.calcPay();
			state.totTimeInReg += tempPay;
			timeNextEvent = state.timeElapsed + tempPay;
			new CustomerPays(state, timeNextEvent, customer);
		}
		else {
			name = "No free registers, moves to queue";
			state.eventHappened();
			state.regQueue.add(customer);
		
		}
	}
	int getCustomerID() {
		return customer.getCustomerID();
	}
	
}
