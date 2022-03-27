
/**
* agens osztaly
*/
public class Agent {
	private Genetics Genetic;
	private Substances Substance;
	private int livetime;
	
	public void Generate() {
		if (check()) {
			System.out.println("Agent has been Generated");
		}
	}
	
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
	public Substances getSubstance() {
		return Substance;
	}
	public void setSubstance(Substances substance) {
		Substance = substance;
	}
	public int getLivetime() {
		return livetime;
	}
	public void setLivetime(int livetime) {
		this.livetime = livetime;
	}
	
	
}
