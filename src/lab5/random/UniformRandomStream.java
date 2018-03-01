package lab5.random;

import java.util.Random;

/**
 * 
 * Class given, generates random numbers to rectangular distribution.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class UniformRandomStream {

	private Random rand;
	private double lower, width;

	/**
	 * Constructor, keeps the parameters intern.
	 * 
	 * @param lower
	 *            - lower limit in the distribution.
	 * @param upper
	 *            - upper limit in the distribution.
	 * @param seed
	 *            - to initialize a random number.
	 */
	public UniformRandomStream(double lower, double upper, long seed) {
		rand = new Random(seed);
		this.lower = lower;
		this.width = upper - lower;
	}

	/**
	 * Creates a random double number that's rectangular distributed.
	 * 
	 * @return a random number
	 */

	public double next() {
		return lower + rand.nextDouble() * width;
	}
}
