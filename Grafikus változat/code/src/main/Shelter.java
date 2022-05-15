package main;
import subjects.*;

public class Shelter extends Field {
	private Equipment equipment;
  
	public Shelter(String name) {
		super(name);
	}

	/** 
	 * Elhelyezi a tárgyat a mezőn
	 * @param equipment
	 */
	public void place(Equipment equipment) {
		this.equipment = equipment;
	}
	
	/** 
	 * Kiuriti a mezot
	 */
	public void Clear() {
		equipment = null;
		System.out.println("Cleared");
	}

	/** 
	 * @return Equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}	
	
	/** 
	 * A virológus felveszi a mezőn lévő tárgyat
	 * @param virologist
	 */
	public void lootItem(Virologist virologist) {
		if(equipment == null) {
			System.out.println("Shelter does not have an equipment in it.");
			return;
		}

		if(virologist.getMaxEquipments() > virologist.getEquipments().size()) {
			virologist.addEquipment(equipment);

			equipment = null;
			return;
		}

		System.out.println("Virologist does not have enough space.");
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		String returnString = super.toString();
		returnString += "\nEquipment: ";
		returnString += equipment != null ?	equipment.toString() : "no equipment";

		return returnString;
	}
}
