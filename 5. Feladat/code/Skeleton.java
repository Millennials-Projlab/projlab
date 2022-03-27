import java.util.ArrayList;
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
        System.out.println("[4] "+"Usecase neve");
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
			Field.setNeighbour(NextField);
			NextField.setNeighbour(Field);
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
						System.out.println("Map creates Shelter: \n");
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
				System.out.println("Virologist moves to a Field: \n");
				virologist_moves_to_a_field();
				break;
			case 3:
				System.out.println("Virologist produces Agent: ");
				virologist_produce_agent();
				break;
			case 4:
				System.out.println("usecase neve4");
				//fuggveny
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
