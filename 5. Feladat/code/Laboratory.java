import java.util.ArrayList;

/**
* laboratory osztaly
*/
public class Laboratory extends Field{
	private Genetics Genetic;
	
	public void place(Genetics Genetic) {
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println(Virologist.getName()+" has entered");
	}

	public Genetics getGenetic() {
		return Genetic;
	}

	public void setGenetic(Genetics Genetic2) {
		Genetic = Genetic2;
	}
    
	public void lootItem(Virologist virologist) {
		Logger.addTab();
		Logger.log(virologist, "getGenetics", "");
		ArrayList<Genetics> learnedGenetics = virologist.getGenetics();
		Logger.removeTab();

		// TODO check if genetics is learned

		Logger.addTab();
		Logger.log(virologist, "addGenetics", "Genetic");
		virologist.addGenetics(Genetic);
		Logger.removeTab();
	}
}
