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
<<<<<<< HEAD
	
=======
	private static Simulator sim; 
>>>>>>> 9935df2c81a4190bd41876d8c96461d839f36c22
	/**
	 * Main method, creates a new object of simulator and uses its method run() so
	 * the simulation can start.
	 * 
	 * @param args
	 *            - no arguments given.
	 */
	public static void main(String[] args) {
<<<<<<< HEAD
		SmallStoreState state = new SmallStoreState();
		Simulator sim = new Simulator();
=======
		
		sim = new Simulator();
		sim.state.maxRegisters = 10;
//		optimize();
>>>>>>> 9935df2c81a4190bd41876d8c96461d839f36c22
		sim.run();
	}
	
	
	
	public static int optimize() {
		sim.state.maxRegisters = 10;
		return 0;
	}
}
