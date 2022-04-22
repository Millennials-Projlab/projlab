import java.util.ArrayList;
/**
* Warehouse osztály
*/
public class Warehouse extends Field{
	private ArrayList<Substance> substances;
	
	public Warehouse(String name) {
		super(name);
		substances = new ArrayList<Substance>();
	}

	/** 
	 * Elhelyezi a genetikai kódot a mezőn
	 * @param Substances
	 */
	public void place(ArrayList<Substance> Substances) {
        for(Substance i: Substances){
            System.out.println("\t"+i.toString()+" "+"has been placed");
			substances.add(i);
        }
	}
	
	public void Clear() {
		System.out.println("Cleared");
	}
	
	/** 
	 * @return ArrayList<Substance>
	 */
	public ArrayList<Substance> getSubstances() {
		return substances;
	}

	
	/** 
	 * @param substances
	 */
	public void setSubstances(ArrayList<Substance> substances) {
		substances = substances;
	}   
}