import java.util.Scanner;

//Skeleton osztaly
public class Skeleton {	
	//usecase-ek menu kiirasa, mindig ha egy ujat csinalsz akk add hozza itt is a kiirashoz
	public static void printusecase() {
        System.out.println(1+"Usecase neve");
        System.out.println(2+"Usecase neve");
        System.out.println(3+"Usecase neve");
        System.out.println(4+"Usecase neve");
        System.out.println(5+"Usecase neve");
        System.out.println(6+"Usecase neve");
        System.out.println(7+"Usecase neve");
        //Igy tovabb usecase szama+neve
	}
	
	//usecase fuggvenyek ide
	
	
	
	
	
	
	//main fuggveny
	public static void main(String[] args) {
		//usecase switch
		//menupontok
		int usecase = 0;

	    //scan-eleshez
	    Scanner console = new Scanner(System.in);

	    while(usecase != 1000) {
	    //melyik usecase
	    System.out.print("Select use case by entering its code: \n");
	    printusecase();
	    usecase = console.nextInt();
		
			//fomenu
			switch (usecase) {
			case 1:
				System.out.println("use-case neve1");
				//fuggveny
				break;
			case 2:
				System.out.println("use-case neve2");
				//fuggveny
				break;
			case 3:
				System.out.println("use-case neve3");
				//fuggveny
				break;
			case 4:
				System.out.println("use-case neve4");
				//fuggveny
				break;
			case 5:
				System.out.println("use-case neve5");
				//fuggveny
				break;
			case 6:
				System.out.println("use-case neve6");
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
