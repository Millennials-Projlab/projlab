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
    private boolean paralyzed = false;

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
        System.out.println("Virologist has moved");
    }
    public void loot(Field field){
        System.out.println("Virologist has looted");
        //TODO
    }
    public void stealEquipment(Virologist enemy){
        //TODO
    }
    public void use(Agent agent, Virologist enemy){
        //TODO
    }
    public void addAgent(Agent agent){
        Agents.add(agent);
        System.out.println(agent.toString()+ " Agent has been added.");
    }
    public void addEquipment(Equipment equipment){
        Equipments.add(equipment);
        System.out.println("Equipment has been added.");
    }
    public void addSubstance(Substances substance){
        Substances.add(substance);
        System.out.println("Substance has been added.");
    }
    public void removeAgent(Agent agent){
        Agents.remove(agent);
        System.out.println("Agent has been removed.");
    }
    public void removeEquipment(Equipment equipment){
        Equipments.remove(equipment);
        System.out.println("Equipment has been removed.");
    }
    public void removeSubstance(Substances substance){
        Substances.remove(substance);
        System.out.println("Substance has been removed.");
    }
    public void addGenetics(Genetics genetics){
        System.out.println(genetics.toString()+" "+"has been learnt");
    }
    public void removeAllGenetics(){
        Genetics.clear();
        System.out.println("All genetics removed");
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
        System.out.println("All genetics has been collected.");
        return true;
    }
    public boolean checkGenetics(Genetics genetics){
        System.out.println("Checked");
        return false;
    }
    public void setNukleotid(Agent agent){
        //TODO
    	System.out.println("Number of Nukleotid has been changed.");
    }
    public void setAmino(Agent agent){
        //TODO
    	System.out.println("Number of Amino has been changed.");
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
	public boolean isParalyzed() {
		return paralyzed;
	}
	public void setParalyzed(boolean paralyzed) {
		this.paralyzed = paralyzed;
	}

}
