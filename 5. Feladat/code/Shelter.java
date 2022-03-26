
public class Shelter extends Field {
	private Equipment Equipment;
	
	public void Place(Equipment Equipment) {
		System.out.println(Equipment.toString()+" "+"has been placed");
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}
	
	public void Enter(Virologist Virologist) {
		System.out.println("Virologist has entered");
	}

	public Equipment getEquipment() {
		return Equipment;
	}

	public void setEquipment(Equipment equipment) {
		Equipment = equipment;
	}
	
}
