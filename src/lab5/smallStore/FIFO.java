package lab5.smallStore;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.naming.TimeLimitExceededException;

import lab5.smallStore.customer.Customer;

public class FIFO{
	private ArrayList<Customer> regQueue = new ArrayList<Customer>();
	private SmallStoreState state;
	int freeRegisters; 
	int openRegisters;


	public FIFO(SmallStoreState state) {
		this.state = state;
		openRegisters = 1;
		freeRegisters = 1;
		
	}
	public void add(Customer item) {
		regQueue.add(item);
		item.timeQueued = state.timeElapsed;
		state.numInQueue++;
		state.lengthOfQueue++;
		if (regQueue.size() > 2 && openRegisters<state.maxRegisters) {
			openRegisters++;
			freeRegisters++;
		}
	}

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

	public Customer first() {
		if (regQueue.size() == 0) {
			throw new NoSuchElementException();
		} else {
			return regQueue.get(0);
		}
	}


	public boolean isEmpty() {
		if (regQueue.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return regQueue.size();
	}

	public void regStat() {
		
	}
	public void removeFromReg() {
		freeRegisters--;
	}
	public String toString() {
		String count = "[";
		for (int i = 0; i < regQueue.size(); i++) {
			if(count.length() == 1) {
				count +=  String.valueOf(regQueue.get(i).getCustomerID()); 
			} else if(count.length() > 1) {
				count +=  "," + String.valueOf(regQueue.get(i).getCustomerID()); 
				
			}
			
		}
		count += "]";
		return count;
	}

}

	
