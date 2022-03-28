/**
* Amnesia Ágens osztály
*/
public class AmnesiaAgent extends Agent{
	
	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void Effect(Virologist virologist) {
		System.out.println("Amnezia Agent has its effect on  "+virologist.getName()+".");
	}

	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "clearCollectedGenetics", "");
		target.clearCollectedGenetics();
		Logger.removeTab();
	}
}
