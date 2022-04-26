/**
* Amnesia osztály
*/
public class AmnesiaGenetic extends Genetics {
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
	public AmnesiaAgent generate() {
		return new AmnesiaAgent();
	}

	public String toString() {
		return "AmnesiaGenetic";
	}
}
