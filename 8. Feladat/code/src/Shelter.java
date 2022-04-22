/**
* Shelter osztály
*/
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
		if(virologist.getMaxEquipments() > virologist.getEquipments().size()) {
			virologist.addEquipment(equipment);

			equipment = null;
		}
	}

}
