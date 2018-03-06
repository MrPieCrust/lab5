package lab5.smallStore.customer;

/**
 * Represents customers and keeps track of each customers ID number.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class Customer {
	private int ID;

	Customer(int ID) {
		this.ID = ID;
	}

	/**
	 * To get customer ID.
	 * 
	 * @return ID number of a customer.
	 */
	public int getCustomerID() {
		return ID;
	}
}
