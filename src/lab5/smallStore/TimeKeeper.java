package lab5.smallStore;

import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;

public class TimeKeeper {
	private ExponentialRandomStream expRandom;
	private UniformRandomStream uniRandomShop;
	private UniformRandomStream uniRandomPay;
	
	public TimeKeeper(SmallStoreState state) {
		expRandom = new ExponentialRandomStream(state.exponentLambda, state.fseed);
		uniRandomShop = new UniformRandomStream(state.uniformLowerShop, state.uniformUpperShop, state.fseed);
		uniRandomPay = new UniformRandomStream(state.uniformLowerPay, state.uniformUpperPay, state.fseed);
	}
	public double calcNextCustomer() {
		return expRandom.next();
	}
	
	public double calcPay() {
		return uniRandomPay.next();
	}
	double calcShop() {
		return uniRandomShop.next();
	}
	
}
