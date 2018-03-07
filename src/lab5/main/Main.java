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
	
	/**
	 * Main method, creates a new object of simulator and uses its method run() so
	 * the simulation can start.
	 * 
	 * @param args
	 *            - no arguments given.
	 */
	public static void main(String[] args) {
		SmallStoreState state = new SmallStoreState();
		Simulator sim = new Simulator();
		sim.run();
	}
}
