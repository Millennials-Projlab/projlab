/**
* Defence Agens osztály
*/
public class DefenceAgent extends Agent{
	
	/** 
	 * Elindítja az ágens effektjét a paraméterként megadott virológuson
	 * @param virologist
	 */
	public void Effect(Virologist virologist) {
		System.out.println("Defence Agent has its effect on  "+virologist.getName()+".");
	}

	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "setEffectFlag", "1");
		target.setEffectFlag(1);
		Logger.removeTab();
	}
}
