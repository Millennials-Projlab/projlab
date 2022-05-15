package subjects;
import main.MaximumSubstanceException;

/**
* Substance osztály
*/
public abstract class Substance {
	/** 
	 * Összehasonlítja a paraméterként megadott anyagot a jelenlegi objektummal
	 * @param g
	 * @return boolean igaz, ha a két anyag tipusa megegyezik
	 */
    public boolean isSame(Substance s) {
		if(this.getClass() == s.getClass())
			return true;
		return false;
	}

    public void pickUp(Virologist virologist) throws MaximumSubstanceException, MaximumSubstanceException {}
}
