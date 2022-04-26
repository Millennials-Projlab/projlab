/**
* Poison Agens osztály
*/
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

	public void endEffect(Virologist virologist) {
		if(virologist.getEffectFlag() < 2 && !virologist.checkPoisonEffects()) {
			virologist.setEffectFlag(0);
		}
	}
	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		target.addEffect(this);
		startEffect(target);
	}

	public boolean isSame(String agentName) {
		return agentName.equals("PoisonAgent") ? true : false;
	}
}
