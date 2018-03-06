package lab5.smallStore;

import java.text.DecimalFormat;
import java.util.Observable;

import lab5.sim.*;
import lab5.smallStore.SmallStoreState;
import lab5.random.*;
import lab5.smallStore.customer.*;
/**
 * 
 * @author Jesper Persson, Leo Haglund, Sam Björedahl, Daniel Genberg. 
 *
 */

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

		super.update(arg0, arg1);


		if(arg1 instanceof Opens) {
			System.out.println(state.timeElapsed + "	" + ((Event) arg1).getName());

		}
		else if(arg1 instanceof Closes) {
			System.out.println(state.timeElapsed + "	" + ((Event) arg1).getName());

		}
		else {
			

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
		System.out.println("Genomsnittlig ledig kassatid: " + two.format(state.totTimeFreeReg / state.maxRegisters) + "te (dvs " + two.format(((state.totTimeFreeReg / state.maxRegisters)/state.timeElapsed)*100) + "% av tiden från öppning till sista kunden betalat) \n");
		System.out.println("3) Total tid " + state.numInQueue + " tvingats köa: " + two.format(state.totTimeInQueue) + " te");
		System.out.println("Genomsnittlig k�tid: " + two.format(state.totTimeInQueue / state.numInQueue) + "te");
	}


}

