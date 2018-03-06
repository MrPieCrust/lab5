package lab5.smallStore;

import lab5.sim.Event;
import lab5.smallStore.customer.CreateCustomer;

/**
 * The Class CustomerArrives represents the event of a customer arriving to the
 * store. When the performEvent is called the state is changed and a customer is
 * created.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg.
 *
 */
public class CustomerArrives extends Event {
	private CreateCustomer customerFactory;
	private double timeNextEvent;
	private int custID;

	/**
	 * The first constructor assigns a time when the event is to be executed and
	 * adds it to the queue
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 */
	public CustomerArrives(SmallStoreState state) {
		this.state = state;
		this.customerFactory = state.customerFactory;
		timeToEx = state.timeElapsed + state.timeKeeper.calcNextCustomer();
		name = "Arrives";
		addToEventQueue(this);
		this.custID = state.allCustomer.size();
	}

	/**
	 * Does the same as previous constructor with the exception that the time to be
	 * executed is set to 0.
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 * @param first
	 *            - a dummy variable so that when the first customer arrives this
	 *            constructor is called
	 */
	public CustomerArrives(SmallStoreState state, String first) {
		this.state = state;
		this.customerFactory = state.customerFactory;
		timeToEx = 0;
		name = "Arrives";
		addToEventQueue(this);
	}

	/**
	 * The method performEvent executes the code for the specific event.
	 * 
	 * This event checks is the store is full if it is missed customers are
	 * increased and a new event of CustomerArrives is created
	 * 
	 * If not, a new customer is created and a new event of CustomerArrives is
	 * created
	 */
	protected void performEvent() {
		if (state.allCustomer.size() > 0) {
			state.eventHappened(this);
		}
		if (state.timeElapsed >= state.closingTime) {
		} else if (!state.isFull()) {
			createCustomer();
			new CustomerArrives(state);
		} else {
			state.missedCustomers++;
			new CustomerArrives(state);
		}
	}

	private void createCustomer() {
		state.allCustomer.add(customerFactory.newCustomer());
		timeNextEvent = state.timeElapsed + state.timeKeeper.calcShop();
		state.numberOfCustomersNow++;
		state.numberOfCustomers++;
		new ShopGoods(state, timeNextEvent, state.allCustomer.get(custID));

	}

	/**
	 * This method returns the ID for the customer that the event concerns
	 * 
	 * @return - An int custID that represents the customer ID
	 */
	public int getCustID() {
		return custID;
	}
}
