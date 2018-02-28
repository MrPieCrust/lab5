package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class ShopGoods extends Event{
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
	
	void preformEvent() {
		if(state.regQueue.isEmpty() && state.regQueue.freeRegisters>0) {
			name = "Customer goes to pay";
			state.eventHappened();
			double tempPay = timeKeeper.calcPay();
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
