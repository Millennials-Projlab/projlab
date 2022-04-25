import java.util.ArrayList;

/**
* Game osztály
*/
public final class Game {
	public static boolean random = false;
	private static Map Map = new Map();
	private static ArrayList<Virologist> Players;

	public static void toggleRandom() {
		if(random) {
			random = false;
			System.out.println("RANDOMIZER OFF");
			return;
		}

		random = true;
		System.out.println("RANDOMIZER ON");
	}
	
	/** 
	 * Elinditja a jatekot
	 */
	public static void Start() {
		Map = new Map();
		Players = new ArrayList<Virologist>();
	}
	
	public static void End() {
		System.out.println("Game has ended.");
	}

	/** 
	 * @return Map
	 */
	public static Map getMap() {
		return Map;
	}
	
	public static Virologist getVirologist(String name) throws IncorrectParameterException {
		for(Virologist virologist : Players) {
			if (virologist.getName().equals(name)) {
				return virologist;
			}
		}

		throw new IncorrectParameterException("Virologist with name " + name + " does not exist.");
	}

	/** 
	 * @return ArrayList<Virologist>
	 */
	public static ArrayList<Virologist> getPlayers() {
		return Players;
	}

	/** 
	 * Hozzaad egy jatekost
	 * @param v
	 */
	public static void addPlayer(Virologist v) {
		Players.add(v);
	}
	
	/** 
	 * Tick-el a jatek, ha valamelyik virologus megtanulta az osszes genetikai kodot
	 * @param v
	 */
	public void Tick() {
		for(Virologist virologist : Players) {
			if (virologist.collectedAllGenetics() == true) {
				End();
				return;
			}
		}
	}
}
