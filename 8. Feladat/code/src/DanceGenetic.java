/**
* Dance osztály
*/
public class DanceGenetic extends Genetics{
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
	public DanceAgent generate() {
		return new DanceAgent();
	}

	public String toString() {
		return "DanceGenetic";
	}
}
