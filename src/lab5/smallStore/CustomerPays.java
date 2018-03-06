package lab5.smallStore;

import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

/**
 * The Class CustomerPays represents the event of a customer paying at the
 * register. When the performEvent is called the state is changed and the
 * customer has payed.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg.
 *
 */
public class CustomerPays extends Event {
	private Customer customer;
	private int custID;

	/**
	 * The constructor creates the event and adds it to the queue
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 * @param timeToEx
	 *            - The time for when the event is to be executed
	 * @param customer
	 *            - The customer that the event concerns
	 */
	public CustomerPays(SmallStoreState state, double timeToEx, Customer customer) {
		this.state = state;
		this.timeToEx = timeToEx;
		name = "Payed";
		addToEventQueue(this);
		custID = customer.getCustomerID();
	}
	/**
	 * The method performEvent executes the code for the specific event.
	 * 
	 * This method decreases numberOfCustomers by 1 and increases payedCustomers
	 * and freeRegisters by 1
	 * 
	 * If the FIFO has customers it calls the method removeFirst
	 * 
	 * If there are more than 1 free register this number is decreased by one
	 */
	protected void performEvent() {
		state.eventHappened(this);
		state.numberOfCustomersNow--;
		state.payedCustomers++;
		state.regQueue.addFreeReg();
	}

	/**
	 * returns the ID of a customer
	 * 
	 * @return - An int custID that represents the customer ID
	 */
	public int getCustID() {
		return custID;
	}
}
