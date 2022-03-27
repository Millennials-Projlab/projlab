import java.util.ArrayList;
import java.util.Scanner;

/**
 * Skeleton osztaly
 */
public class Skeleton {
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
        System.out.println("[8] "+"Learn Genetics");
        //Igy tovabb usecase szama+neve
	}
	
	/**
	 * usecase fuggvenyek ide
	 */
	
	/**
	 * shelter letrehozasa
	 */
	public static void map_creates_shelter() {
		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Shelter Shelter = new Shelter();
		Field NextField = new Field();
		Package Package = new Package();
		Shelter.SetNeighbour(NextField);
		NextField.SetNeighbour(Shelter);
		Shelter.Place(Package);
	}
	
	/**
	 * laboratory letrehozasa
	 */
	public static void map_creates_laboratory() {
		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Laboratory Laboratory =new Laboratory();
		Field NextField = new Field();
		DanceGenetic danceGenetic=new DanceGenetic();
		Laboratory.SetNeighbour(NextField);
		NextField.SetNeighbour(Laboratory);
		Laboratory.Place(danceGenetic);
	}
	
	/**
	 * warehouse letrehozasa
	 */
	public static void map_creates_warehouse() {
		Scanner scanner=new Scanner(System.in);
		int nukleotid=0;
		int amino=0;
		
		System.out.print("How many Nukleotid? ");
		nukleotid=scanner.nextInt();
		System.out.print("How many Amino? ");
		amino=scanner.nextInt();
		System.out.println();
		
		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Warehouse warehouse=new Warehouse();
		Field NextField = new Field();
		ArrayList<Substances> substances=new ArrayList<>();
		
		for(int i=0;i<nukleotid;i++){
			substances.add(new Nukleotid());
			System.out.println("Add nukleotid");
		}
		for(int i=0;i<amino;i++){
			substances.add(new Amino());
			System.out.println("Add amino");
		}
		
		warehouse.SetNeighbour(NextField);
		NextField.SetNeighbour(warehouse);
		warehouse.Place(substances);
	}

	/**
	 * field letrehozasa
	 */
	public static void map_creates_field() {
		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Field Field = new Field();
		Field NextField = new Field();
		Field.SetNeighbour(NextField);
		NextField.SetNeighbour(Field);
	}
	
	/**
	 * virologus mozgasa
	 */
	public static void virologist_moves_to_a_field(){
		Scanner scanner=new Scanner(System.in);
		String name="";
		int maxEquipments=0;
		int maxAmino=0;
		int maxNukleotid=0;
		boolean areNeighbours=true;

		System.out.print("Maximum Equipment: ");
		maxEquipments=scanner.nextInt();
		System.out.print("Name: ");
		name=scanner.next();
		System.out.print("Maximum Amino: ");
		maxAmino=scanner.nextInt();
		System.out.print("Maximum Nukleotid: ");
		maxNukleotid=scanner.nextInt();
		System.out.print("Are Field and NextField neighbours? y/n: ");
		if(scanner.next().charAt(0)=='y')
			areNeighbours=true;
		else
			areNeighbours=false;
		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Field Field = new Field();
		Field NextField = new Field();
		if(areNeighbours){
			Field.SetNeighbour(NextField);
			NextField.SetNeighbour(Field);
		}
		Virologist virologist=new Virologist(maxEquipments,name,maxAmino,maxNukleotid);
		virologist.move(NextField);
		ArrayList<Field> FieldNeighbours=Field.getNeighbours();
		if(FieldNeighbours.contains(NextField)){
			Field.Leave(virologist);
			NextField.Enter(virologist);
		}

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
		Virologist Virologist = new Virologist(1, "test", 1, 1);
		Game Game = new Game();
		if (Virologist.collectedAllGenetics() == true) {
			Game.End();
		}
	}
	

	public static void virologist_produce_agent() {
		System.out.println("Produce Agent");
		Scanner console = new Scanner(System.in);
		int a = 0;

		Game game = new Game();
		game.getPlayers();
		System.out.println("[1] Produce Dance Agent");
		System.out.println("[2] Produce Defence Agent");
		System.out.println("[3] Produce Poison Agent");
		System.out.println("[4] Produce Amnesia Agent");
		a = console.nextInt();
		switch(a) {
			case 1:
				DanceAgent danceAgent = new DanceAgent();
				danceAgent.Generate();
				break;
			case 2:
				DefenceAgent defenceAgent = new DefenceAgent();
				defenceAgent.Generate();
				break;
			case 3:
				PoisonAgent poisonAgent = new PoisonAgent();
				poisonAgent.Generate();
				break;
			case 4:
				AmnesiaAgent amnesiaAgent = new AmnesiaAgent();
				amnesiaAgent.Generate();
				break;
			case 1000:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
		}
	}
	
	public static void virologist_picks_up_package() {
		Shelter shelter = new Shelter();
		Package p = new Package();
		shelter.Place(p);
		Virologist v = new Virologist(3, "Virologist1", 10, 10);
		v.loot(shelter);
		Equipment eq = shelter.getEquipment();
		eq.PickUp();
		v.addEquipment(eq);
		shelter.Clear();
	}

	public static void virologist_picks_up_gloves() {
		Shelter shelter = new Shelter();
		Gloves g = new Gloves();
		shelter.Place(g);
		Virologist v = new Virologist(3, "Virologist1", 10, 10);
		v.loot(shelter);
		Equipment eq = shelter.getEquipment();
		eq.PickUp();
		v.addEquipment(eq);
		shelter.Clear();
	}

	public static void virologist_picks_up_cape() {
		Shelter shelter = new Shelter();
		Cape cape = new Cape();
		shelter.Place(cape);
		Virologist v = new Virologist(3, "Virologist1", 10, 10);
		v.loot(shelter);
		Equipment eq = shelter.getEquipment();
		eq.PickUp();
		v.addEquipment(eq);
		shelter.Clear();
	}
	
	/**
	* genetikai kod megtanulasa
	*/
	public static void learn_genetics() {
		Virologist Virologist = new Virologist(1, "test", 1, 1);
		Laboratory Laboratory = new Laboratory();
		DanceGenetic DanceGenetic = new DanceGenetic();
		PoisonGenetic PoisonGenetic = new PoisonGenetic();
		DefenceGenetic DefenceGenetic = new DefenceGenetic();
		AmnesiaGenetic AmnesiaGenetic = new AmnesiaGenetic();
		
		System.out.println("Learn Genetic");
		Scanner console = new Scanner(System.in);
		int a = 0;

		Game game = new Game();
		game.getPlayers();
		
		Virologist.loot(Laboratory);
		Laboratory.getGenetic();
		System.out.println("[1] Learn DanceGenetic");
		System.out.println("[2] Learn PoisonGenetic");
		System.out.println("[3] Learn DefenceGenetic");
		System.out.println("[4] Learn AmnesiaGenetic");
		a = console.nextInt();
		switch(a) {
			case 1:
				if (Virologist.checkGenetics(DanceGenetic)==false && Virologist.isParalyzed() == false) {
					Virologist.addGenetics(DanceGenetic);
				}
				break;
			case 2:
				if (Virologist.checkGenetics(PoisonGenetic)==false && Virologist.isParalyzed() == false) {
					Virologist.addGenetics(PoisonGenetic);
				};
				break;
			case 3:
				if (Virologist.checkGenetics(DefenceGenetic)==false && Virologist.isParalyzed() == false) {
					Virologist.addGenetics(DefenceGenetic);
				}
				break;
			case 4:
				if (Virologist.checkGenetics(AmnesiaGenetic)==false && Virologist.isParalyzed() == false) {
					Virologist.addGenetics(AmnesiaGenetic);
				}
				break;
			case 1000:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
		}
		
		
	}
	
	
	/**
	 * main fuggveny
	 */
	public static void main(String[] args) {
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
						System.out.println("Map creates Shelter: \n");
						map_creates_shelter();
						break;
					case 2:
						System.out.println("Map creates Laboratory: \n");
						map_creates_laboratory();
						break;
					case 3:
						System.out.println("Map creates Warehouse: \n");
						map_creates_warehouse();
						break;
					case 4:
						System.out.println("Map creates Field: \n");
						map_creates_field();
						break;
					case 1000:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input");
				}
				break;
			case 2:
				System.out.println("Virologist moves to a Field: \n");
				virologist_moves_to_a_field();
				break;
			case 3:
				System.out.println("Virologist produces Agent: ");
				virologist_produce_agent();
				break;
			case 4:
				System.out.println("\nSelect Item type: \n");
				System.out.println("[1] "+"Virologist picks up package");
      			System.out.println("[2] "+"Virologist picks up gloves");
        		System.out.println("[3] "+"Virologist picks up cape");
				usecase = console.nextInt();
				switch(usecase){
					case 1: 
						virologist_picks_up_package();
						break;
					case 2:
						virologist_picks_up_gloves();
						break;
					case 3:
						virologist_picks_up_cape();
						break;
					case 0:
						System.exit(0);
					default: 
						System.out.println("Invalid input.");	
				}
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
			case 8:
				System.out.println("Learn Genetics");
				learn_genetics();
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
