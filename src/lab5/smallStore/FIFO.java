package lab5.smallStore;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.naming.TimeLimitExceededException;

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

	
