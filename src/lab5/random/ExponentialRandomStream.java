package lab5.random;

import java.util.Random;

/**
 * Class given, generates random numbers to exponential distribution.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class ExponentialRandomStream {
	private Random rand;
	private double lambda;

	/**
	 * Constructor, keeps the parameters intern.
	 * 
	 * @param lambda
	 *            - exponential distributed parameter.
	 * @param seed
	 *            - to initialize a random number.
	 */

	public ExponentialRandomStream(double lambda, long seed) {
		rand = new Random(seed);
		this.lambda = lambda;
	}

	/**
	 * Creates a random double number that's exponential distributed.
	 * 
	 * @return a random log number
	 */

	public double next() {
		return -Math.log(rand.nextDouble()) / lambda;
	}
}
