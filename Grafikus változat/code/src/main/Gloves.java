package main;
import subjects.*;

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

	
	/** 
	 * Használja a kesztyűt
	 * @param virologist
	 */
	public void use(Virologist virologist) {
		uses -= 1;
		if(uses == 0) {
			virologist.removeEquipment(this);
		}
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "Gloves";
	}
}
