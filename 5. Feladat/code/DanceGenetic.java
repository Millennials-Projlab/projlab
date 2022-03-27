
/**
* dance osztaly
*/
public class DanceGenetic extends Genetics{
    public void PickUp() {
		System.out.println("Dance has been learned.");
	}
	
	public void Effect(Virologist virologist) {
		System.out.println("Dance has its effect on  "+virologist.getName()+".");
	}
}
