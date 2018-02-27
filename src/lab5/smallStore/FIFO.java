package lab5.smallStore;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import lab5.smallStore.customer.Customer;

public class FIFO{
	private ArrayList<Customer> regQueue = new ArrayList<Customer>();
	private ArrayList<Integer> nrOfReg = new ArrayList<Integer>();
	private SmallStoreState state;
	private boolean isEmpty1 = true;
	private boolean isEmpty2 = true;
	private boolean isEmpty3 = true;
	private boolean isEmpty4 = true;

	public FIFO(SmallStoreState state) {
		this.state = state;
	}
	public void add(Customer item) {
		regQueue.add(item);
	}

	public void removeFirst() {
		if (regQueue.size() > 0) {
			regQueue.remove(0);
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

	private Customer getIndex(int i) {
		return regQueue.get(i);
	}

	public String toString() {
		String finalString = "Queue: ";
		for (int i = 0; i < regQueue.size(); i++) {
			finalString += "(" + String.valueOf(regQueue.get(i)) + ") ";
		}
		return finalString;
	}
	
	
	public void regStat() {
        if(nrOfReg.size() <= state.maxRegisters) {
        //int counter = 0;
            if(regQueue.size() >= 0) {
                    if(isEmpty1 == true) {
                        removeFirst(); //tar bort först ur kön
                        isEmpty1 = false;
                        state.payed();
                        isEmpty = true;
                    } else if(isEmpty2 == true) {
                        removeFirst(); 
                        isEmpty1 = false;
                    } else if(isEmpty3 == true) {
                        removeFirst(); 
                        isEmpty1 = false;
                    } else if(isEmpty2 == true) {
                        removeFirst(); 
                        isEmpty1 = false;
                    }
            }

        }
    }
}
