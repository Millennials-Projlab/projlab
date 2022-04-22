/**
* Cape osztály
*/
public class Cape extends Equipment {
	public void PickUp() {
		System.out.println("Cape has been picked up.");
	}
	
	public void Effect() {
		System.out.println("Cape has its effect.");
	}

	
	/** 
	 * Elvégzi a felszerelés hatását
	 * @param v
	 */
	public void Effect(Virologist v) {
		v.setDefenseRating(v.getDefenseRating() + 1);
	}
}
