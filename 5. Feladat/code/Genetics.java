import java.util.HashMap;

/**
* genetics osztaly
*/
public abstract class Genetics {
	HashMap<Substance, Integer> recipe;

	public Genetics(int aminoCount, int nukleoCount) {
		recipe = new HashMap<Substance, Integer>();
		recipe.put(new Amino(), aminoCount);
		recipe.put(new Nukleotid(), nukleoCount);
	}

	public abstract Agent generate();

	public boolean isSame(Genetics g) {
		if(this.getClass() == g.getClass())
			return true;
		return false;
	}

	public HashMap<Substance, Integer> getRecipe() {
		return recipe;
	}

    public void PickUp() {	
	}
	
	public void Effect(Virologist virologist) {	
	}
}
