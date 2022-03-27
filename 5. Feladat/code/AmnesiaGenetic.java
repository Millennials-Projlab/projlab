public class AmnesiaGenetic extends Genetics {
    public void PickUp() {
		System.out.println("Amnesia has been learned.");
	}
	
	public void Effect(Virologist virologist) {
		System.out.println("Amnesia has its effect on  "+virologist.getName()+".");
	}
}
