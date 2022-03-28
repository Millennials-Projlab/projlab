/**
* cCape osztály
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
		Logger.addTab();
		Logger.log(v, "getDefenseRating", "");
		Logger.log(v, "setDefenseRating", "v.getDefenseRating() + 1");
		v.setDefenseRating(v.getDefenseRating() + 1);
		Logger.removeTab();
	}
}
