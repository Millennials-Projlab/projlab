package main;
import subjects.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
* Dance Agens osztály
*/
public class DanceAgent extends Agent{
	public DanceAgent(Genetics g, int l) {
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
	 * Megvalósítja az ágens időlépését
	 * @param virologist
	 * @param iter
	 */
	public void tick(Virologist virologist, Iterator<Agent> iter) {
		super.tick(virologist, iter);

		if(effect) {
			Random rand = new Random();
			ArrayList<Field> neighbors = virologist.getCurrentField().getNeighbours();
			Field nextField;
			if(neighbors.size() == 1) {
				nextField = neighbors.get(0);
			}
			else {
				nextField = neighbors.get(rand.nextInt(neighbors.size()));
			}

			try {
				virologist.move(nextField);
			} catch (IncorrectParameterException e) {}
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
		return agentName.equals("DanceAgent") ? true : false;
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "DanceAgent";
	}
}
