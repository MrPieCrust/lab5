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
	  
	public static double next() {
	  	return -Math.log(rand.nextDouble())/lambda;
	}
	
	public static void main(String[] args) {
		
		System.out.println(next());
		
	}
}
