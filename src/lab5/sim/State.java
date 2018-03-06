package lab5.sim;

import java.util.Observable;

/**
 * General class that extends Observable and contains the elapsed time, a
 * stopFlag and fseed.
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg
 *
 */

public class State extends Observable {
	public final long fseed = 5;
	public boolean stopFlag = false;
	public double timeElapsed = 0; // elapsed time.
	public double timeBetween = 0;

}
