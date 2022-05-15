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
	 * Belépteti a virológust a mezőre, ha medvevírus van a mezőn, akkor megfertőzi vele a virológust
	 * @param virologist
	 */
	public void enter(Virologist virologist) {
		super.enter(virologist);
		
		if(genetic.isSame(new BearGenetic())) {
			infect(virologist, new BearAgent());
		}
	}

	public void infect(Virologist target, BearAgent agent) {
		agent.infect(target);
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

	
	/** 
	 * @return String
	 */
	public String toString() {
		String returnString = super.toString();
		returnString += "\nGenetic: " + genetic.toString();

		return returnString;
	}
}
