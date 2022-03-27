
/**
* agens osztaly
*/
public abstract class Agent {
	private Genetics Genetic;
	private Substance Substance;
	private int livetime;
	
	public void Generate() {
		if (check()) {
			System.out.println("Agent has been Generated");
			
		}
	}
	
	public abstract void Effect(Virologist virologist);
	
	public boolean check() {
		System.out.println("Checked");
		return true;
	}
	
	public Genetics getGenetic() {
		return Genetic;
	}
	public void setGenetic(Genetics genetic) {
		Genetic = genetic;
	}
	public Substance getSubstance() {
		return Substance;
	}
	public void setSubstance(Substance substance) {
		Substance = substance;
	}
	public int getLivetime() {
		return livetime;
	}
	public void setLivetime(int livetime) {
		this.livetime = livetime;
	}
	
	
}
