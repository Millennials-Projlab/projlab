
/**
* defence osztaly
*/
public class DefenceGenetic extends Genetics{
    public void PickUp() {
		System.out.println("Defence has been learned.");
	}
	
	public void Effect(Virologist virologist) {
		System.out.println("Defence has its effect on  "+virologist.getName()+".");
	}
}
