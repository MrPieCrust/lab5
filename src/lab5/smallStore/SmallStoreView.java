package lab5.smallStore;

import java.text.DecimalFormat;
import java.util.Observable;

import lab5.sim.*;
import lab5.smallStore.SmallStoreState;
import lab5.random.*;
import lab5.smallStore.customer.*;

public class SmallStoreView extends View {
	private SmallStoreState state;
	private ExponentialRandomStream random;
	DecimalFormat two = new DecimalFormat("#0.00");


	

	public SmallStoreView(SmallStoreState state) {
		this.state = state;
		printParameters();
			

	}

	/** Printar alla parametrar fr�n b�rjan */

	public void printParameters() {
		
		
		
		System.out.println("PARAMETRAR" + "\n======="); // Parametrar
		System.out.println("Antal kassor, N..........: " + state.regQueue.openRegisters); // Antal kassor
		System.out.println("Max som ryms, M..........: " + state.maxCustomers); // Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + state.exponentLambda); // Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + state.uniformLowerShop +", "+ state.uniformUpperShop); // Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + state.uniformLowerPay + ", "+ state.uniformUpperPay); // Betaltid
		System.out.println("Frö, f...................: " + state.fseed); // Fr�
		System.out.println("FÖRLOPP" + "\n=======\n");
		System.out.println("Tid	Händelse	Kund	?	led	ledT	I	$	:-(	köat	köT	köar	[Kassakö..]");
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

			System.out.println(two.format(state.timeElapsed) + "	"+ ((Event) arg1).getName() + "		 " + ((Event) arg1).getCustID() + "	" + state.status + "	  " +
					 state.regQueue.freeRegisters+ "	" + two.format(state.totTimeFreeReg) +"	"
							+ state.numberOfCustomersNow+ " 	 " + state.payedCustomers+ "	" + state.missedCustomers+ "	"
							+ state.numInQueue + "  	"+ two.format(state.totTimeInQueue) + "	"+ state.lengthOfQueue + "	" + state.regQueue.toString());
		}
		
	}
	public void printResult() {
		

		System.out.println("\nRESULTAT \n========\n");
		System.out.println("1) Av " + (state.payedCustomers + state.missedCustomers) + " kunder handlade " + state.payedCustomers + " medan " + state.missedCustomers + " missades. \n");
		System.out.println("2) Total tid " + state.regQueue.freeRegisters + " varit lediga: " + two.format(state.totTimeFreeReg) +" te");
<<<<<<< HEAD
		System.out.println("Genomsnittlig ledig kassatid: " + two.format(state.totTimeFreeReg / state.payedCustomers) + " te (dvs " + "PROCENT" + "av tiden från öppning till sista kunden betalat) \n");
=======
		System.out.println("Genomsnittlig ledig kassatid: " + two.format(state.totTimeFreeReg / state.maxRegisters) + "te (dvs " + two.format(((state.totTimeFreeReg / state.maxRegisters)/state.timeElapsed)*100) + "% av tiden från öppning till sista kunden betalat) \n");
>>>>>>> 75793d71ba8326f0e126c56c5f1fc86974054cf9
		System.out.println("3) Total tid " + state.numInQueue + " tvingats köa: " + two.format(state.totTimeInQueue) + " te");
		System.out.println("Genomsnittlig k�tid: " + two.format(state.totTimeInQueue / state.numInQueue) + "te");
	}
		/**
		 * BEH�VER H�MTA IN:
		 * 
		 * Totalt antal kunder
		 * Antal missade kunder
		 * Totalt tid kassorna som kassorna varit lediga
		 * Genomsnittlig ledig kassatid
		 * %-sats f�r genomsnittlig ledig kassatid
		 * Antalet kunder som beh�vs k�a
		 * Totala tiden som kunder k�at
		 * Genomsnittlig k�-tid
 		 */



}

