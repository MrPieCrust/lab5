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

	/** Printar alla parametrar från början */

	public void printParameters() {

		int N = state.maxRegisters;
		int M = state.maxCustomers;
		double L = state.exponentLambda;
		double Pmin = state.uniformLowerShop;
		double Pmax = state.uniformLowerShop;
		double Bmin = state.uniformLowerPay;
		double Bmax = state.uniformUpperPay;
		long F = state.fseed;
		/**
		 * Det som behövs: Ankomsthastighet lambda Plocktider Betaltider Frï¿½
		 */

		System.out.println("PARAMETRAR" + "\n======="); // Parametrar
		System.out.println("Antal kassor, N..........: " + N); // Antal kassor
		System.out.println("Max som ryms, M..........: " + M); // Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + L); // Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + Pmin +", "+ Pmax); // Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + Bmin + ", "+Bmax); // Betaltid
		System.out.println("Frï¿½, f...................: " + F); // Frï¿½

		System.out.println("FÖRLOPP" + "\n=======");
		System.out.println("Tid Händelse  Kund  ?  led    ledT    I     $    :-(   köat    köT   köar  [Kassakö..]");

	}

	/** Printar alla händelser INNAN de exekveras */
	public void update(Observable arg0, Object arg1) {
		/**
		 * BEHÖVER HÄMTA IN vid CURRENT TIME
		 * Händelse === arg0???
		 * Kund-ID
		 * Om kassa är öppen/stängd
		 * Antal lediga kassor vid current time
		 * Totalt hur länge kassorna varit lediga vid current time
		 * Antalet kunder i butiken
		 * Antalet kunder som betalat
		 * Antalet kunder som inte kunnat gått in pga fullt
		 * Antalet kunder som tvingats köa
		 * Summa tid som kunder tvingats köa
		 * Hela kassakön
		 * 
		 */
		
		
		super.update(arg0, arg1);
		double currentTime = state.timeElapsed;
		
		
		
		
		System.out.println(currentTime + "    " + arg0  + getCustomerID() + öppen/stäng + antal lediga kassor
				+ total tid båda varit lediga + antal i butiken + antal som betalat + antal ej kommit in pga fullt
				+ antal som tvingats köa + summa tid i kö + hela kassakön);
		
		
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
		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
		System.out.println("2) Total tid " + N + "varit lediga: " + TOTAL TID +" te");
		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden frïån öppning till sista kunden betalat");
		System.out.println("3) Total tid" + KUNDER SOM KÖA + "tvingats köa: " + TOTAL KÖTID + "te");
		System.out.println("Genomsnittlig kötid: " + GENOMSNITTLIGKÖ-tid + "te");

	}

}
