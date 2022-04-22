/**
* Package osztály
*/
public class Package extends Equipment {
	public Package() {
	}
	
	public void PickUp() {
		System.out.println("Package has been picked up.");
	}
	
	
	/** 
	 * Elvégzi a felszerelés hatását
	 * @param v
	 */
	public void Effect(Virologist v) {
		v.setMaxEquipments(v.getMaxEquipments() + 1);
	}
}
