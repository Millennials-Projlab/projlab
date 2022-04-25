import java.util.Random;

/**
* Dance osztály
*/
public class DanceGenetic extends Genetics{
    public DanceGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Dance has been learned.");
	}
	
	/** 
	 * Elkészíti az ágenst
	 * @return AmnesiaAgent
	 */
	public Agent generate(Virologist v) {
		Random rand = new Random();
		int amino = recipe.get(new Amino());
		int nukleotid = recipe.get(new Nukleotid());
		int danceaagent = rand.nextInt(100);
		if ((v.countSubstance(new Amino()) >= amino) && (v.countSubstance(new Nukleotid()) >= nukleotid)) {
			v.setAmino(new DanceAgent(this, danceaagent));
			v.setNukleotid(new DanceAgent(this, danceaagent));
			return new DanceAgent(this, danceaagent);
		}
		return null;
	}
}
