/**
* Package osztály
*/
public class Package extends Equipment {
	/** 
	 * Konstruktor
	 */
	public Package() {}
	

	/** 
	 * Elvégzi a felszerelés hatását
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {
		virologist.setMaxEquipments(virologist.getMaxEquipments() + 5);
	}

	public void endEffect(Virologist virologist) {
		virologist.setMaxEquipments(virologist.getMaxEquipments() - 5);
	}

	public String toString() {
		return "Package";		
	}
}
