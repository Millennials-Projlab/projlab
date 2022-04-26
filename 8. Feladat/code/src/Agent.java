
/**
* Agens osztály
*/
public abstract class Agent {
	private Genetics Genetic;
	private int livetime;
	
	public Agent(Genetics g, int l) {
		Genetic = g;
		livetime = l;
		
	}
	
	public void Generate() {
		if (check()) {
			System.out.println("Agent has been Generated");
			
		}
	}

	public void tick(Virologist virologist) {
		livetime -= 1;
		if(livetime == 0) {
			virologist.removeAgent(this);
		}
	}
	
	public abstract void Effect(Virologist virologist);
	
	
	/**
	 * @return boolean
	 */
	public boolean check() {
		System.out.println("Checked");
		return true;
	}
	
	
	/** 
	 * @return Genetics
	 */
	public Genetics getGenetic() {
		return Genetic;
	}
	
	/** 
	 * @param genetic
	 */
	public void setGenetic(Genetics genetic) {
		Genetic = genetic;
	}
	
	/** 
	 * @return int
	 */
	public int getLivetime() {
		return livetime;
	}
	
	/** 
	 * @param livetime
	 */
	public void setLivetime(int livetime) {
		this.livetime = livetime;
	}
	
	
	/** 
	 * Összehasonlítja a paraméterként megadott ágenst a jelenlegi objektummal
	 * @param a
	 * @return boolean igaz, ha a két ágens tipusa megegyezik
	 */
	public boolean isSame(Agent a) {
		if(this.getClass() == a.getClass())
			return true;
		return false;
	}

	public abstract void infect(Virologist target);
}
