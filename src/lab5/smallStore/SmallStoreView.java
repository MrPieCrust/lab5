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
			

	}

	/** Printar alla parametrar från början */

	public void printParameters() {
		
		
		
		System.out.println("PARAMETRAR" + "\n======="); // Parametrar
		System.out.println("Antal kassor, N..........: " + state.maxRegisters); // Antal kassor
		System.out.println("Max som ryms, M..........: " + state.maxRegisters); // Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + state.exponentLambda); // Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + state.uniformLowerShop +", "+ state.uniformUpperShop); // Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + state.uniformLowerPay + ", "+ state.uniformUpperPay); // Betaltid
		System.out.println("Frö, f...................: " + state.fseed); // Frö
		System.out.println("FÖRLOPP" + "\n=======");
		System.out.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    köT   köar  [Kassakö..]");

	}

	/** Printar alla händelser INNAN de exekveras */
	public void update(Observable arg0, Object arg1) {
		/**
		 *
		 * 
		 * Hela kassakön
		 * 
		 */
		
		
		super.update(arg0, arg1);
		
//		state.timeElapsed; //Tid just nu
//		arg0; //händelse
//		state.allCustomer.get(Customer.getCustomerID()); //Kund-ID
//		//Kassa öppen/stängd
//		state.regQueue.freeRegisters;//Antal lediga kassor vid current time
//		//Total ledig tid för kassor
//		state.numberOfCustomersNow; //Kunder i butiken just nu
//		state.payedCustomers; //Kunder som betalat
//		state.missedCustomers; //Fullt i butiken
//		state.numInQueue;//Antalet kunder som tvingats köa
//		state.totTimeInQueue; //Total tid kunder köat
//		state.regQueue.toString(); //Hela kassakö
//		
//		System.out.println(state.freeRegisters);
		
		System.out.println(state.timeElapsed + "    " + arg0  + state.allCustomer.get(Customer.getCustomerID()) 
		+ state.regQueue.freeRegisters
				+ state.numberOfCustomersNow + state.payedCustomers + state.missedCustomers
				+ state.numInQueue + state.totTimeInQueue + state.regQueue.toString());
		
		
	}

	/** Printar slutresultatet */
	public void resultat() {
		
		/**
		 * BEHÖVER HäMTA IN:
		 * 
		 * Totalt antal kunder
		 * Antal missade kunder
		 * Totalt tid kassorna som kassorna varit lediga
		 * Genomsnittlig ledig kassatid
		 * %-sats för genomsnittlig ledig kassatid
		 * Antalet kunder som behövs köa
		 * Totala tiden som kunder köat
		 * Genomsnittlig kö-tid
		 */
		System.out.println("RESULTAT ========");
		System.out.println(N);
		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
		System.out.println("2) Total tid " + N + "varit lediga: " + TOTAL TID +" te");
		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden frïån öppning till sista kunden betalat");
		System.out.println("3) Total tid" + KUNDER SOM KÖA + "tvingats köa: " + TOTAL KÖTID + "te");
		System.out.println("Genomsnittlig kötid: " + GENOMSNITTLIGKÖ-tid + "te");

	}

}
