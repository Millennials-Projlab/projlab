package main;
import subjects.*;

public class AmnesiaAgent extends Agent {
	public AmnesiaAgent(Genetics g, int l) {
		super(g, l);
	}
	
	/** 
	 * Megfertőzi a paraméterként megadott virológust.
	 * @param target
	 */
	public void infect(Virologist target, Virologist sender) {
		if(target.hasEquipment("Gloves")) {
			target.useGloves();
			target.addAgent(this);
			target.infect(sender, toString());
			return;
		}
		if(target.getEffectFlag() < 3) {
			target.clearCollectedGenetics();
			return;
		}
		System.out.println("Target is immune and can not be infected.");
	}

	
	/** 
	 * @param agentName
	 * @return boolean
	 */
	public boolean isSame(String agentName) {
		return agentName.equals("AmnesiaAgent") ? true : false;
	}

	
	/** 
	 * @return String
	 */
	public String toString() {
		return "AmnesiaAgent";
	}
}
