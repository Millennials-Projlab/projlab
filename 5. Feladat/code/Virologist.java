import java.util.ArrayList;

/**
* virologus osztaly
*/
public class Virologist {
    private ArrayList<Substances> Substances;
    private ArrayList<Agent> Agents;
    private ArrayList<Equipment> Equipments;
    private ArrayList<Genetics> Genetics;

    private int maxEquipments;
    private String name;
    private int maxAmino;
    private int maxNukleotid;

	/**
	 * virologus konstruktor
	 * mE:maxEquipments      n:name      mA:maxAmino     mN:maxNukleotid
	 */
    public Virologist(int mE,String n, int mA,int mN){
        setSubstances(new ArrayList<Substances>());
        setAgents(new ArrayList<Agent>());
        Equipments = new ArrayList<Equipment>();
        setGenetics(new ArrayList<Genetics>());
        setMaxEquipments(mE);
        name=n;
        setMaxAmino(mA);
        setMaxNukleotid(mN);
    }
    public String getName(){
        return name;
    }
    public void move(Field nf){
        //TODO
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
    public void addSubstance(Substances substance){
        //TODO
    }
    public void removeAgent(Agent agent){
        //TODO
    }
    public void removeEquipment(Equipment equipment){
        //TODO
    }
    public void removeSubstance(Substances substance){
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
        return false;
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
	public ArrayList<Substances> getSubstances() {
		return Substances;
	}
	public void setSubstances(ArrayList<Substances> substances) {
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
	public int getMaxAmino() {
		return maxAmino;
	}
	public void setMaxAmino(int maxAmino) {
		this.maxAmino = maxAmino;
	}
	public int getMaxNukleotid() {
		return maxNukleotid;
	}
	public void setMaxNukleotid(int maxNukleotid) {
		this.maxNukleotid = maxNukleotid;
	}

}
