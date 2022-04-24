/**
* Cape osztály
*/
public class Cape extends Equipment {
	/** 
	 * Konstruktor
	 */
	public Cape() {
	}
	
	/** 
	 * A virologus felveszi a felszerelest a mezorol
	 * @param s
	 * @param v
	 */
	public void PickUp(Shelter s, Virologist v) {
		s.lootItem(v);
		s.Clear();
		System.out.print("Cape has been picked up");
	}

	/** 
	 * Elvégzi a felszerelés hatását
	 * @param v
	 */
	public void Effect(Virologist v) {
		v.setDefenseRating(v.getDefenseRating() + 1);
	}
}
