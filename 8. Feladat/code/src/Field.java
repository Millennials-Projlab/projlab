import java.util.ArrayList;

/**
* Field osztály
*/
public class Field {
    private String name;
	private ArrayList<Virologist> virologists;
	private ArrayList<Field> neighbours;
	
	public Field() {
		virologists = new ArrayList<Virologist>();
		neighbours = new ArrayList<Field>();
	}

    public Field(String name) {
        this.name = name;
        virologists = new ArrayList<Virologist>();
		neighbours = new ArrayList<Field>();
    }
	
    public String getName() {
        return name;
    }
	
	/** 
	 * Belépteti a virológust a mezőre
	 * @param virologist
	 */
	public void enter(Virologist virologist) {
		virologists.add(virologist);
	}
	
	
	/** 
	 * Lelépteti a virológust a mezőről
	 * @param virologist
	 */
	public void leave(Virologist virologist) {
		virologists.remove(virologist);
	}

	
	/** 
	 * @return ArrayList<Virologist>
	 */
	public ArrayList<Virologist> getVirologists() {
		return virologists;
	}
	
	/** 
	 * @return Virologist
	 */
	public Virologist getVirologistbyname(String name) {
		for (Virologist v : virologists) {
			if(v.getName().equals(name)) {
				return v;
			}
		}
		return null;
	}

	
	/** 
	 * @param virologists
	 */
	public void setVirologists(ArrayList<Virologist> virologists) {
		virologists = virologists;
		System.out.println("Virologists have been set");
	}

	
	/** 
	 * @return ArrayList<Field>
	 */
	public ArrayList<Field> getNeighbours() {
		return neighbours;
	}

	
	/** 
	 * @param neighbours
	 */
	public void setNeighbours(ArrayList<Field> neighbours) {
		this.neighbours = neighbours;
	}
	
	
	/** 
	 * @param field
	 */
	public void setNeighbour(Field field) {
		neighbours.add(field);
	}
	
	public void lootItem(Virologist virologist) {}
	
}