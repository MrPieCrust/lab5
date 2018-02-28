package lab5.smallStore;


import java.util.ArrayList;

import lab5.sim.Event;
import lab5.sim.EventQueue;
import lab5.sim.State;
import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;

public class SmallStoreState extends State {
	double totTimeInReg = 0;
	double totTimeInQueue = 0;
	int numberOfCustomers = 0;
	int numberOfCustomersNow = 0;
	int payedCustomers = 0;
	int missedCustomers = 0;
	int numInQueue = 0;
	int lengthOfQueue = 0;
	double avTimeReg = 0;
	double avTimeQueue = 0;
	String status;
	public final int maxCustomers = 5;
	public final int maxRegisters = 2;
	public final double closingTime = 10;
	public final double uniformLowerShop = 0.5;
	public final double uniformUpperShop = 1.0;
	public final double uniformLowerPay = 2.0;
	public final double uniformUpperPay = 3.0;
	public final double exponentLambda = 1;
	CreateCustomer customerFactory;
	FIFO regQueue;
	SmallStoreView storeView;
	TimeKeeper timeKeeper;
	public EventQueue eventQueue;
	ArrayList<Customer> allCustomer;
	
	
	public SmallStoreState() {
		storeView = new SmallStoreView(this);
		regQueue = new FIFO(this);
		customerFactory = new CreateCustomer();
		timeKeeper = new TimeKeeper(this);
		eventQueue = new EventQueue(this);
		this.addObserver(storeView);
		new Opens(this);
		
		
	}
	boolean isFull() {
		if(numberOfCustomers==maxCustomers) {
			return true;
		}
		else {
			return false;
		}
	}
<<<<<<< HEAD
=======
	void eventHappened(Event event) {
		setChanged();
		notifyObservers(event);
		}
>>>>>>> 718833e414b44ab300bd6f8b402becdb12c56fe4
	void eventHappened() {
		setChanged();
		notifyObservers();
		}

}
