/**
* Defence Agens osztály
*/
public class DefenceAgent extends Agent {
	
	public DefenceAgent(Genetics g, int l) {
		super(g, l);
		// TODO Auto-generated constructor stub
	}


	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void Effect(Virologist virologist) {
		System.out.println("Defence Agent has its effect on  "+virologist.getName()+".");
	}

	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		target.setEffectFlag(1);
	}

	public boolean isSame(String agentName) {
		return agentName.equals("DefenceAgent") ? true : false;
	}
}
