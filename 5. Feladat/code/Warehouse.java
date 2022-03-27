import java.util.ArrayList;
/**
* warehouse osztaly
*/
public class Warehouse extends Field{
	private ArrayList<Substance> Substances;
	
	public void place(ArrayList<Substance> Substances) {
        for(Substance i: Substances){
            System.out.println("\t"+i.toString()+" "+"has been placed");
        }
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println(Virologist.getName()+" has entered");
	}

	public ArrayList<Substance> getSubstances() {
		return Substances;
	}

	public void setSubstances(ArrayList<Substance> substances) {
		Substances = substances;
	}
    
}
