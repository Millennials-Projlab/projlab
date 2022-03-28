import java.util.ArrayList;

/**
* Field osztály
*/
public class Field {
	private ArrayList<Virologist> Virologists;
	private ArrayList<Field> Neighbours;
	
	public Field() {
		Virologists = new ArrayList<Virologist>();
		Neighbours = new ArrayList<Field>();
	}
	
	
	/** 
	 * Belépteti a virológust a mezőre
	 * @param virologist
	 */
	public void enter(Virologist virologist) {
		Virologists.add(virologist);
	}
	
	
	/** 
	 * Lelépteti a virológust a mezőről
	 * @param virologist
	 */
	public void leave(Virologist virologist) {
		Virologists.remove(virologist);
	}

	
	/** 
	 * @return ArrayList<Virologist>
	 */
	public ArrayList<Virologist> getVirologists() {
		return Virologists;
	}

	
	/** 
	 * @param virologists
	 */
	public void setVirologists(ArrayList<Virologist> virologists) {
		Virologists = virologists;
		System.out.println("Virologists have been set");
	}

	
	/** 
	 * @return ArrayList<Field>
	 */
	public ArrayList<Field> getNeighbours() {
		return Neighbours;
	}

	
	/** 
	 * @param neighbours
	 */
	public void setNeighbours(ArrayList<Field> neighbours) {
		Neighbours = neighbours;
	}
	
	
	/** 
	 * @param field
	 */
	public void setNeighbour(Field field) {
		Neighbours.add(field);
	}
	
	public void lootItem(Virologist virologist) {}
	
}
