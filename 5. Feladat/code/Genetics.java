import java.util.HashMap;

/**
* Genetics osztály
*/
public abstract class Genetics {
	HashMap<Substance, Integer> recipe;

	public Genetics(int aminoCount, int nukleoCount) {
		recipe = new HashMap<Substance, Integer>();
		recipe.put(new Amino(), aminoCount);
		recipe.put(new Nukleotid(), nukleoCount);
	}

	public abstract Agent generate();

	
	/** 
	 * Összehasonlítja a paraméterként megadott genetikai kódot a jelenlegi objektummal
	 * @param g
	 * @return boolean igaz, ha a két genetikai kód tipusa megegyezik
	 */
	public boolean isSame(Genetics g) {
		if(this.getClass() == g.getClass())
			return true;
		return false;
	}

	
	/** 
	 * @return HashMap<Substance, Integer>
	 */
	public HashMap<Substance, Integer> getRecipe() {
		return recipe;
	}

    public void PickUp() {	
	}
}
