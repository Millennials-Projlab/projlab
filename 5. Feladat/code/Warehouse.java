import java.util.ArrayList;
/**
* Warehouse osztály
*/
public class Warehouse extends Field{
	private ArrayList<Substance> Substances;
	
	
	/** 
	 * Elhelyezi a genetikai kódot a mezőn
	 * @param Substances
	 */
	public void place(ArrayList<Substance> Substances) {
        for(Substance i: Substances){
            System.out.println("\t"+i.toString()+" "+"has been placed");
        }
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}
	
	/** 
	 * @return ArrayList<Substance>
	 */
	public ArrayList<Substance> getSubstances() {
		return Substances;
	}

	
	/** 
	 * @param substances
	 */
	public void setSubstances(ArrayList<Substance> substances) {
		Substances = substances;
	}   
}
