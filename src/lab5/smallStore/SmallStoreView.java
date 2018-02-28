package lab5.smallStore;

import java.text.DecimalFormat;
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
		System.out.println("Tid	H�ndelse	 Kund	?	led	ledT	I	$	:-(	k�at	k�T	k�ar	[Kassak�..]");

	}

	/** Printar alla h�ndelser INNAN de exekveras */

	/** Printar alla h�ndelser INNAN de exekveras */
	
	/** Printar alla h�ndelser INNAN de exekveras */
	public void update(Observable arg0, Object arg1) {
		/**detta rö asdjahsdhasjdhka
		 *
		 * 
		 * Hela kassak�n
		 * 
		 */
		DecimalFormat two = new DecimalFormat("#0.00");

		super.update(arg0, arg1);

//		state.timeElapsed; //Tid just nu
//		arg0; //h�ndelse
//		state.allCustomer.get(Customer.getCustomerID()); //Kund-ID
//		//Kassa �ppen/st�ngd
//		state.regQueue.freeRegisters;//Antal lediga kassor vid current time
//		//Total ledig tid f�r kassor
//		//TOTAL LEDIG TID F�R KASSOR
//		state.numberOfCustomersNow; //Kunder i butiken just nu
//		state.payedCustomers; //Kunder som betalat
//		state.missedCustomers; //Fullt i butiken
//		state.numInQueue;//Antalet kunder som tvingats k�a
//		state.totTimeInQueue; //Total tid kunder k�at
//		state.regQueue.toString(); //Hela kassak�
//		
//		System.out.println(state.freeRegisters);
		if(arg1 instanceof Opens) {
			System.out.println(state.timeElapsed + "	" + ((Event) arg1).getName());

		}
		else if(arg1 instanceof Closes) {
			System.out.println(state.timeElapsed + "	" + ((Event) arg1).getName());

		}
		else {
			//System.out.println(arg1);
			System.out.println(two.format(state.timeElapsed) + "	"+ ((Event) arg1).getName() + "	 " + ((Event) arg1).getCustID() + "	" + state.status + "	  " +
					 state.regQueue.freeRegisters+ "	" + "ledT"+"	"
							+ state.numberOfCustomersNow+ " 	 " + state.payedCustomers+ "	" + state.missedCustomers+ "	"
							+ state.numInQueue + "  	"+ two.format(state.totTimeInQueue) + "	"+ state.lengthOfQueue + "	" + "allasomköar");
		}
		
	}

	/** Printar slutresultatet */

		/**
		 * BEH�VER H�MTA IN:
		 *  
		 * Totalt antal kunderstate.regQueue.toString()
=======

		/**
		 * BEH�VER H�MTA IN:
		 * 
		 * Totalt antal kunder
>>>>>>> 2f8c89a3b04f7e55d55787dce70ec8315d0560a9
		 * Antal missade kunder
		 * Totalt tid kassorna som kassorna varit lediga
		 * Genomsnittlig ledig kassatid
		 * %-sats f�r genomsnittlig ledig kassatid
		 * Antalet kunder som beh�vs k�a
		 * Totala tiden som kunder k�at
		 * Genomsnittlig k�-tid
<<<<<<< HEAD
		 */


//		 */
//		System.out.println("RESULTAT ========");
//		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
//		System.out.println("2) Total tid " + state.freeRegisters + "varit lediga: " + TOTAL TID +" te");
//		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden fr��n �ppning till sista kunden betalat");
//		System.out.println("3) Total tid" + state.numInQueue + "tvingats k�a: " + state.totTimeInQueue + "te");
//		System.out.println("Genomsnittlig k�tid: " + GENOMSNITTLIGK�-tid + "te");
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