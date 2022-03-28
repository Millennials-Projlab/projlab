
/**
* amnesia osztaly
*/
public class AmnesiaGenetic extends Genetics {
    public AmnesiaGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Amnesia has been learned.");
	}
	
	public void Effect(Virologist virologist) {
		System.out.println("Amnesia has its effect on  "+virologist.getName()+".");
	}

	public AmnesiaAgent generate() {
		return new AmnesiaAgent();
	}
}
