package lab5.smallStore;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.naming.TimeLimitExceededException;

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
	int openRegisters;

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
		openRegisters = 2;
		freeRegisters = 2;

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
		regQueue.add(item);
		item.timeQueued = state.timeElapsed;
		state.numInQueue++;
		state.lengthOfQueue++;
	}

	/**
	 * The method removeFirst takes the person that is first in line in the queue
	 * and creates a CustomerPays event for that person. This also means that the
	 * freeRegisters decreases by one and so does the lengthOfQueue variable.
	 * 
	 * throws a NoSuchElementException if there is no Customer in the FIFO
	 */
	public void removeFirst() {
		if (regQueue.size() > 0) {
			double tempPay = state.timeKeeper.calcPay();
			state.totTimeInReg += tempPay;
			new CustomerPays(state, state.timeElapsed + tempPay, regQueue.get(0));
			regQueue.get(0).timeQueued = state.timeElapsed - regQueue.get(0).timeQueued;
			state.totTimeInQueue += regQueue.get(0).timeQueued;
			regQueue.remove(0);
			state.lengthOfQueue--;
			freeRegisters--;

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


	public void regStat() {
		
	}
	public int getFreeReg() {
		return freeRegisters;
	}
	

	public void removeFromReg() { // fråga sam om denna. har han inte använt den kan ni ta bort.

		freeRegisters--;
	}

	/**
	 * The method toString prints out the customerID for every customer in the FIFO
	 * ex. [1,5,3,6]
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
