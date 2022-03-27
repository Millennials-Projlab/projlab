import java.util.ArrayList;
import java.util.Scanner;

//Skeleton osztaly
public class Skeleton {	
	//usecase-ek menu kiirasa, mindig ha egy ujat csinalsz akk add hozza itt is a kiirashoz
	public static void printusecase() {
        System.out.println("[1] "+"Map creates Fields");
        System.out.println("[2] "+"Usecase neve");
        System.out.println("[3] "+"Usecase neve");
        System.out.println("[4] "+"Usecase neve");
        System.out.println("[5] "+"Usecase neve");
        System.out.println("[6] "+"Usecase neve");
        System.out.println("[7] "+"Usecase neve");
        //Igy tovabb usecase szama+neve
	}
	
	//usecase fuggvenyek ide
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
		}
		for(int i=0;i<amino;i++){
			substances.add(new Amino());
		}
		warehouse.SetNeighbour(NextField);
		NextField.SetNeighbour(warehouse);
		warehouse.Place(substances);
	}

	public static void map_creates_field() {
		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Field Field = new Field();
		Field NextField = new Field();
		Field.SetNeighbour(NextField);
		NextField.SetNeighbour(Field);
	}
	public static void virologist_moves_to_a_field(){

		Scanner scanner=new Scanner(System.in);
		
		System.out.print("Maximum Equipment: ");

		System.out.print("Name: ");

		System.out.print("Maximum Amino: ");

		System.out.print("Maximum Nukleotid: ");

		System.out.println();

		Game Game = new Game();
		Map Map = new Map();
		Map.CreateMap(0, 0, 0, 0);
		Field Field = new Field();
		Field NextField = new Field();
	}
	
	
	
	
	
	//main fuggveny
	public static void main(String[] args) {
		//usecase switch
		//menupontok
		int usecase = 0;

	    //scan-eleshez
	    Scanner console = new Scanner(System.in);

	    while(usecase != 1000) {
	    //melyik usecase
	    System.out.print("\nSelect usecase by entering its code: \n");
	    printusecase();
	    usecase = console.nextInt();
		
			//fomenu
			switch (usecase) {
			case 1:
				System.out.println("\nSelect Field type by entering its code: \n");
				System.out.println("[1] "+"Map creates Shelter");
      			System.out.println("[2] "+"Map creates Laboratory");
        		System.out.println("[3] "+"Map creates Warehouse");
				System.out.println("[4] "+"Map creates Field");
				usecase=console.nextInt();
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
				//fuggveny
				break;
			case 3:
				System.out.println("usecase neve3");
				//fuggveny
				break;
			case 4:
				System.out.println("usecase neve4");
				//fuggveny
				break;
			case 5:
				System.out.println("usecase neve5");
				//fuggveny
				break;
			case 6:
				System.out.println("usecase neve6");
				//fuggveny;
				break;
			case 7:
				System.out.println("use-case neve7");
				//fuggveny
				break;
		    
				//igy tovabb minden egyes use-case-nek
				
			//kilepes
			case 1000:
				System.exit(0);
				break;
			//default
			default:
				System.out.println("Invalid input");
			}
	    }
	}
}
