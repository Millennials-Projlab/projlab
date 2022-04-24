import java.util.ArrayList;

/**
* Laboratory osztály
*/
public class Laboratory extends Field {
	private String name;
	private Genetics genetic;
	
	public Laboratory(String name) {
		super(name);
	}

	/** 
	 * Elhelyezi a genetikai kódot a mezőn
	 * @param Genetic
	 */
	public void place(Genetics Genetic) {
		this.genetic = Genetic;
	}

	
	/** 
	 * @return Genetics
	 */
	public Genetics getGenetic() {
		return genetic;
	}

	
	/** 
	 * @param Genetic2
	 */
	public void setGenetic(Genetics Genetic2) {
		genetic = Genetic2;
	}
    
	
	/** 
	 * A virológus felveszi a mezőn lévő genetikai kódot
	 * @param virologist
	 */
	public void lootItem(Virologist virologist) {
		ArrayList<Genetics> learnedGenetics = virologist.getGenetics();

		//if genetic has been learned
		if(virologist.checkGenetics(genetic) == false) {
			virologist.addGenetics(genetic);	
		}
	}
}
