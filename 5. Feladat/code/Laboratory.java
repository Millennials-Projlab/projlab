import java.util.ArrayList;

/**
* Laboratory osztály
*/
public class Laboratory extends Field {
	private Genetics Genetic;
	
	
	/** 
	 * Elhelyezi a genetikai kódot a mezőn
	 * @param Genetic
	 */
	public void place(Genetics Genetic) {
		this.Genetic = Genetic;
	}

	
	/** 
	 * @return Genetics
	 */
	public Genetics getGenetic() {
		return Genetic;
	}

	
	/** 
	 * @param Genetic2
	 */
	public void setGenetic(Genetics Genetic2) {
		Genetic = Genetic2;
	}
    
	
	/** 
	 * A virológus felveszi a mezőn lévő genetikai kódot
	 * @param virologist
	 */
	public void lootItem(Virologist virologist) {
		Logger.addTab();
		Logger.log(virologist, "getGenetics", "");
		ArrayList<Genetics> learnedGenetics = virologist.getGenetics();
		Logger.removeTab();

		// TODO check if genetics is learned

		Logger.addTab();
		Logger.log(virologist, "addGenetics", "Genetic");
		virologist.addGenetics(Genetic);
		Logger.removeTab();
	}
}
