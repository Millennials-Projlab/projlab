import java.util.ArrayList;

public class Field {
	private ArrayList<Virologist> Virologists;
	private ArrayList<Field> Neighbours;
	
	public Field() {
		setVirologists(new ArrayList<Virologist>());
		setNeighbours(new ArrayList<Field>());
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
	}

	public ArrayList<Field> getNeighbours() {
		return Neighbours;
	}

	public void setNeighbours(ArrayList<Field> neighbours) {
		Neighbours = neighbours;
	}
	
	public void SetNeighbour(Field field) {
		Neighbours.add(field);
		System.out.println("\t"+"Neighbour has been set");
	}
	
	
	
}
