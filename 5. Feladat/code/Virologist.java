import java.util.ArrayList;
import java.util.Arrays;

/**
* virologus osztaly
*/
public class Virologist {
    private ArrayList<Substance> Substances;
    private ArrayList<Agent> Agents;
    private ArrayList<Equipment> Equipments;
    private ArrayList<Genetics> Genetics;

    private int maxEquipments;
    private String name;
    private int maxSubstance;
    private Field currentField;

	/**
	 * virologus konstruktor
	 * mE:maxEquipments      n:name      mA:maxAmino     mN:maxNukleotid
	 */
    public Virologist(int mE, String n, int mS, Field cF){
        Substances = new ArrayList<Substance>();
        Agents = new ArrayList<Agent>();
        Equipments = new ArrayList<Equipment>();
        Genetics = new ArrayList<Genetics>();
        maxEquipments = mE;
        name = n;
        maxSubstance = mS;
        currentField = cF;
    }
    public String getName(){
        return name;
    }
    public void move(Field nf){
        ArrayList<Field> FieldNeighbours = currentField.getNeighbours();
		if(FieldNeighbours.contains(nf)) {
            Logger.addTab();
            Logger.log(currentField, "leave", Arrays.asList("this"));
            currentField.leave(this);
            Logger.removeTab();

            Logger.addTab();
            Logger.log(nf, "enter", Arrays.asList("this"));
            nf.enter(this);
            Logger.removeTab();
		}
    }
    public void loot(Field field){
        //TODO
    }
    public void stealEquipment(Virologist enemy){
        //TODO
    }
    public void use(Agent agent, Virologist enemy){
        //TODO
    }
    public void addAgent(Agent agent){
        //TODO
    }
    public void addEquipment(Equipment equipment){
        //TODO
    }
    public void addSubstance(Substance substance){
        //TODO
    }
    public void removeAgent(Agent agent){
        //TODO
    }
    public void removeEquipment(Equipment equipment){
        //TODO
    }
    public void removeSubstance(Substance substance){
        //TODO
    }
    public void addGenetics(Genetics genetics){
        //TODO
    }
    public void removeAllGenetics(){
        //TODO
    }
    public void generateAgent(Agent agent){
        //TODO
    }
    public ArrayList<Equipment> getEquipments(){
        //TODO
        return Equipments;
    }
    public void applyGenetic(Genetics genetic){
        //TODO
    }
    public boolean collectedAllGenetics(){
        //TODO
        return true;
    }
    public boolean checkGenetics(Genetics genetics){
        //TODO
        return false;
    }
    public void setNukleotid(Agent agent){
        //TODO
    }
    public void setAmino(Agent agent){
        //TODO
    }
	public ArrayList<Substance> getSubstances() {
		return Substances;
	}
	public void setSubstances(ArrayList<Substance> substances) {
		Substances = substances;
	}
	public ArrayList<Agent> getAgents() {
		return Agents;
	}
	public void setAgents(ArrayList<Agent> agents) {
		Agents = agents;
	}
	public ArrayList<Genetics> getGenetics() {
		return Genetics;
	}
	public void setGenetics(ArrayList<Genetics> genetics) {
		Genetics = genetics;
	}
	public int getMaxEquipments() {
		return maxEquipments;
	}
	public void setMaxEquipments(int maxEquipments) {
		this.maxEquipments = maxEquipments;
	}
	public int getMaxSubstance() {
		return maxSubstance;
    }
}
