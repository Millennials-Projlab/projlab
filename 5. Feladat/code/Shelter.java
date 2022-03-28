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
		Logger.addTab();
		Logger.log(virologist, "getMaxEquipments", "");
		Logger.log(virologist, "getEquipments", "");
		Logger.removeTab();
		if(virologist.getMaxEquipments() > virologist.getEquipments().size()) {
			Logger.addTab();
			Logger.log(virologist, "addEquipment", "Equipment");
			virologist.addEquipment(Equipment);
			Logger.removeTab();
	
			Logger.addTab();
			Logger.log(this, "setEquipment", "null");
			setEquipment(null);
			Logger.removeTab();
		}
	}

}
