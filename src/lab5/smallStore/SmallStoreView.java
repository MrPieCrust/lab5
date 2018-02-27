package lab5.smallStore;

import java.util.Observable;

import lab5.sim.View;
import lab5.smallStore.SmallStoreState;;


public class SmallStoreView extends View {
	
	private SmallStoreState state;
	private FIFO regQueue;
	
	public SmallStoreView(SmallStoreState state) {
		this.state = state;
		this.regQueue = state.regQueue;
		int N = state.maxRegisters;
	}
	//	PARAMETRAR
//	==========
//	Antal kassor, N..........: 2
//	Max som ryms, M..........: 5
//	Ankomshastighet, lambda..: 1.0
//	Plocktider, [P_min..Pmax]: [0.5..1.0]
//	Betaltider, [K_min..Kmax]: [2.0..3.0]
//	Frö, f...................: 1234
	
	
	public void printParameters() {
		

		int N = state.maxRegisters;
		
		System.out.println("PARAMETRAR" +  "\n======="); //Parametrar
		System.out.println("Antal kassor, N........: " + N);
		
		
	}
	
	public void update(Observable arg0, Object arg1) {
		
		super.update(arg0, arg1);
		
	}
	


	public static void main(String[] args) {
		
		
//		System.out.println(SmallStoreState.maxRegistrers());
		
		
	}
}
