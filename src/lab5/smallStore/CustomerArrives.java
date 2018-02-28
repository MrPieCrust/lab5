package lab5.smallStore;

import java.util.ArrayList;

import lab5.sim.Event;
import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;

public class CustomerArrives extends Event {
	private CreateCustomer customerFactory;
	private double timeNextEvent;
	private int custID;

	public CustomerArrives(SmallStoreState state) {
		this.state = state;
		this.customerFactory = state.customerFactory;		
		timeToEx = state.timeElapsed + state.timeKeeper.calcNextCustomer();
		name = "Arrives";
		addToEventQueue(this);
	}

	public CustomerArrives(SmallStoreState state, String first) {
		this.state = state;
		this.customerFactory = state.customerFactory;
		timeToEx = 0;
		name = "Arrives";
		addToEventQueue(this);
	}

	protected void performEvent() {
		if (state.allCustomer.size() > 0) {
			state.eventHappened(this);
		}
		if (state.timeElapsed >= state.closingTime) {
			System.out.println("print");
		} else if (!state.isFull()) {
			createCustomer();
//			state.newCustomer();
			new CustomerArrives(state);
		} else {
			state.missedCustomers++;
			new CustomerArrives(state);
		}
	}

	private void createCustomer() {
		state.allCustomer.add(customerFactory.newCustomer());
		timeNextEvent = state.timeElapsed + state.timeKeeper.calcShop();
		int custID = state.allCustomer.size() - 1;
		this.custID = custID;
		state.numberOfCustomersNow++;
		state.numberOfCustomers++;
		new ShopGoods(state, timeNextEvent, state.allCustomer.get(custID));

	}
	public int getCustID() {
		return custID;
	}
}
