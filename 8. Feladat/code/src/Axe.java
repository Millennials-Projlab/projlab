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

	public void endEffect(Virologist virologist) {}

	public void use(Virologist target) {
		usable = false;
		target.axeHit();
	}

	public String toString() {
		return "Axe";
	}
}
