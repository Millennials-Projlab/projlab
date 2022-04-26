/**
* Amnesia osztály
*/
public class AmnesiaGenetic extends Genetics {
	public AmnesiaGenetic() {
    }

    public AmnesiaGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}	

    public void PickUp() {
		System.out.println("Amnesia has been learned.");
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
		return new AmnesiaAgent(this, liveTime);
	}

	public String toString() {
		return "AmnesiaGenetic";
	}
}
