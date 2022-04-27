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
	 * Elvégzi a felszerelés hatását
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {
		virologist.setDefenseRating(virologist.getDefenseRating() * 0.177);
	}

	public void endEffect(Virologist virologist) {
		virologist.setDefenseRating(virologist.getDefenseRating() / 0.177);
	}

	public String toString() {
		return "Cape";
	}
}
