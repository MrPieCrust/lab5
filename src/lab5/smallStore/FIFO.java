package lab5.smallStore;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import lab5.smallStore.customer.Customer;

public class FIFO{
	private ArrayList<Customer> regQueue = new ArrayList<Customer>();
//	private ArrayList<Register> registers = new ArrayList<Register>();
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
		//if regQueue==size && openRegisters=<state.maxRegisters
		//openRegisters++
	}

	public void removeFirst() {
		if (regQueue.size() > 0) {
			new CustomerPays(state, state.timeElapsed + state.timeKeeper.calcPay(), regQueue.get(0));
			regQueue.remove(0);
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

}
//class Register{
//	private boolean open = false;
//	private boolean free = false;
//	
//	void changeOpen() {
//		if(open) {
//			open=false;
//		}
//		else {
//			open=true;
//		}
//	}
//
//	void changeFree() {
//		if(free) {
//			free = false;
//		}
//		else {
//			free = true;
//		}
//	}
//	public boolean isOpen() {
//		return open;
//	}
//	public boolean isFree() {
//		return free;
//	}

	
