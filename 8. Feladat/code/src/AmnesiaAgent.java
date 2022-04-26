/**
* Amnesia Agens osztály
*/
public class AmnesiaAgent extends Agent {
	//int liveTime;
	public AmnesiaAgent(Genetics g, int l) {
		super(g, l);
		//liveTime = 
	}
	
	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void Effect(Virologist virologist) {
		System.out.println("Amnesia Agent has its effect on  "+virologist.getName()+".");
	}

	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		target.clearCollectedGenetics();
	}

	public boolean isSame(String agentName) {
		return agentName.equals("AmnesiaAgent") ? true : false;
	}
}
