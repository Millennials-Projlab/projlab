/**
* Poison Agens osztály
*/
public class PoisonAgent extends Agent{
	
	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void Effect(Virologist virologist) {
		System.out.println("Poison Agent has its effect on  "+virologist.getName()+".");
	}

	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "setEffectFlag", "5");
		target.setEffectFlag(5);
		Logger.removeTab();
	}
}
