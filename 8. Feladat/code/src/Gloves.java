/**
* Gloves osztály
*/
public class Gloves extends Equipment {
	/** 
	 * Konstruktor
	 */
	public Gloves() {
	}
	
	/** 
	 * A virologus felveszi a felszerelest a mezorol
	 * @param s
	 * @param v
	 */
	public void PickUp(Shelter s, Virologist v) {
		s.lootItem(v);
		s.Clear();
		System.out.print("Gloves has been picked up");
	}
	
	/** 
	 * Elvégzi a felszerelés hatását
	 * @param v
	 */
	public void Effect(Virologist v) {
		v.setEquipmentflag(1);
	}

	public String toString() {
		return "Gloves";
	}
}
