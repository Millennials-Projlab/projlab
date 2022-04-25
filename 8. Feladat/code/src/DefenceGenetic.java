import java.util.Random;

/**
* Defence osztály
*/
public class DefenceGenetic extends Genetics{
    public DefenceGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Defence has been learned.");
	}
	
	/** 
	 * Elkészíti az ágenst
	 * @return AmnesiaAgent
	 */
	public Agent generate(Virologist v) {
		Random rand = new Random();
		int amino = recipe.get(new Amino());
		int nukleotid = recipe.get(new Nukleotid());
		int defenceaagent = rand.nextInt(100);
		if ((v.countSubstance(new Amino()) >= amino) && (v.countSubstance(new Nukleotid()) >= nukleotid)) {
			v.setAmino(new DefenceAgent(this, defenceaagent));
			v.setNukleotid(new DefenceAgent(this, defenceaagent));
			return new DefenceAgent(this, defenceaagent);
		}
		return null;
	}
}
