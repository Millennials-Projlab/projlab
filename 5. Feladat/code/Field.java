import java.util.ArrayList;

/**
* field osztaly
*/
public class Field {
	private ArrayList<Virologist> Virologists;
	private ArrayList<Field> Neighbours;
	
	public Field() {
		Virologists = new ArrayList<Virologist>();
		Neighbours = new ArrayList<Field>();
	}
	
	public void enter(Virologist virologist) {
		Virologists.add(virologist);
	}
	
	public void leave(Virologist virologist) {
		Virologists.remove(virologist);
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
	
	public void lootItem(Virologist virologist) {}
	
}
