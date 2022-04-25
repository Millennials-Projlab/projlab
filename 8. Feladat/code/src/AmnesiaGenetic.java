import java.util.Random;

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
	public Agent generate(Virologist v) {
		Random rand = new Random();
		int amino = recipe.get(new Amino());
		int nukleotid = recipe.get(new Nukleotid());
		int amnesiaagent = rand.nextInt(100);
		if ((v.countSubstance(new Amino()) >= amino) && (v.countSubstance(new Nukleotid()) >= nukleotid)) {
			v.setAmino(new AmnesiaAgent(this, amnesiaagent));
			v.setNukleotid(new AmnesiaAgent(this, amnesiaagent));
			return new AmnesiaAgent(this, amnesiaagent);
		}
		return null;
	}
}
