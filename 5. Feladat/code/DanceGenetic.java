
/**
* dance osztaly
*/
public class DanceGenetic extends Genetics{
    public DanceGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}

	public void PickUp() {
		System.out.println("Dance has been learned.");
	}
	
	public void Effect(Virologist virologist) {
		System.out.println("Dance has its effect on  "+virologist.getName()+".");
	}

	public DanceAgent generate() {
		return new DanceAgent();
	}
}
