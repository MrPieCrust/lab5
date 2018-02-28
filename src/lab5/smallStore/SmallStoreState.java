package lab5.smallStore;


import java.util.ArrayList;

import lab5.sim.EventQueue;
import lab5.sim.State;
import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;

public class SmallStoreState extends State {
	int freeRegisters;
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
	public final int maxCustomers = 20;
	public final int maxRegisters = 4;
	public final double closingTime = 500;
	public final double uniformLowerShop = 10;
	public final double uniformUpperShop = 20;
	public final double uniformLowerPay = 5;
	public final double uniformUpperPay = 10;
	public final double exponentLambda = 4;
	CreateCustomer customerFactory;
	FIFO regQueue;
	SmallStoreView storeView;
	TimeKeeper timeKeeper;
	public EventQueue eventQueue;
	ArrayList<Customer> allCustomer;
	
	
	public SmallStoreState() {
		freeRegisters = maxRegisters;
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
	void eventHappened() {
		setChanged();
		notifyObservers();
		}

}
