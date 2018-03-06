package lab5.smallStore;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import lab5.smallStore.customer.Customer;

/**
 * The class FIFO represents a queue system based an the "First In First Out"
 * system
 * 
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg.
 */
public class FIFO {
	private ArrayList<Customer> regQueue = new ArrayList<Customer>();
	private SmallStoreState state;
	int freeRegisters;

	/**
	 * The constructor of the fifo decides the amount of open and free registers the
	 * small store has
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 */
	public FIFO(SmallStoreState state) {
		this.state = state;
		freeRegisters = state.maxRegisters;
	}

	/**
	 * The method add takes a Customer and puts it in the FIFO queue.
	 * 
	 * This increases the amount of people in the queue and the total number of
	 * customers that have queued
	 * 
	 * @param item
	 *            - an object of type customer that is to be added
	 */
	public void add(Customer item) {
		if ((freeRegisters > 0) && isEmpty()) {
			thereWasNoQueue(item);
		} else {
			regQueue.add(item);
			state.numInQueue++;
			state.lengthOfQueue++;
		}
	}

	/**
	 * The method removeFirst takes the person that is first in line in the queue
	 * and creates a CustomerPays event for that person. This also means that the
	 * freeRegisters decreases by one and so does the lengthOfQueue variable.
	 * 
	 * throws a NoSuchElementException if there is no Customer in the FIFO
	 */
	public void thereWasNoQueue(Customer item) {
		double tempPay = state.timeKeeper.calcPay();
		state.totTimeInReg += tempPay;
		double timeNextEvent = state.timeElapsed + tempPay;
		new CustomerPays(state, timeNextEvent, item);
		removeFreeReg();
	}

	/**
	 * removes a free register
	 */
	public void removeFreeReg() {
		freeRegisters--;
	}

	/**
	 * adds a free register but also checks if there's someone in queue
	 */
	public void addFreeReg() {
		if (isEmpty() == false) {
			removeFirst();
		} else {
			freeRegisters++;
		}
	}

	/**
	 * removes the first customer in the fifo line if there is one.
	 */
	public void removeFirst() {
		if (regQueue.size() > 0) {
			double tempPay = state.timeKeeper.calcPay();
			new CustomerPays(state, state.timeElapsed + tempPay, regQueue.get(0));
			regQueue.remove(0);
			state.lengthOfQueue--;

		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Checks if the FIFO is empty
	 * 
	 * @return true if FIFO is empty and false otherwise
	 */
	public boolean isEmpty() {
		if (regQueue.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calculates the size of the FIFO via ArrayList method size()
	 * 
	 * @return Number of Customers in FIFO as an int
	 */
	public int size() {
		return regQueue.size();
	}

	/**
	 * 
	 * @return - the number of free registers.
	 */
	public int getFreeReg() {
		return freeRegisters;
	}

	/**
	 * 
	 * @return - true if there is a free register, false otherwise.
	 */
	public boolean isRegFree() {
		if (freeRegisters > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The method toString returns out the customerID for every customer in the FIFO
	 * ex. [1,5,3,6]
	 * 
	 * @return - the fifo queue
	 */
	public String toString() {
		String count = "[";
		for (int i = 0; i < regQueue.size(); i++) {
			if (count.length() == 1) {
				count += String.valueOf(regQueue.get(i).getCustomerID());
			} else if (count.length() > 1) {
				count += "," + String.valueOf(regQueue.get(i).getCustomerID());

			}

		}
		count += "]";
		return count;
	}

}
