/**
* Gloves osztály
*/
public class Gloves extends Equipment {
	private int uses;
	/** 
	 * Konstruktor
	 */
	public Gloves() {
		uses = 3;
	}
	
	/** 
	 * Elvégzi a felszerelés hatását
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {}

	public void endEffect(Virologist virologist) {}

	public void use(Virologist virologist) {
		uses -= 1;
		if(uses == 0) {
			virologist.removeEquipment(this);
		}
	}

	public String toString() {
		return "Gloves";
	}
}
