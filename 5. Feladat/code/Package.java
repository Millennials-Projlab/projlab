
/**
* package osztaly
*/
public class Package extends Equipment {
	public Package() {
	}
	
	public void PickUp() {
		System.out.println("Package has been picked up.");
	}
	
	public void Effect(Virologist v) {
		Logger.addTab();
		Logger.log(v, "getMaxEquipments", "");
		Logger.log(v, "setMaxEquipments", "v.getMaxEquipments() + 1");
		v.setMaxEquipments(v.getMaxEquipments() + 1);
		Logger.removeTab();
	}
}
