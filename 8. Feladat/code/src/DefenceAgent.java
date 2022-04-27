/**
* Defence Agens osztály
*/
public class DefenceAgent extends Agent {
	public DefenceAgent(Genetics g, int l) {
		super(g, l);
	}

	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {
		effect = true;
		virologist.setEffectFlag(3);
	}

	
	/** 
	 * Leállítja az ágens hatását
	 * @param virologist
	 */
	public void endEffect(Virologist virologist) {
		virologist.setEffectFlag(0);
	}
	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target, Virologist sender) {
		target.addEffect(this, sender);
		startEffect(target);
	}

	
	/** 
	 * @param agentName
	 * @return boolean
	 */
	public boolean isSame(String agentName) {
		return agentName.equals("DefenceAgent") ? true : false;
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "DefenceAgent";
	}
}
