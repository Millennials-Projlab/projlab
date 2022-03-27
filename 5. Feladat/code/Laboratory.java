
/**
* laboratory osztaly
*/
public class Laboratory extends Field{
	private Genetics Genetic;
	
	public void Place(Genetics Genetic) {
		System.out.println("\t"+Genetic.toString()+" "+"has been placed");
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println(Virologist.getName()+" has entered");
	}

	public Genetics getGenetic() {
		return Genetic;
	}

	public void setGenetic(Genetics Genetic2) {
		Genetic=Genetic2;
	}
    
}
