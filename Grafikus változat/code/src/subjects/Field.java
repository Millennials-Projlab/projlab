package subjects;

import java.util.ArrayList;


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
	
    
	/** 
	 * @return String
	 */
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
		this.virologists = virologists;
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

	
	/** 
	 * @return String
	 */
	public String toString() {
		String returnString = "";
		returnString += "Name: " + name + "\n";
		returnString += "Type: " + this.getClass().getSimpleName() + "\n";
		returnString += "Neighbors: ";
		for(int i = 0; i < neighbours.size(); i++) {
			returnString += neighbours.get(i).getName() + " ";
		}
		returnString += "\n";

		returnString += "Virologists: ";
		for(int i = 0; i < virologists.size(); i++) {
			returnString += virologists.get(i).getName() + " ";
		}

		return returnString;
	}
	
	
	/** 
	 * @param field
	 * @return boolean
	 */
	public boolean isSame(Field field) {
		if(this.getClass() == field.getClass()) {
			return true;
		}
		return false;
	}
}