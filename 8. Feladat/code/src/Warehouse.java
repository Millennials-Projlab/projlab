import java.util.ArrayList;
import java.util.Iterator;
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
		this.substances = substances;
	}   

	/** 
     * Megszámolja, hogy mennyi van a paraméterként megadott anyagból
     * @param target
     * @return int
     */
    public int countSubstance(Substance target) {
        int substanceCount = 0;
        for(Substance substance : substances) {
            if(substance.isSame(target))
                substanceCount++;
        }
        return substanceCount;
    }

	
	/** 
	 * @return String
	 */
	public String toString() {
		String returnString = super.toString();
		returnString += "\nAmino: " + countSubstance(new Amino()) + "\n";
		returnString += "Nukleotid: " + countSubstance(new Nukleotid());

		return returnString;
	}

	
	/** 
	 * @param virologist
	 */
	public void lootItem(Virologist virologist) {
		Iterator<Substance> iter = substances.iterator();
		while(iter.hasNext()) {
			Substance substance = iter.next();
			try {
				substance.pickUp(virologist);
				iter.remove();
			} catch(MaximumSubstanceException e) {
				return;
			}
		}
	}

	public void clear() {
		substances.clear();
	}
}
