import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Skeleton osztály
 */
public class Skeleton {
	public static Logger logger;
	/**
	 * Use-case menük kiírása
	 */
	public static void printusecase() {
        System.out.println("[1] "+"Map creates Fields");
        System.out.println("[2] "+"Virologist moves to a Field");
        System.out.println("[3] "+"Virologist produces Agent");
        System.out.println("[4] "+"Virologist picks up equipment");
        System.out.println("[5] "+"Virologist wins");
        System.out.println("[6] "+"Timer is ticking");
        System.out.println("[7] "+"Virologist learns Genetic");
		System.out.println("[8] "+"Virologist infects another Virologist");
	}
	
	/**
	 * Mezők létrehozása
	 */
	public static void map_creates_fields() {
		Game Game = new Game();
		Game.Start();
	}
	
	/**
	 * Virológus mozgása
	 */
	public static void virologist_moves_to_a_field(){
		Scanner scanner = new Scanner(System.in);

		boolean areNeighbours = false;
		System.out.print("Are Field and NextField neighbours? y/n: \n");
		if(scanner.next().charAt(0) == 'y')
			areNeighbours = true;

		Field Field = new Field();
		Field NextField = new Field();
		if(areNeighbours) {
			Field.setNeighbour(NextField);
			NextField.setNeighbour(Field);
		}

		Virologist virologist = new Virologist(0, "", 0, Field);

		Logger.addTab();
		Logger.log(virologist, "move", Arrays.asList("NextField"));
		virologist.move(NextField);
		Logger.removeTab();
	}
	
	
	/**
	 * Telik az idő
	 */
	public static void timer() {
		Timer Timer = new Timer();
		
		Timer.Start();
		while (Timer.isTimer()) {
			Timer.Tick();
			Timer.setTimer(false);
		}
		Timer.Stop();
	}
	
	/**
	 * Virológus nyer
	 */
	public static void virologist_wins() {
		Game Game = new Game();
		Virologist virologist = new Virologist(1, "test", 1, new Field());
		Game.addPlayer(virologist);

		Logger.addTab();
		Logger.log(Game, "Tick", "");
		Game.Tick();
		Logger.removeTab();
	}
	

	/**
	 * Virológus létrehoz egy ágenst
	 */
	public static void virologist_produces_agent() {
		Scanner console = new Scanner(System.in);

		Field field = new Field();
		Virologist virologist = new Virologist(1, "", 0, field);


		System.out.println("Does the virologist have enough substances? y/n \n");
		if(console.next().charAt(0) == 'y') {
			Nukleotid n = new Nukleotid();
			Amino a = new Amino();
			virologist.addSubstance(n);
			virologist.addSubstance(a);
		}

		System.out.println("[1] Produce Dance Agent");
		System.out.println("[2] Produce Defence Agent");
		System.out.println("[3] Produce Poison Agent");
		System.out.println("[4] Produce Amnesia Agent");

		switch(console.nextInt()) {
			case 1:
				DanceGenetic danceGenetic = new DanceGenetic(1, 1);
				virologist.addGenetics(danceGenetic);
				Logger.addTab();
				Logger.log(virologist, "generateAgent", "danceGenetic");
				virologist.generateAgent(danceGenetic);
				Logger.removeTab();
				break;
			case 2:
				DefenceGenetic defenceGenetic = new DefenceGenetic(1, 1);
				virologist.addGenetics(defenceGenetic);
				Logger.log(virologist, "generateAgent", "defenceGenetic");
				virologist.generateAgent(defenceGenetic);
				Logger.removeTab();
				break;
			case 3:
				PoisonGenetic poisonGenetic = new PoisonGenetic(1, 1);
				virologist.addGenetics(poisonGenetic);
				Logger.log(virologist, "generateAgent", "poisonGenetic");
				virologist.generateAgent(poisonGenetic);
				Logger.removeTab();
				break;
			case 4:
				AmnesiaGenetic amnesiaGenetic = new AmnesiaGenetic(1, 1);
				virologist.addGenetics(amnesiaGenetic);
				Logger.log(virologist, "generateAgent", "amnesiaGenetic");
				virologist.generateAgent(amnesiaGenetic);
				Logger.removeTab();
				break;
			case 1000:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
		}
	}

	/**
	 * Virológus felvesz egy felszerelést
	 */
	public static void virologist_picks_up_equipment() {
		Scanner console = new Scanner(System.in);

		Shelter shelter = new Shelter();
		Virologist virologist = new Virologist(0, "Virologist1", 10, shelter);

		System.out.println("Does the virologist have enough space? y/n \n");
		if(console.next().charAt(0) == 'y') {
			virologist.setMaxEquipments(1);
		}


		System.out.println("\nSelect Item type: \n");
		System.out.println("[1] "+"Virologist picks up package");
		System.out.println("[2] "+"Virologist picks up gloves");
		System.out.println("[3] "+"Virologist picks up cape");


		switch(console.nextInt()) {
			case 1:
				Package p = new Package();
				shelter.place(p);

				Logger.addTab();
				Logger.log(virologist, "loot", "shelter");
				virologist.loot(shelter);
				Logger.removeTab();
				break;
			case 2:
				Gloves g = new Gloves();
				shelter.place(g);

				Logger.addTab();
				Logger.log(virologist, "loot", "shelter");
				virologist.loot(shelter);
				Logger.removeTab();
				break;

			case 3:
				Cape cape = new Cape();
				shelter.place(cape);

				Logger.addTab();
				Logger.log(virologist, "loot", "shelter");
				virologist.loot(shelter);
				break;
			default:
				System.out.println("Invalid input");
		}
	}
	
