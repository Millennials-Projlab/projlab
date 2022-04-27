/**
* Package osztály
*/
public class Package extends Equipment {
	/** 
	 * Konstruktor
	 */
	public Package() {}
	

	/** 
	 * Elvégzi a felszerelés hatását
	 * @param virologist
	 */
	public void startEffect(Virologist virologist) {
		virologist.setMaxSubstance(virologist.getMaxSubstance() + 5);
	}

	
	/** 
	 * Leállítja a felszerelés hatását
	 * @param virologist
	 */
	public void endEffect(Virologist virologist) {
		virologist.setMaxSubstance(virologist.getMaxSubstance() - 5);
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "Package";		
	}
}
