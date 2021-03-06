package lab5.main;

import lab5.sim.Simulator;
import lab5.smallStore.SmallStoreState;

/**
 * Creates a new dynamic object of simulator so it is possible to run the
 * simulation.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */
public class Main {
	
	private static Simulator sim; 
	/**
	 * Main method, creates a new object of simulator and uses its method run() so
	 * the simulation can start.
	 * 
	 * @param args
	 *            - no arguments given.
	 */
	public static void main(String[] args) {
		SmallStoreState state = new SmallStoreState(4, 5, 10, 0.5, 1.0, 2.0, 3.0, 1.0);
		Simulator sim = new Simulator(state);	

		sim.run();
	}
	
}
