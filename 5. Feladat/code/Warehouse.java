import java.util.ArrayList;

public class Warehouse extends Field{
	private ArrayList<Substances> Substances;
	
	public void Place(ArrayList<Substances> Substances) {
        for(Substances i: Substances){
            System.out.println("\t"+i.toString()+" "+"has been placed");
        }
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println("Virologist has entered");
	}

	public ArrayList<Substances> getSubstances() {
		return Substances;
	}

	public void setSubstances(ArrayList<Substances> substances) {
		Substances = substances;
	}
    
}