import java.util.Random;

/**
* poison osztaly
*/
public class PoisonGenetic extends Genetics {
	public PoisonGenetic() {

	}
	
    public PoisonGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Poison has been learned.");
	}
	
	/** 
	 * Elkészíti az ágenst
	 * @return AmnesiaAgent
	 */
	public Agent generate(Virologist virologist, int liveTime) {
		if(!virologist.checkSubstanceRequirements(this)) {
			System.out.println("Virologist does not have enough substances to make this Agent.");
			return null;
		}
		virologist.removeMaterials(this);
		return new PoisonAgent(this, liveTime);
	}

	public String toString() {
		return "PoisonGenetic";
	}
}
