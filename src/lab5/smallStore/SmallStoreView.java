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

	/** Printar alla parametrar fr�n b�rjan */

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
		 * Det som beh�vs: Ankomsthastighet lambda Plocktider Betaltider Fr�
		 */

		System.out.println("PARAMETRAR" + "\n======="); // Parametrar
		System.out.println("Antal kassor, N..........: " + N); // Antal kassor
		System.out.println("Max som ryms, M..........: " + M); // Max personer i butik
		System.out.println("Ankomsthastighet, lamba..: " + L); // Ankomsthastighet
		System.out.println("Plocktider, [P_min..Pmax]: " + Pmin +", "+ Pmax); // Plocktid
		System.out.println("Betaltider, [K_min..Kmax]: " + Bmin + ", "+Bmax); // Betaltid
		System.out.println("Fr�, f...................: " + F); // Fr�

		System.out.println("F�RLOPP" + "\n=======");
		System.out.println("Tid H�ndelse  Kund  ?  led    ledT    I     $    :-(   k�at    k�T   k�ar  [Kassak�..]");

	}

	/** Printar alla h�ndelser INNAN de exekveras */
	public void update(Observable arg0, Object arg1) {
		/**
		 * BEH�VER H�MTA IN vid CURRENT TIME
		 * H�ndelse === arg0???
		 * Kund-ID
		 * Om kassa �r �ppen/st�ngd
		 * Antal lediga kassor vid current time
		 * Totalt hur l�nge kassorna varit lediga vid current time
		 * Antalet kunder i butiken
		 * Antalet kunder som betalat
		 * Antalet kunder som inte kunnat g�tt in pga fullt
		 * Antalet kunder som tvingats k�a
		 * Summa tid som kunder tvingats k�a
		 * Hela kassak�n
		 * 
		 */
		
		
		super.update(arg0, arg1);
		double currentTime = state.currentTime;
		
		
		
		System.out.println(currentTime + "    " + arg0  + KUND-ID + �ppen/str�ng + antal lediga kassor
				+total tid b�da varit lediga+ antal i butiken + antal som betalat + antal ej kommit in pga fullt
				+ antal som tvingats k�a + summa tid i k� + hela kassak�n);
		
		
	}

	/** Printar slutresultatet */
	public void resultat() {
		
		/**
		 * BE�VER H�MTA IN:
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
		System.out.println("RESULTAT ========");
		System.out.println("1) Av " + state.numberOfCustomers + "kunder handlade" + "medan " + state.missedCustomers + "missades");
		System.out.println("2) Total tid " + N + "varit lediga: " + TOTAL TID +" te");
		System.out.println("Genomsnittlig ledig kassatid: " + LEDIG KASSATID + "te (dvs " + PROCENT + "av tiden fr�n �ppning till sista kunden betalat");
		System.out.println("3) Total tid" + KUNDER SOM K�A + "tvingats k�a: " + TOTAL K�TID + "te");
		System.out.println("Genomsnittlig k�tid: " + GENOMSNITTLIGK�-tid + "te");

	}

}
