package lab5.smallStore.customer;

public class CreateCustomer {
	private int ID = 0;
	
	public Customer newCustomer() {
		return new Customer(ID++);
	}
}
