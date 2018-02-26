package lab5.smallStore;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO{
	private ArrayList<Object> theList = new ArrayList<Object>();

	public void add(Object item) {
		theList.add(item);
	}

	public void removeFirst() {
		if (theList.size() > 0) {
			theList.remove(0);
		} else {
			throw new NoSuchElementException();
		}
	}

	public Object first() {
		if (theList.size() == 0) {
			throw new NoSuchElementException();
		} else {
			return theList.get(0);
		}
	}


	public boolean isEmpty() {
		if (theList.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return theList.size();
	}

	private Object getIndex(int i) {
		return theList.get(i);
	}

	public String toString() {
		String finalString = "Queue: ";
		for (int i = 0; i < theList.size(); i++) {
			finalString += "(" + String.valueOf(theList.get(i)) + ") ";
		}
		return finalString;
	}

}
