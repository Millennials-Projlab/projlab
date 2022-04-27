import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class BearAgent extends Agent {
    public BearAgent() {
		super(null, 0);
	}

	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {
		effect = true;
		virologist.setEffectFlag(2);
	}

	public void endEffect(Virologist virologist) {
		Game.removePlayer(virologist);
        System.out.println("Virologist " + virologist.getName() + " died.");
	}

	public void tick(Virologist virologist, Iterator<Agent> iter) {
		if(effect) {
			Random rand = new Random();
			ArrayList<Field> neighbors = virologist.getCurrentField().getNeighbours();
			Field nextField;
			if(neighbors.size() == 1) {
				nextField = neighbors.get(0);
			}
			else {
				nextField = neighbors.get(rand.nextInt(neighbors.size()-1));
			}

			try {
				virologist.move(nextField);
                if(nextField.isSame(new Warehouse(""))) {
                    ((Warehouse)nextField).clear();
                }
                for(Virologist enemy : nextField.getVirologists()) {
                    if(!enemy.equals(virologist)) {
                        virologist.infect(enemy, "BearAgent");
                    }
                }
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

	public boolean isSame(String agentName) {
		return agentName.equals("DanceAgent") ? true : false;
	}

	public String toString() {
		return "BearAgent";
	}
}
