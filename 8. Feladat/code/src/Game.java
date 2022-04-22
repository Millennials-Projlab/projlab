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

	
	/** 
	 * @return ArrayList<Virologist>
	 */
	public static ArrayList<Virologist> getPlayers() {
		return Players;
	}

	
	/** 
	 * @param v
	 */
	public static void addPlayer(Virologist v) {
		Players.add(v);
	}
	
	public void Tick() {
		for(Virologist virologist : Players) {
			if (virologist.collectedAllGenetics() == true) {
				End();

				return;
			}
		}
	}
}
