
/**
* Amino osztály
*/
public class Amino extends Substance {
	/**
	* Felvenni az amino-t
	* @param v
	*/
    public void PickUp(Virologist v) {
    	v.addSubstance(this);
		System.out.println("Amino has been picked up.");
	}
}
