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
		Logger.addTab();
		Logger.log(v, "setEquipmentflag", "1");
		v.setEquipmentflag(1);
		Logger.removeTab();
	}
}
