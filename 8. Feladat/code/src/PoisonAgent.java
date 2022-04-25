/**
* Poison Agens osztály
*/
public class PoisonAgent extends Agent{
	public PoisonAgent(Genetics g, int l) {
		super(g, l);
		// TODO Auto-generated constructor stub
	}


	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void Effect(Virologist virologist) {
		virologist.setPoisoned(true);
		System.out.println("Poison Agent has its effect on  "+virologist.getName()+".");
	}

	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		target.setEffectFlag(5);
	}
}
