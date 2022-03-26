import java.util.Scanner;

//Skeleton osztaly
public class Skeleton {	
	//usecase-ek menu kiirasa, mindig ha egy ujat csinalsz akk add hozza itt is a kiirashoz
	public static void printusecase() {
        System.out.println(1+" "+"Map creates Shelter");
        System.out.println(2+" "+"Usecase neve");
        System.out.println(3+" "+"Usecase neve");
        System.out.println(4+" "+"Usecase neve");
        System.out.println(5+" "+"Usecase neve");
        System.out.println(6+" "+"Usecase neve");
        System.out.println(7+" "+"Usecase neve");
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
	
	
	
	
	
	
	//main fuggveny
	public static void main(String[] args) {
		//usecase switch
		//menupontok
		int usecase = 0;

	    //scan-eleshez
	    Scanner console = new Scanner(System.in);

	    while(usecase != 1000) {
	    //melyik usecase
	    System.out.print("Select usecase by entering its code: \n");
	    printusecase();
	    usecase = console.nextInt();
		
			//fomenu
			switch (usecase) {
			case 1:
				System.out.println("Map creates Shelter: \n");
				map_creates_shelter();
				break;
			case 2:
				System.out.println("usecase neve2");
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
