/**
* dance agens osztaly
*/
public class DanceAgent extends Agent{
	public void Effect(Virologist virologist) {
		System.out.println("Dance Agent has its effect on  "+virologist.getName()+".");
	}

	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "dance", "");
		target.dance();
		Logger.removeTab();
	}
}
