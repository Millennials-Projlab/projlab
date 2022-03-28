/**
* amnesia agens osztaly
*/
public class AmnesiaAgent extends Agent{
	public void Effect(Virologist virologist) {
		System.out.println("Amnezia Agent has its effect on  "+virologist.getName()+".");
	}

	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "clearCollectedGenetics", "");
		target.clearCollectedGenetics();
		Logger.removeTab();
	}
}
