package lab5.smallStore;

import java.util.Observable;

import lab5.sim.View;
import lab5.smallStore.SmallStoreState;
import lab5.random.*;

public class SmallStoreView extends View {
	
	private SmallStoreState state;
	private FIFO regQueue;
	private ExponentialRandomStream random;
	
	public SmallStoreView(SmallStoreState state) {
		this.state = state;
		this.regQueue = state.regQueue;
		
	}
	//	PARAMETRAR
//	==========
//	Antal kassor, N..........: 2
//	Max som ryms, M..........: 5
//	Ankomshastighet, lambda..: 1.0
//	Plocktider, [P_min..Pmax]: [0.5..1.0]
//	Betaltider, [K_min..Kmax]: [2.0..3.0]
//	FrÃ¶, f...................: 1234
	
	
	public void printParameters() {
		
		int N = state.maxRegisters;
		int M = state.maxCustomers;
		double currentTime = state.currentTime;
		/** Det som behövs:
		 * 
		 * Ankomsthastighet lambda
		 * Plocktider
		 * Betaltider
		 * Frö
		 */
		
		
		System.out.println("PARAMETRAR" +  "\n======="); //Parametrar
		System.out.println("Antal kassor, N..........: " + N); //Antal kassor
		System.out.println("Max som ryms, M..........: " + M); //Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + L); //Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + P); //Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + B); //Betaltid
		System.out.println("Frö, f...................: " + F); //Frö
		
		
		System.out.println("FÖRLOPP" +  "\n=======");
		System.out.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    köT   köar  [Kassakö..]");

		
	}
	
	public void update(Observable arg0, Object arg1) {
		super.update(arg0, arg1);
		
		double currentTime = state.currentTime;
		
		System.out.println(currentTime + "    " + arg0);
		System.out.println(arg0);
		
	}
	public static void main(String[] args) {
		System.out.println("FÖRLOPP" +  "\n=======");
		System.out.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    köT   köar  [Kassakö..]");
		System.out.println("0,00 Open");
		
		
		
		
		
	}
}
