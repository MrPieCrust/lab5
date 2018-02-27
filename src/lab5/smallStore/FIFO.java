package lab5.smallStore;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import lab5.smallStore.customer.Customer;

public class FIFO{
	private ArrayList<Customer> regQueue = new ArrayList<Customer>();
<<<<<<< HEAD
	private ArrayList<Register> registers = new ArrayList<Register>();
	private SmallStoreState state;
	int freeRegisters; 
	int openRegisters;
=======
	private ArrayList<Integer> nrOfReg = new ArrayList<Integer>();
	private SmallStoreState state;
	private boolean isEmpty1 = true;
	private boolean isEmpty2 = true;
	private boolean isEmpty3 = true;
	private boolean isEmpty4 = true;
>>>>>>> b5d3b3b9492e65529e2e4b380979edcfe97a7692

	public FIFO(SmallStoreState state) {
		this.state = state;
		openRegisters = 1;
		freeRegisters = 1;
//		for (int i=0; i<numRegister; i++) {
//			registers.add(new Register());
//		}
		
	}
	public void add(Customer item) {
		regQueue.add(item);
		//if regQueue==size && openRegisters=<state.maxRegisters
		//openRegisters++
	}

	public void removeFirst() {
		if (regQueue.size() > 0) {
			new CustomerPays(state, state.timeElapsed + state.timeKeeper.calcPay(), regQueue.get(0));
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

//	private Customer getIndex(int i) {
//		return regQueue.get(i);
//	}
//
//	public String toString() {
//		String finalString = "Queue: ";
//		for (int i = 0; i < regQueue.size(); i++) {
//			finalString += "(" + String.valueOf(regQueue.get(i)) + ") ";
//		}
//		return finalString;
//	}
	public void regStat() {
		
	}

}
class Register{
	private boolean open = false;
	private boolean free = false;
	
	void changeOpen() {
		if(open) {
			open=false;
		}
		else {
			open=true;
		}
	}
<<<<<<< HEAD
	void changeFree() {
		if(free) {
			free = false;
		}
		else {
			free = true;
		}
	}
	public boolean isOpen() {
		return open;
	}
	public boolean isFree() {
		return free;
	}
=======
	
	
	public void regStat() {
		if(nrOfReg.size() <= state.maxRegisters) {
		//int counter = 0;
			if(regQueue.size() >= 0) {
					if(isEmpty1 == true) {
						removeFirst(); //tar bort först ur kön
						isEmpty1 = false;
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

>>>>>>> b5d3b3b9492e65529e2e4b380979edcfe97a7692
}
