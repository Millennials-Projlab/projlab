/**
* Nukleotid osztály
*/
public class Nukleotid extends Substance {
	/**
	* Felvenni az nukleotido-t
	* @param virologist
	*/
    public void pickUp(Virologist virologist) throws MaximumSubstanceException {
    	virologist.addSubstance(this);
		System.out.println("Nukleotid has been picked up.");
	}
}
