import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Skeleton osztaly
 */
public class Skeleton {
	public static Logger logger;
	/**
	 * usecase-ek menu kiirasa, mindig ha egy ujat csinalsz akk add hozza itt is a kiirashoz
	 */
	public static void printusecase() {
        System.out.println("[1] "+"Map creates Fields");
        System.out.println("[2] "+"Virologist moves to a Field");
        System.out.println("[3] "+"Virologist produces Agent");
        System.out.println("[4] "+"Virologist picks up equipment");
        System.out.println("[5] "+"Virologist wins");
        System.out.println("[6] "+"Timer is ticking");
        System.out.println("[7] "+"Game Starts");
        //Igy tovabb usecase szama+neve
	}
	
	/**
	 * usecase fuggvenyek ide
	 */
	
	/**
	 * Mezők létrehozása
	 */
	public static void map_creates_fields() {
		Game Game = new Game();
		Game.Start();
	}
	
	/**
	 * virologus mozgasa
	 */
	public static void virologist_moves_to_a_field(){
		Scanner scanner = new Scanner(System.in);

		boolean areNeighbours = false;
		System.out.print("Are Field and NextField neighbours? y/n: ");
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
	 * jatek elindul
	 */
	public static void game_starts() {
		Game Game = new Game();
		Map Map = new Map();
		int fn = 0;
		int h = 0;
		int s = 0;
		int l = 0;
		Game.Start();
		Map.CreateMap(fn, s, h, l);
	}
	
	/**
	 * telik az ido
	 */
	public static void timer() {
		Game Game = new Game();
		Timer Timer = new Timer();
		Game.Start();
		Timer.Start();
		while (Timer.isTimer()) {
			Timer.Tick();
			Timer.setTimer(false);
		}
		Timer.Stop();
	}
	
	/**
	 * virologus nyer
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
	

	public static void virologist_produces_agent() {
		Scanner console = new Scanner(System.in);

		Field field = new Field();
		Virologist virologist = new Virologist(1, "", 0, field);


		System.out.println("Does the virologist have enough substances? y/n");
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

	public static void virologist_picks_up_equipment() {
		Scanner console = new Scanner(System.in);

		Shelter shelter = new Shelter();
		Virologist virologist = new Virologist(0, "Virologist1", 10, shelter);

		System.out.println("Does the virologist have enough space? y/n");
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
	 * main fuggveny
	 */
	public static void main(String[] args) {
		logger = new Logger();
		/**
		 * usecase switch
		 * menupontok
		 */
		int usecase = 0;
		/**
		 * beolvasas
		 */
	    Scanner console = new Scanner(System.in);

	    while(usecase != 1000) {
	    /**
	     * melyik usecase
	     */
	    System.out.print("\nSelect usecase by entering its code: \n");
	    printusecase();
	    usecase = console.nextInt();
		
		/**
		 * fomenu
		 */
			switch (usecase) {
			case 1:
				System.out.println("\nSelect Field type by entering its code: \n");
				System.out.println("[1] "+"Map creates Shelter");
      			System.out.println("[2] "+"Map creates Laboratory");
        		System.out.println("[3] "+"Map creates Warehouse");
				System.out.println("[4] "+"Map creates Field");
				usecase=console.nextInt();
				/**
				 * mezo tipusa
				 */
				switch(usecase){
					case 1:
						System.out.println("Map creates Shelter: ");
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
				System.out.println("Game Starts");
				game_starts();
				break;
		    
				//igy tovabb minden egyes use-case-nek
				
			/**
			* kilepes
			*/
			case 1000:
				System.exit(0);
				break;
			/**
			* default ertek
			*/
			default:
				System.out.println("Invalid input");
			}
	    }
	}
}
