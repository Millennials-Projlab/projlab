package subjects;
import java.util.ArrayList;
import java.util.Random;

import UI.EndGameDialog;
import main.IncorrectParameterException;
import main.Message;
import observers.Observer;

public final class Game {
	public static boolean random = false;
	private static Map Map = new Map();
	private static ArrayList<Virologist> players = new ArrayList<Virologist>();
	private static Timer timer = new Timer();
	private static ArrayList<Observer> observerList = new ArrayList<Observer>();
	private static Message message = new Message();

	public static Virologist selectedVirologist;

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
		buildMap();
		System.out.println("Game has started.");
	}
	
	public static void End(String virologist) {
		System.out.println("Game has ended.");
		new EndGameDialog(virologist);
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

	/*
	F1 F2 W1 F3 L1
	F4 S1 F5 L2 W2
	L3 W3 L4 F6 L5
	F7 S2 F8 S3 L6
	L7 S4 F9 W4 S5
	*/
	private static void buildMap() {
		try {
			Map.createField("F1");
			Map.createField("F2");
			Map.createWarehouse("W1");
			Map.createField("F3");
			Map.createLaboratory("L1", "DanceGenetic");
			Map.createField("F4");
			Map.createShelter("S1", "Package");
			Map.createField("F5");
			Map.createLaboratory("L2", "DefenceGenetic");
			Map.createWarehouse("W2");
			Map.createLaboratory("L3", "PoisonGenetic");
			Map.createWarehouse("W3");
			Map.createLaboratory("L4", "AmnesiaGenetic");
			Map.createField("F6");
			Map.createLaboratory("L5", "BearGenetic");
			Map.createField("F7");
			Map.createShelter("S2", "Axe");
			Map.createField("F8");
			Map.createShelter("S3", "Gloves");
			Map.createLaboratory("L6", "DefenceGenetic");
			Map.createLaboratory("L7", "AmnesiaGenetic");
			Map.createShelter("S4", "Cape");
			Map.createField("F9");
			Map.createWarehouse("W4");
			Map.createShelter("S5", "Package");

			Map.setNeighbor("F1", "F2");
			Map.setNeighbor("F2", "W1");
			Map.setNeighbor("W1", "F3");
			Map.setNeighbor("F3", "L1");
			Map.setNeighbor("F1", "F4");
			Map.setNeighbor("F2", "S1");
			Map.setNeighbor("W1", "F5");
			Map.setNeighbor("F3", "L2");
			Map.setNeighbor("L1", "W2");
			Map.setNeighbor("F4", "S1");
			Map.setNeighbor("S1", "F5");
			Map.setNeighbor("F5", "L2");
			Map.setNeighbor("L2", "W2");
			Map.setNeighbor("F4", "L3");
			Map.setNeighbor("S1", "W3");
			Map.setNeighbor("F5", "L4");
			Map.setNeighbor("L2", "F6");
			Map.setNeighbor("W2", "L5");
			Map.setNeighbor("L3", "W3");
			Map.setNeighbor("W3", "L4");
			Map.setNeighbor("L4", "F6");
			Map.setNeighbor("F6", "L5");
			Map.setNeighbor("L3", "F7");
			Map.setNeighbor("W3", "S2");
			Map.setNeighbor("L4", "F8");
			Map.setNeighbor("F6", "S3");
			Map.setNeighbor("L5", "L6");
			Map.setNeighbor("F7", "S2");
			Map.setNeighbor("S2", "F8");
			Map.setNeighbor("F8", "S3");
			Map.setNeighbor("S3", "L6");
			Map.setNeighbor("F7", "L7");
			Map.setNeighbor("S2", "S4");
			Map.setNeighbor("F8", "F9");
			Map.setNeighbor("S3", "W4");
			Map.setNeighbor("L6", "S5");
			Map.setNeighbor("L7", "S4");
			Map.setNeighbor("S4", "F9");
			Map.setNeighbor("F9", "W4");
			Map.setNeighbor("W4", "S5");
		} catch(IncorrectParameterException e) {
			errorMessage(e.getMessage());
		}
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
				End(virologist.getName());
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
	public static void createVirologist(String name) {
		Virologist virologist;

		checkVirologistExistence(name);

		Random rand = new Random();
		Field field;
		try {
			field = getMap().getFields().get(rand.nextInt(getMap().getFields().size()-1));
		} catch(IllegalArgumentException e) { // csak egy field van
			field = getMap().getFields().get(0);
		}
		
		virologist = new Virologist(name, rand.nextInt(1,5), rand.nextInt(5,10), field);

		for(Observer observer : observerList) {
			virologist.attach(observer);
		}

		players.add(virologist);

		System.out.println("CREATED: Virologist " + virologist.getName() + " Field: " + field.getName());
		notifyObservers();
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
		for(Observer observer : observerList) {
            observer.update();
        }
	}

	public static void attach(Observer observer) {
		observerList.add(observer);
	}

	public static void errorMessage(String messageText) {
		System.out.println("ERROR: " + message);
		message.setMessage("ERROR: " + messageText, true);
		notifyObservers();
	}

	public static void infoMessage(String messageText) {
		message.setMessage(messageText, false);
		System.out.println(messageText);
		notifyObservers();
	}

	public static Message getMessage() {
		return message;
	}
}
