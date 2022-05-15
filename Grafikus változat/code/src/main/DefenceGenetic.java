package main;
import subjects.*;

public class DefenceGenetic extends Genetics{
	public DefenceGenetic() {

	}
	
    public DefenceGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Defence has been learned.");
	}
	
	/** 
	 * Elkészíti az ágenst
	 * @return DefenceAgent
	 */
	public Agent generate(Virologist virologist, int liveTime) {
		if(!virologist.checkSubstanceRequirements(this)) {
			System.out.println("Virologist does not have enough substances to make this Agent.");
			return null;
		}
		virologist.removeMaterials(this);
		return new DefenceAgent(this, liveTime);
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "DefenceGenetic";
	}
}
