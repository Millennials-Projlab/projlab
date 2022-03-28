import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
    private int defenseRating;
    private int effectFlag;

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
        Logger.addTab();
        Logger.log(field, "lootItem", "this");
        field.lootItem(this);
        Logger.removeTab();
    }

    public void stealEquipment(Virologist enemy){
        //TODO
    }

    public void use(Agent agent, Virologist enemy){
        //TODO
    }

    public void addAgent(Agent agent){
        Agents.add(agent);
    }

    public void addEquipment(Equipment equipment){
        Equipments.add(equipment);

        Logger.addTab();
        Logger.log(equipment, "Effect", "this");
        equipment.Effect(this);
        Logger.removeTab();
    }

    public void addSubstance(Substance substance){
        Substances.add(substance);
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
        Genetics.add(genetics);
    }

    public void removeAllGenetics(){
        //TODO
    }

    public void generateAgent(Genetics genetic){
        for(Genetics g : Genetics) {
            Logger.addTab();
            Logger.log(g, "isSame", "genetic");
            Logger.removeTab();
            if(g.isSame(genetic)) {
                Logger.addTab();
                Logger.log(g, "getRecipe", "");
                Logger.removeTab();
                HashMap<Substance, Integer> recipe = g.getRecipe();
                Logger.addTab();
                for(Substance key : recipe.keySet()) {
                    Logger.log(this, "countSubstance", "key");
                    if(countSubstance(key) < 1) {
                        return;
                    } 
                }
                Logger.removeTab();
                
                Logger.addTab();
                Logger.log(g, "generate", "");
                Agent agent = g.generate();
                Logger.removeTab();

                Logger.addTab();
                Logger.log(this, "addAgent", "agent");
                addAgent(agent);
                Logger.removeTab();

                break;
            }
        }
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

    public int countSubstance(Substance target) {
        int substanceCount = 0;
        for(Substance substance : Substances) {
            Logger.addTab();
            Logger.log(substance, "isSame", "target");
            if(substance.isSame(target))
                substanceCount++;
            Logger.removeTab();
        }
        return substanceCount;
    }

    public void setEquipmentflag(int flag) {}

    public int getDefenseRating() {
        return defenseRating;
    }

    public void setDefenseRating(int dr) {
        defenseRating = dr;
    }

    public void attack(Virologist target, Agent agent) {
        for(Agent a : Agents) {
            Logger.addTab();
            Logger.log(a, "isSame", "agent");
            if(a.isSame(agent)) {
                Logger.addTab();
                Logger.log(a, "infect", "target");
                a.infect(target);
                Logger.removeTab();
                Logger.removeTab();
                return;
            }
        }
        Logger.removeTab();
    }

    public void clearCollectedGenetics() {
        Genetics.clear();
    }

    public void dance() {
        // TODO
    }

    public void setEffectFlag(int flag) {
        effectFlag = flag;
    }
}
