package lab5.smallStore;

import lab5.sim.Event;
import lab5.smallStore.customer.Customer;

/**
 * The Class ShopGoods represents the event of a customer shopping for goods in
 * the store When the performEvent is called the state is changed and the
 * customer has shopped.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg.
 *
 */
public class ShopGoods extends Event {
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
	public ShopGoods(SmallStoreState state, double timeToEx, Customer customer) {
		this.timeToEx = timeToEx;
		this.state = state;
		this.customer = customer;
		name = "Goods";
		addToEventQueue(this);
		custID = customer.getCustomerID();
	}

	/**
	 * The method performEvent executes the code for the specific event.
	 * 
	 * The method checks if FIFO is empty and if there are any free registers if
	 * this is the case a new CustomerPays event is created
	 * 
	 * If not the customer is added to the FIFO
	 */
	protected void performEvent() {
		state.eventHappened(this);
		state.regQueue.add(customer);

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
