package subjects;
import java.util.ArrayList;
import java.util.Random;
import main.IncorrectParameterException;
import observers.GameObserver;

public final class Game {
	public static boolean random = false;
	private static Map Map = new Map();
	private static ArrayList<Virologist> players = new ArrayList<Virologist>();
	private static Timer timer = new Timer();
	private static ArrayList<GameObserver> observerList = new ArrayList<GameObserver>();

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
		//Map = new Map();
		//players = new ArrayList<Virologist>();
		//timer = new Timer();
		timer.start();
		System.out.println("Game has started.");
	}
	
	public static void End() {
		System.out.println("Game has ended.");
	}

	
	/** 
	 * Elindítja az időt
	 * @param args
	 */
	public static void startTimer(String[] args) {
		if(timer.isRunning()) {
			System.out.println("Timer is already running.");
			return;
		}
		timer = new Timer();
		timer.start();
	}

	
	/** 
	 * Megállítja az időt
	 * @param args
	 */
	public static void stopTimer(String[] args) {
		if(!timer.isRunning()) {
			System.out.println("Timer is already stopped.");
			return;
		}
		timer.interrupt();
	}

	public static void tick() {
		for(Virologist virologist : players) {
			virologist.tick();
		}
	}

	/** 
	 * @return Map
	 */
	public static Map getMap() {
		return Map;
	}
	
	
	/** 
	 * @param name
	 * @return Virologist
	 * @throws IncorrectParameterException
	 */
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
	 * @param v
	 */
	public static void removePlayer(Virologist v) {
		players.remove(v);
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

	
	/** 
	 * Ellenőrzi, hogy a megadott nevű virológus létezik-e
	 * @param name
	 */
	private static void checkVirologistExistence(String name) {
		try {
			Game.getVirologist(name);
			throw new IncorrectParameterException("Virologist with name " + "\""+ name +"\" already exists");
		} catch(IncorrectParameterException e) {}
	}

	
	/** 
	 * Létrehoz egy új virológust a megadott paraméterekkel
	 * @param args
	 */
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

		System.out.println("CREATED: Virologist " + virologist.getName());
	}

	public static void gameInfo() {
		String infoString = "";

		infoString += "Fields: ";
		for(Field field : getMap().getFields()) {
			infoString += field.getName() + " ";			
		}
		infoString += "\n";

		infoString += "Virologists: ";
		for(Virologist virologist : players) {
			infoString += virologist.getName();
		}

		System.out.println(infoString);
	}

	public static void notifyObservers() {
		for(GameObserver observer : observerList) {
            observer.update();
        }
	}
}
