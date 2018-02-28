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

	/** Printar alla parametrar frï¿½n bï¿½rjan */

	public void printParameters() {
		
		
		
		System.out.println("PARAMETRAR" + "\n======="); // Parametrar
		System.out.println("Antal kassor, N..........: " + state.maxRegisters); // Antal kassor
		System.out.println("Max som ryms, M..........: " + state.maxCustomers); // Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + state.exponentLambda); // Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + state.uniformLowerShop +", "+ state.uniformUpperShop); // Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + state.uniformLowerPay + ", "+ state.uniformUpperPay); // Betaltid
		System.out.println("Frï¿½, f...................: " + state.fseed); // Frï¿½
		System.out.println("Fï¿½RLOPP" + "\n=======");
		System.out.println("Tid	Hï¿½ndelse	 Kund	?	led	ledT	I	$	:-(	kï¿½at	kï¿½T	kï¿½ar	[Kassakï¿½..]");

	}

<<<<<<< HEAD
	/** Printar alla händelser INNAN de exekveras */

=======
	/** Printar alla hï¿½ndelser INNAN de exekveras */
	
	/** Printar alla hï¿½ndelser INNAN de exekveras */
>>>>>>> 718833e414b44ab300bd6f8b402becdb12c56fe4
	public void update(Observable arg0, Object arg1) {
		/**
		 *
		 * 
		 * Hela kassakï¿½n
		 * 
		 */
		DecimalFormat two = new DecimalFormat("#0.00");

		super.update(arg0, arg1);
<<<<<<< HEAD
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
=======
//		state.timeElapsed; //Tid just nu
//		arg0; //hï¿½ndelse
//		state.allCustomer.get(Customer.getCustomerID()); //Kund-ID
//		//Kassa ï¿½ppen/stï¿½ngd
//		state.regQueue.freeRegisters;//Antal lediga kassor vid current time
//		//Total ledig tid fï¿½r kassor
//		//TOTAL LEDIG TID Fï¿½R KASSOR
//		state.numberOfCustomersNow; //Kunder i butiken just nu
//		state.payedCustomers; //Kunder som betalat
//		state.missedCustomers; //Fullt i butiken
//		state.numInQueue;//Antalet kunder som tvingats kï¿½a
//		state.totTimeInQueue; //Total tid kunder kï¿½at
//		state.regQueue.toString(); //Hela kassakï¿½
//		
//		System.out.println(state.freeRegisters);
		if(arg1 instanceof Opens) {
			System.out.println(state.timeElapsed + "	" + ((Event) arg1).getName());

		}
		else if(arg1 instanceof Closes) {
			System.out.println(state.timeElapsed + "	" + ((Event) arg1).getName());

		}
		else {
			System.out.println(two.format(state.timeElapsed) + "	"+ ((Event) arg1).getName() + "	 " + ((Event) arg1).getCustID() + "	" + state.status + "	  " +
					 state.regQueue.freeRegisters+ "	" + "ledT"+"	"
							+ state.numberOfCustomersNow+ " 	 " + state.payedCustomers+ "	" + state.missedCustomers+ "	"
							+ state.numInQueue + "  	"+ state.totTimeInQueue + "	"+ state.lengthOfQueue + "	" + "allasomkÃ¶ar");
		}
>>>>>>> 718833e414b44ab300bd6f8b402becdb12c56fe4
		
<<<<<<< HEAD
	}

	/** Printar slutresultatet */
//	public void resultat() {
=======
		
<<<<<<< HEAD
=======
<<<<<<< HEAD
		/**
		 * BEHï¿½VER Hï¿½MTA IN:
		 *  
		 * Totalt antal kunderstate.regQueue.toString()
=======

		/**
		 * BEHï¿½VER Hï¿½MTA IN:
		 * 
		 * Totalt antal kunder
>>>>>>> 2f8c89a3b04f7e55d55787dce70ec8315d0560a9
		 * Antal missade kunder
		 * Totalt tid kassorna som kassorna varit lediga
		 * Genomsnittlig ledig kassatid
		 * %-sats fï¿½r genomsnittlig ledig kassatid
		 * Antalet kunder som behï¿½vs kï¿½a
		 * Totala tiden som kunder kï¿½at
		 * Genomsnittlig kï¿½-tid
<<<<<<< HEAD
		 */

=======
//		 */
//		System.out.println("RESULTAT ========");
//		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
//		System.out.println("2) Total tid " + state.freeRegisters + "varit lediga: " + TOTAL TID +" te");
//		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden frï¿½ï¿½n ï¿½ppning till sista kunden betalat");
//		System.out.println("3) Total tid" + state.numInQueue + "tvingats kï¿½a: " + state.totTimeInQueue + "te");
//		System.out.println("Genomsnittlig kï¿½tid: " + GENOMSNITTLIGKï¿½-tid + "te");
>>>>>>> 2f8c89a3b04f7e55d55787dce70ec8315d0560a9
>>>>>>> 718833e414b44ab300bd6f8b402becdb12c56fe4
	}
}
//	public void update(Observable arg0) {
//		super.update(arg0);
//		System.out.println(state.timeElapsed + "    " + arg0);
>>>>>>> 8e190ab76e00fa2a85b456f65ba0d5cb0b383496
//		
//		System.out.println("RESULTAT ========");
//		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
//		System.out.println("2) Total tid " + state.freeRegisters + "varit lediga: " + TOTAL TID +" te");
//		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden frïån öppning till sista kunden betalat");
//		System.out.println("3) Total tid" + state.numInQueue + "tvingats köa: " + state.totTimeInQueue + "te");
//		System.out.println("Genomsnittlig kötid: " + GENOMSNITTLIGKÖ-tid + "te");
//
//}