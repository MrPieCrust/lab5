package lab5.smallStore;

import java.util.Observable;

import lab5.sim.*;
import lab5.smallStore.SmallStoreState;
import lab5.random.*;
import lab5.smallStore.customer.*;

public class SmallStoreView extends View {

	private SmallStoreState state;
	private FIFO regQueue;
	private ExponentialRandomStream random;


	

	public SmallStoreView(SmallStoreState state) {
		this.state = state;
		this.regQueue = state.regQueue;
		printParameters();
			

	}

	/** Printar alla parametrar fr�n b�rjan */

	public void printParameters() {
		
		
		
		System.out.println("PARAMETRAR" + "\n======="); // Parametrar
		System.out.println("Antal kassor, N..........: " + state.maxRegisters); // Antal kassor
		System.out.println("Max som ryms, M..........: " + state.maxCustomers); // Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + state.exponentLambda); // Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + state.uniformLowerShop +", "+ state.uniformUpperShop); // Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + state.uniformLowerPay + ", "+ state.uniformUpperPay); // Betaltid
		System.out.println("Fr�, f...................: " + state.fseed); // Fr�
		System.out.println("F�RLOPP" + "\n=======");
		System.out.println("Tid H�ndelse  Kund  ?  led    ledT    I     $    :-(   k�at    k�T   k�ar  [Kassak�..]");

	}

	/** Printar alla h�ndelser INNAN de exekveras */

	public void update(Observable arg0, Object arg1) {
		/**
		 *
		 * 
		 * Hela kassak�n
		 * 
		 */
		
		System.out.println("halloj");
		super.update(arg0, arg1);
		System.out.println("nu printar vi");
		
		
		System.out.println(state.timeElapsed);
		System.out.println(state.regQueue.freeRegisters);
		System.out.println(state.numberOfCustomersNow);
		System.out.println(state.payedCustomers);
		System.out.println(state.missedCustomers);
		System.out.println(state.numInQueue);
		System.out.println(state.totTimeInQueue);
		System.out.println(state.regQueue.toString());
		System.out.println(state.regQueue.size());
		
		
	}
}
//	public void update(Observable arg0) {
//		super.update(arg0);
//		System.out.println(state.timeElapsed + "    " + arg0);
//		
//		System.out.println("RESULTAT ========");
//		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
//		System.out.println("2) Total tid " + state.freeRegisters + "varit lediga: " + TOTAL TID +" te");
//		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden fr��n �ppning till sista kunden betalat");
//		System.out.println("3) Total tid" + state.numInQueue + "tvingats k�a: " + state.totTimeInQueue + "te");
//		System.out.println("Genomsnittlig k�tid: " + GENOMSNITTLIGK�-tid + "te");
//
//}