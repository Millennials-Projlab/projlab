/**
* poison osztaly
*/
public class PoisonGenetic extends Genetics {
    public PoisonGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Poison has been learned.");
	}
	
	/** 
	 * Elkészíti az ágenst
	 * @return PoisonAgent
	 */
	public PoisonAgent generate() {
		return new PoisonAgent();
	}
}