	/**
	* Genetikai kód megtanulása
	*/
	public static void learn_genetics() {
		Laboratory Laboratory = new Laboratory();
		
		Virologist Virologist = new Virologist(1, "test", 1, Laboratory);

		System.out.println("Virologist learns Genetic");
		Scanner console = new Scanner(System.in);
	
		System.out.println("[1] Learn DanceGenetic");
		System.out.println("[2] Learn PoisonGenetic");
		System.out.println("[3] Learn DefenceGenetic");
		System.out.println("[4] Learn AmnesiaGenetic");

		switch(console.nextInt()) {
			case 1:
				DanceGenetic DanceGenetic = new DanceGenetic(1, 1);
				Laboratory.place(DanceGenetic);
				Logger.addTab();
				Logger.log(Virologist, "loot", "Laboratory");
				Virologist.loot(Laboratory);
				Logger.removeTab();
				break;
			case 2:
				PoisonGenetic PoisonGenetic = new PoisonGenetic(1, 1);
				Laboratory.place(PoisonGenetic);
				Logger.log(Virologist, "loot", "Laboratory");
				Virologist.loot(Laboratory);
				Logger.removeTab();
				break;
			case 3:
				DefenceGenetic DefenceGenetic = new DefenceGenetic(1, 1);	
				Laboratory.place(DefenceGenetic);
				Logger.log(Virologist, "loot", "Laboratory");
				Virologist.loot(Laboratory);
				Logger.removeTab();
				break;
			case 4:
				AmnesiaGenetic AmnesiaGenetic = new AmnesiaGenetic(1, 1);
				Laboratory.place(AmnesiaGenetic);
				Logger.log(Virologist, "loot", "Laboratory");
				Virologist.loot(Laboratory);
				Logger.removeTab();
				break;
			case 1000:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
		}
	}

	/**
	 * Virológus megfertőz egy másik virológust
	 */
	public static void infect_virologist() {
		Field f = new Field();
		Virologist v1 = new Virologist(1, "", 1, f);
		Virologist v2 = new Virologist(1, "", 1, f);
		f.enter(v1);
		f.enter(v2);

		Scanner console = new Scanner(System.in);
		
		System.out.println("[1] Use DanceAgent");
		System.out.println("[2] Use PoisonAgent");
		System.out.println("[3] Use DefenceAgent");
		System.out.println("[4] Use AmnesiaAgent");

		switch(console.nextInt()) {
			case 1:
				DanceAgent da = new DanceAgent();
				v1.addAgent(da);

				Logger.addTab();
				Logger.log(v1, "attack", "v2, new DanceAgent()");
				v1.attack(v2, new DanceAgent());
				Logger.removeTab();
				break;
			case 2:
				PoisonAgent pa = new PoisonAgent();
				v1.addAgent(pa);

				Logger.addTab();
				Logger.log(v1, "attack", "v2, new PoisonAgent()");
				v1.attack(v2, new PoisonAgent());
				Logger.removeTab();
				break;
			case 3:
				DefenceAgent dfa = new DefenceAgent();
				v1.addAgent(dfa);

				Logger.addTab();
				Logger.log(v1, "attack", "v2, new DefenceAgent()");
				v1.attack(v2, new DefenceAgent());
				Logger.removeTab();
				break;
			case 4:
				AmnesiaAgent aa = new AmnesiaAgent();
				v1.addAgent(aa);

				Logger.addTab();
				Logger.log(v1, "attack", "v2, new AmnesiaAgent()");
				v1.attack(v2, new AmnesiaAgent());
				Logger.removeTab();
				break;
			default:
				System.out.println("Invalid input");
		}
	}
	
	
	/**
	 * main függvény
	 */
	public static void main(String[] args) {
		logger = new Logger();

		int usecase = 0;
	    Scanner console = new Scanner(System.in);

	    while(usecase != 1000) {
	    System.out.print("\nSelect usecase by entering its code: \n");
	    printusecase();
	    usecase = console.nextInt();
		
		// Főmenü
		 
			switch (usecase) {
			case 1:
				// mezo tipusa
				switch(usecase){
					case 1:
						map_creates_fields();
						break;
					case 1000:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input");
				}
				break;
			case 2:
				System.out.println("Virologist moves to a Field: ");
				virologist_moves_to_a_field();
				break;
			case 3:
				System.out.println("Virologist produces Agent: ");
				virologist_produces_agent();
				break;
			case 4:
				System.out.println("Virologist picks up Equipment: ");
				virologist_picks_up_equipment();
				break;
			case 5:
				System.out.println("Virologist wins");
				virologist_wins();
				break;
			case 6:
				System.out.println("Timer is ticking");
				timer();
				break;
			case 7:
				System.out.println("Virologist learns genetics");
				learn_genetics();
				break;
			case 8:
				System.out.println("Virologist infects another Virologist");
				infect_virologist();
				break;
		    
				
			// Kilépés
			case 1000:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
			}
	    }
	}
}
