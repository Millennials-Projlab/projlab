package main;
import subjects.*;

public class PoisonAgent extends Agent{
	public PoisonAgent(Genetics g, int l) {
		super(g, l);
	}


	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {
		effect = true;
		virologist.setEffectFlag(1);
	}

	
	/** 
	 * Leállítja az ágens hatását
	 * @param virologist
	 */
	public void endEffect(Virologist virologist) {
		if(virologist.getEffectFlag() < 2 && !virologist.checkPoisonEffects()) {
			virologist.setEffectFlag(0);
		}
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
		return agentName.equals("PoisonAgent") ? true : false;
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "PoisonAgent";
	}
}
