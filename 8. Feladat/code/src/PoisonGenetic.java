/**
* poison osztaly
*/
public class PoisonGenetic extends Genetics {
	public PoisonGenetic() {

	}
	
    public PoisonGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	/** 
	 * Elkészíti az ágenst
	 * @return PoisonAgent
	 */
	public Agent generate(Virologist virologist, int liveTime) {
		if(!virologist.checkSubstanceRequirements(this)) {
			System.out.println("Virologist does not have enough substances to make this Agent.");
			return null;
		}
		virologist.removeMaterials(this);
		return new PoisonAgent(this, liveTime);
	}

	/** 
	 * @return String
	 */
	public String toString() {
		return "PoisonGenetic";
	}
}
