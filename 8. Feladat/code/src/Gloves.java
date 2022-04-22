/**
* Gloves osztály
*/
public class Gloves extends Equipment {
	public void PickUp() {
		System.out.println("Gloves has been picked up.");
	}
	
	
	/** 
	 * Elvégzi a felszerelés hatását
	 * @param v
	 */
	public void Effect(Virologist v) {
		v.setEquipmentflag(1);
	}
}
