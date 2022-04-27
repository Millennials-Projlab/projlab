/**
* Dance osztály
*/
public class DanceGenetic extends Genetics{
	public DanceGenetic() {

	}
	
    public DanceGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Dance has been learned.");
	}
	
	/** 
	 * Elkészíti az ágenst
	 * @return DanceAgent
	 */
	public Agent generate(Virologist virologist, int liveTime) {
		if(!virologist.checkSubstanceRequirements(this)) {
			System.out.println("Virologist does not have enough substances to make this Agent.");
			return null;
		}
		virologist.removeMaterials(this);
		return new DanceAgent(this, liveTime);
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "DanceGenetic";
	}
}
