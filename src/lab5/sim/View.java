package lab5.sim;

import java.util.Observable;
import java.util.Observer;

/**
 * General class that implements Observer and has 2 update methods so it can be
 * observed.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class View implements Observer {

	/**
	 * This method is called whenever the observed object is changed. An application
	 * calls an Observable object's notifyObservers method to have all the object's
	 * observers notified of the change.
	 * 
	 * @param arg0
	 *            - the observable object.
	 * @param arg1
	 *            - an argument passed to the notifyObservers method.
	 */
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is called whenever the observed object is changed.
	 * 
	 * @param arg0
	 *            - the observable object.
	 */
	public void update(Observable arg0) {
		// TODO Auto-generated method stub

	}

}
