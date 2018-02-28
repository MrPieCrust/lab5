package lab5.smallStore.customer;

public class Customer {
	private int ID;
	public double timeQueued;
	
	
	Customer(int ID){
		this.ID = ID;
	}
	public int getCustomerID() {
		return ID;
	}
}
