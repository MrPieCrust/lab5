package lab5.main;

import lab5.sim.Simulator;

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
		
		sim = new Simulator();
		sim.state.maxRegisters = 10;
//		optimize();
		sim.run();
	}
	
	
	
	public static int optimize() {
		sim.state.maxRegisters = 10;
		return 0;
	}
}
