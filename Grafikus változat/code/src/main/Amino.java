package main;
import subjects.*;

public class Amino extends Substance {
	/**
	* Felvenni az amino-t
	* @param virologist
	*/
    public void pickUp(Virologist virologist) throws MaximumSubstanceException {
    	virologist.addSubstance(this);
		System.out.println("Amino has been picked up.");
	}
}
