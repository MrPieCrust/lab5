package lab5.smallStore;

import java.util.ArrayList;

import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;

public class CustomerArrives {
	private CreateCustomer customerFactory;
	ArrayList<Customer> allCustomers;
	private final String name = "Arrives";
	private TimeKeeper timeKeeper;
	private double timeToEx;
	private double timeNextEvent;
	private SmallStoreState state;
	
	public CustomerArrives(SmallStoreState state) {
		this.state = state;
		this.customerFactory = state.customerFactory;
		this.timeKeeper = state.timeKeeper;
		timeToEx = timeKeeper.calcNextCustomer();
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
	public double getExTime() {
		return timeToEx;
	}
	public String getName() {
		return name;
	}
}
