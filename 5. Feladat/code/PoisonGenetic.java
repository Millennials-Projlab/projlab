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
	
	public void Effect(Virologist virologist) {
		System.out.println("Poison has its effect on "+virologist.getName()+".");
	}

	public PoisonAgent generate() {
		return new PoisonAgent();
	}
}
