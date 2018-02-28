package lab5.smallStore;
import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

public class ShopGoods extends Event{
	private double timeNextEvent;
	private SmallStoreState state;
	private Customer customer; 
	private int custID;
	
	public ShopGoods(SmallStoreState state, double timeToEx, Customer customer) {
		this.timeToEx = timeToEx;
		this.state = state;
		this.customer = customer;
		state.eventQueue.queue.add(this);
		custID = customer.getCustomerID();
//		addToEventQueue(this);
		
	}
	
	protected void performEvent() {
		if(state.regQueue.isEmpty() && state.regQueue.freeRegisters>0) {
			name = "Goods";
			state.eventHappened(this);
			double tempPay = state.timeKeeper.calcPay();
			state.totTimeInReg += tempPay;
			timeNextEvent = state.timeElapsed + tempPay;
			new CustomerPays(state, timeNextEvent, customer);
			state.regQueue.freeRegisters--;
		}
		else {
			name = "Goods";
			state.eventHappened(this);
			state.regQueue.add(customer);
		
		}
	}

	public int getCustID() {
		return custID;
	}
}
