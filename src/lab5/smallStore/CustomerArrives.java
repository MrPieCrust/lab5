package lab5.smallStore;

import java.util.ArrayList;

import lab5.sim.Event;
import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;

public class CustomerArrives extends Event{
	private CreateCustomer customerFactory;
	ArrayList<Customer> allCustomers;
	private double timeNextEvent;
	
	public CustomerArrives(SmallStoreState state) {
		this.state = state;
		this.customerFactory = state.customerFactory;
		timeKeeper = state.timeKeeper;
		timeToEx = timeKeeper.calcNextCustomer();
		name = "Arrives";
	}
	
	void preformEvent() {
		state.eventHappened();

		if (state.currentTime >= state.closingTime) {	
		}
		else if(!state.isFull()) {
			createCustomer();
			
		}
		else {
			state.missedCustomers++;
		}
	}
	
	private void createCustomer() {
		allCustomers.add(customerFactory.newCustomer());
		timeNextEvent = timeKeeper.calcShop();
		new ShopGoods(state, timeNextEvent);
		
	}
}
