package lab5.smallStore.customer;

/**
 * When a new customer is created, this class assigns its customer an ID.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class CreateCustomer {
	private int ID = 0;

	/**
	 * Assign a ID number for a new customer, ID is then increased by one.
	 * 
	 * @return new customer.
	 */
	public Customer newCustomer() {
		return new Customer(ID++);
	}
}
