
/**
* shelter osztaly
*/
public class Shelter extends Field {
	private Equipment Equipment;
	
	public void place(Equipment Equipment) {
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
	
}
