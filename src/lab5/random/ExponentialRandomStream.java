package lab5.random;

import java.util.Random;

public class ExponentialRandomStream {
	private Random rand;
	private double lambda;
	  
	public ExponentialRandomStream(double lambda, long seed) {
	  	rand = new Random(seed);
	  	this.lambda = lambda;
	}
	  
	public ExponentialRandomStream(double lambda) {
		rand = new Random();
	    this.lambda = lambda;
	}
	  
	public double next() {
<<<<<<< HEAD
=======
		
>>>>>>> 8e190ab76e00fa2a85b456f65ba0d5cb0b383496
	  	return -Math.log(rand.nextDouble())/lambda;
	}
}
