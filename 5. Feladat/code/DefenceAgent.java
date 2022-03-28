/**
* defence agens osztaly
*/
public class DefenceAgent extends Agent{
	public void Effect(Virologist virologist) {
		System.out.println("Defence Agent has its effect on  "+virologist.getName()+".");
	}

	public void infect(Virologist target) {
		Logger.addTab();
		Logger.log(target, "setEffectFlag", "1");
		target.setEffectFlag(1);
		Logger.removeTab();
	}
}
