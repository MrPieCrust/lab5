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
	  
<<<<<<< HEAD
	public double next() {		
=======
	public double next() {
>>>>>>> d3d6969469bea191b1624ea1fb46c9f61232f29c
	  	return -Math.log(rand.nextDouble())/lambda;
	}
}
