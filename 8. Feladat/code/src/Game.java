import java.util.ArrayList;
import java.util.Random;

/**
* Game osztály
*/
public final class Game {
	public static boolean random = false;
	private static Map Map = new Map();
	private static ArrayList<Virologist> players = new ArrayList<Virologist>();

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
		players = new ArrayList<Virologist>();
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
		for(Virologist virologist : players) {
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
		return players;
	}

	/** 
	 * Hozzaad egy jatekost
	 * @param v
	 */
	public static void addPlayer(Virologist v) {
		players.add(v);
	}
	
	/** 
	 * Tick-el a jatek, ha valamelyik virologus megtanulta az osszes genetikai kodot
	 * @param v
	 */
	public void Tick() {
		for(Virologist virologist : players) {
			if (virologist.collectedAllGenetics() == true) {
				End();
				return;
			}
		}
	}

	private static void checkVirologistExistence(String name) {
		try {
			Game.getVirologist(name);
			throw new IncorrectParameterException("Virologist with name " + "\""+ name +"\" already exists");
		} catch(IncorrectParameterException e) {}
	}

	public static void createVirologist(String[] args) {
		Virologist virologist;
		if(!random) {
			checkVirologistExistence(args[0]);
			virologist = new Virologist(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), getMap().getField(args[3]));
		}
		else {
			Random rand = new Random();
			Field field;
			try {
				field = getMap().getFields().get(rand.nextInt(getMap().getFields().size()-1));
			} catch(IllegalArgumentException e) { // csak egy field van
				field = getMap().getFields().get(0);
			}
			
			virologist = new Virologist(args[0], rand.nextInt(1,5), rand.nextInt(5,10), field);
		}
		players.add(virologist);
	}
}
