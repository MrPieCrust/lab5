package lab5.smallStore;


import lab5.sim.State;
import lab5.smallStore.customer.CreateCustomer;

public class SmallStoreState extends State {
	String message;
	double currentTime = 0;
	int freeRegisters;
	double totTimeInReg = 0;
	double totTimeInQueue = 0;
	int numberOfCustomers = 0;
	int payedCustomers = 0;
	int missedCustomers = 0;
	int numInQueue = 0;
	int lengthOfQueue = 0;
	double avTimeReg = 0;
	double avTimeQueue = 0;
	public final int maxCustomers = 20;
	public final int maxRegisters = 4;
	public final double closingTime = 15;
	CreateCustomer customerFactory;
	FIFO regQueue;
	SmallStoreView storeView;
	
	public SmallStoreState() {
		freeRegisters = maxRegisters;
		storeView = new SmallStoreView();
		regQueue = new FIFO();
		customerFactory = new CreateCustomer();
		this.addObserver(storeView);
		
		
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
		updateAll();
	}
	private void updateAll() {
		setChanged();
		notifyObservers();
	}

}
