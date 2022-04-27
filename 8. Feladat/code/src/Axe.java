/**
* Axe osztály
*/
public class Axe extends Equipment {
	private boolean usable;
	/** 
	 * Konstruktor
	 */
	public Axe() {
		usable = true;
	}
	
	/** 
	 * Elvégzi a felszerelés hatását
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {}

	/** 
	 * Leállítja a felszerelés hatását
	 * @param virologist
	 */
	public void endEffect(Virologist virologist) {}

	
	/** 
	 * Felhasználja a baltát
	 * @param target
	 */
	public void use(Virologist target) {
		usable = false;
		target.axeHit();
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "Axe";
	}
}
