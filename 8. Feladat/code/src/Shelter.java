/**
* Shelter osztály
*/
public class Shelter extends Field {
	private Equipment Equipment;
  
	/** 
	 * Elhelyezi a tárgyat a mezőn
	 * @param equipment
	 */
	public void place(Equipment equipment) {
		Equipment = equipment;
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}

	
	/** 
	 * @return Equipment
	 */
	public Equipment getEquipment() {
		return Equipment;
	}

	
	/** 
	 * @param equipment
	 */
	public void setEquipment(Equipment equipment) {
		Equipment = equipment;
	}
	
	
	/** 
	 * A virológus felveszi a mezőn lévő tárgyat
	 * @param virologist
	 */
	public void lootItem(Virologist virologist) {
		if(virologist.getMaxEquipments() > virologist.getEquipments().size()) {
			virologist.addEquipment(Equipment);

			setEquipment(null);
		}
	}

}
