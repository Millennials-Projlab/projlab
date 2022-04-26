/**
* Axe osztály
*/
public class Axe extends Equipment {
	/** 
	 * Konstruktor
	 */
	public Axe() {
	}
	
	/** 
	 * A virologus felveszi a felszerelest a mezorol
	 * @param s
	 * @param v
	 */
	public void PickUp(Shelter s, Virologist v) {
		s.lootItem(v);
		s.Clear();
		System.out.print("Axe has been picked up");
	}

	/** 
	 * Elvégzi a felszerelés hatását
	 * @param v
	 */
	public void Effect(Virologist v) {
		
	}

	public String toString() {
		return "Axe";
	}
}
