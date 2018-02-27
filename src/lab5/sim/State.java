package lab5.sim;

import java.util.Observable;

public class State extends Observable {
	public final int fseed=5;
	public boolean stopFlag = false;
	public static double timeElapsed = 0; //elapsed time.
//	public double runTime =480; //runtime for sim in minutes.
}
