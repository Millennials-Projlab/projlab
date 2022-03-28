/**
* Defence osztály
*/
public class DefenceGenetic extends Genetics{
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
	public DefenceAgent generate() {
		return new DefenceAgent();
	}
}
