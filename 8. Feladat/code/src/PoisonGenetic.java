import java.util.Random;

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
	 * @return AmnesiaAgent
	 */
	public Agent generate(Virologist v) {
		Random rand = new Random();
		int amino = recipe.get(new Amino());
		int nukleotid = recipe.get(new Nukleotid());
		int poisonagent = rand.nextInt(100);
		if ((v.countSubstance(new Amino()) >= amino) && (v.countSubstance(new Nukleotid()) >= nukleotid)) {
			v.setAmino(new PoisonAgent(this, poisonagent));
			v.setNukleotid(new PoisonAgent(this, poisonagent));
			return new PoisonAgent(this, poisonagent);
		}
		return null;
	}

	public String toString() {
		return "PoisonGenetic";
	}
}
