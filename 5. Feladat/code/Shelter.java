
/**
* shelter osztaly
*/
public class Shelter extends Field {
	private Equipment Equipment;
	
	public void place(Equipment equipment) {
		Equipment = equipment;
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println(Virologist.getName()+" has entered");
	}

	public Equipment getEquipment() {
		return Equipment;
	}

	public void setEquipment(Equipment equipment) {
		Equipment = equipment;
	}
	
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
