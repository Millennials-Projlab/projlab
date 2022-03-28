/**
* poison agens osztaly
*/
public class PoisonAgent extends Agent{
	public void Effect(Virologist virologist) {
		System.out.println("Poison Agent has its effect on  "+virologist.getName()+".");
	}

	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "setEffectFlag", "5");
		target.setEffectFlag(5);
		Logger.removeTab();
	}
}
