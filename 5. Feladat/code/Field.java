import java.util.ArrayList;

/**
* field osztaly
*/
public class Field {
	private ArrayList<Virologist> Virologists;
	private ArrayList<Field> Neighbours;
	
	public Field() {
		//setVirologists(new ArrayList<Virologist>());
		Neighbours = new ArrayList<Field>();
		//setNeighbours(new ArrayList<Field>());
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println("\t"+Virologist.getName()+" has entered");
	}
	
	public void Leave(Virologist Virologist) {
		System.out.println("\t"+Virologist.getName()+" has left");
	}

	public ArrayList<Virologist> getVirologists() {
		return Virologists;
	}

	public void setVirologists(ArrayList<Virologist> virologists) {
		Virologists = virologists;
		System.out.println("Virologists have been set");
	}

	public ArrayList<Field> getNeighbours() {
		return Neighbours;
	}

	public void setNeighbours(ArrayList<Field> neighbours) {
		Neighbours = neighbours;
	}
	
	public void setNeighbour(Field field) {
		Neighbours.add(field);
	}
	
	
	
}
