package lab5.smallStore;

import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;

/**
 * Keeps track of the time and creates new dynamic objects from the classes
 * UniformRandomStream and ExponentialRandomStream
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */

public class TimeKeeper {
	private ExponentialRandomStream expRandom;
	private UniformRandomStream uniRandomShop;
	private UniformRandomStream uniRandomPay;

	/**
	 * Constructor, keeps parameter intern and creates a new
	 * ExponentialRandomStream, and two new UniformRandomStream with appropriate
	 * pointers.
	 * 
	 * @param state
	 *            - The state of the simulation is sent in so that variables can be
	 *            accessed from there.
	 */

	public TimeKeeper(SmallStoreState state) {
		expRandom = new ExponentialRandomStream(state.exponentLambda, state.fseed);
		uniRandomShop = new UniformRandomStream(state.uniformLowerShop, state.uniformUpperShop, state.fseed);
		uniRandomPay = new UniformRandomStream(state.uniformLowerPay, state.uniformUpperPay, state.fseed);
	}

	/**
	 * Calculates time until next customer arrives.
	 * 
	 * @return a random number from the exponential distribution.
	 */

	public double calcNextCustomer() {
		return expRandom.next();
	}

	/**
	 * Calculates time for customer to pay.
	 * 
	 * @return a random number from the rectangular distribution.
	 */
	public double calcPay() {
		return uniRandomPay.next();
	}

	/**
	 * Calculates time for customer to shop goods.
	 * 
	 * @return a random number from the rectangular distribution.
	 */

	double calcShop() {
		return uniRandomShop.next();
	}

}
