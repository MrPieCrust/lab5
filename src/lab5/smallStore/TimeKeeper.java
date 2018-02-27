package lab5.smallStore;

import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;
import lab5.sim.State;

public class TimeKeeper {
	private ExponentialRandomStream expRandom;
	private UniformRandomStream uniRandom;
	private SmallStoreState state;
	
	public TimeKeeper(SmallStoreState state) {
		this.state = state;
		expRandom = new ExponentialRandomStream(state.exponentLambda, state.fseed);
		uniRandom = new UniformRandomStream(state.uniformLower, state.uniformUpper, state.fseed);
	}
	public double calcNextCustomer() {
		return expRandom.next();
	}
	
	public double calcPay() {
		return uniRandom.next();
	}
	double calcShop() {
		return uniRandom.next();
	}
	
}
