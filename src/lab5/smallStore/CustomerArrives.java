package lab5.smallStore;

import java.util.ArrayList;

import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;

public class CustomerArrives {
	private CreateCustomer customerFactory;
	private ArrayList<Customer> allCustomers;
	
	private void createCustomer() {
		allCustomers.add((customerFactory).newCustomer());
	}
}
