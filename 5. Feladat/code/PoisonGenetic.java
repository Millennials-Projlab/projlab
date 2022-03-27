public class PoisonGenetic extends Genetics {
    public void PickUp() {
		System.out.println("Poison has been learned.");
	}
	
	public void Effect(Virologist virologist) {
		System.out.println("Poison has its effect on Virologist.");
	}
}
