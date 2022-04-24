/**
* Nukleotid osztály
*/
public class Nukleotid extends Substance {
	/**
	* Felvenni az nukleotido-t
	* @param v
	*/
    public void PickUp(Virologist v) {
    	v.addSubstance(this);
		System.out.println("Nukleotid has been picked up.");
	}
}
