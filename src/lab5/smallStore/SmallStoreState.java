package lab5.smallStore;


import java.util.ArrayList;

import lab5.sim.Event;
import lab5.sim.EventQueue;
import lab5.sim.State;
import lab5.smallStore.customer.CreateCustomer;
import lab5.smallStore.customer.Customer;
	/**
	 * The Class SmallStoreState keeps track of the state of the simulation
	 * Every time the state changes SmallStoreView gets updated
	 * 
	 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg. 
	 *
	 */
public class SmallStoreState extends State {
	public double totTimeFreeReg = 0;
	public double totTimeOccReg = 0;
	double totTimeInReg = 0;
	double totTimeInQueue = 0;
	int numberOfCustomers = 0;
	int numberOfCustomersNow = 0;
	int payedCustomers = 0;
	int missedCustomers = 0;
	int numInQueue = 0;
	int lengthOfQueue = 0;//kanske ta bort denna och används regQueue.size()??
	double avTimeReg = 0;
	double avTimeQueue = 0;
	String status;
	public final int maxCustomers = 10;
	public final int maxRegisters = 2;
	public final double closingTime = 10;
	public final double uniformLowerShop = 2.0;
	public final double uniformUpperShop = 3.0;
	public final double uniformLowerPay = 0.5;
	public final double uniformUpperPay = 1.0;
	public final double exponentLambda = 3;
	CreateCustomer customerFactory;
	public FIFO regQueue;
	public SmallStoreView storeView;
	TimeKeeper timeKeeper;
	public EventQueue eventQueue;
	ArrayList<Customer> allCustomer = new ArrayList<Customer>();
	
	/**
	 * The Constructor creates a new FIFO, CreateCustomer, TimeKeeper, EventQueue and SmallStoreView
	 * and assigns appropriate pointers for them. 
	 * It also assigns storeView as an Observer for the state and creates a new event of type Opens
	 */
	public SmallStoreState() {
		regQueue = new FIFO(this);
		customerFactory = new CreateCustomer();
		timeKeeper = new TimeKeeper(this);
		eventQueue = new EventQueue(this);
		storeView = new SmallStoreView(this);
		this.addObserver(storeView);
		new Opens(this);	
	}
	/**
	 * Checks if the store is full
	 * 
	 * @return true if the store is at full capacity and false otherwise
	 */
	boolean isFull() {
		if(numberOfCustomersNow==maxCustomers) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * If something that changes the state is done this method is called
	 * 
	 * @param event - sends in the event that changes the state as arg1
	 */
	void eventHappened(Event event) {
		setChanged();
		notifyObservers(event);
		}

	
	public boolean isfree() {
		if(regQueue.freeRegisters > 0) {
			return true;
		} else {
			return false;
		}
	}
//	void eventHappened() {
//		setChanged();
//		notifyObservers();
//		}


}
