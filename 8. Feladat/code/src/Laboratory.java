import java.util.ArrayList;

/**
* Laboratory osztály
*/
public class Laboratory extends Field {
	private Genetics genetic;
	
	public Laboratory(String name) {
		super(name);
	}

	/** 
	 * Elhelyezi a genetikai kódot a mezőn
	 * @param genetic
	 */
	public void place(Genetics genetic) {
		this.genetic = genetic;
	}

	
	/** 
	 * @return Genetics
	 */
	public Genetics getGenetic() {
		return genetic;
	}

	
	/** 
	 * @param genetic
	 */
	public void setGenetic(Genetics genetic) {
		this.genetic = genetic;
	}
    
	
	/** 
	 * A virológus felveszi a mezőn lévő genetikai kódot
	 * @param virologist
	 */
	public void lootItem(Virologist virologist) {
		// if genetic has been learned
		if(!virologist.checkGenetics(genetic)) {
			virologist.addGenetics(genetic);	
			return;
		}

		System.out.println("The virologist has already learned that genetic.");
	}

	public String toString() {
		String returnString = super.toString();
		returnString += "\nGenetic: " + genetic.toString();

		return returnString;
	}
}
