import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
* Virológus osztály
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

    
    /** 
     * @return String
     */
    public String getName(){
        return name;
    }

    
    /** 
     * A virológus a paraméterként megadott mezőre lép
     * @param nf új mező
     */
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

    
    /** 
     * A virológus kilootolja a paraméterként megadott mezőt
     * @param field lootolni kívánt mező
     */
    public void loot(Field field){
        Logger.addTab();
        Logger.log(field, "lootItem", "this");
        field.lootItem(this);
        Logger.removeTab();
    }

    
    /** 
     * @param enemy
     */
    public void stealEquipment(Virologist enemy){
        //TODO
    }

    
    /** 
     * @param agent
     */
    public void addAgent(Agent agent){
        Agents.add(agent);
    }

    
    /** 
     * @param equipment
     */
    public void addEquipment(Equipment equipment){
        Equipments.add(equipment);
        Logger.addTab();
        Logger.log(equipment, "Effect", "this");
        equipment.Effect(this);
        Logger.removeTab();
    }

    
    /** 
     * @param substance
     */
    public void addSubstance(Substance substance){
        Substances.add(substance);
        System.out.println("Substance has been added.");
    }

    
    /** 
     * @param agent
     */
    public void removeAgent(Agent agent){
        Agents.remove(agent);
        System.out.println("Agent has been removed.");
    }

    
    /** 
     * @param equipment
     */
    public void removeEquipment(Equipment equipment){
        Equipments.remove(equipment);
        System.out.println("Equipment has been removed.");
    }
    /** 
     * @param substance
     */
    public void removeSubstance(Substance substance){
        Substances.remove(substance);
        System.out.println("Substance has been removed.");
    }

    
    /** 
     * @param genetics
     */
    public void addGenetics(Genetics genetics){
        Genetics.add(genetics);
    }
  
    public void removeAllGenetics(){
        Genetics.clear();
        System.out.println("All genetics removed");
    }
    
    /** 
     * @param genetic
     */
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

    
    /** 
     * @return ArrayList<Equipment>
     */
    public ArrayList<Equipment> getEquipments(){
        //TODO
        return Equipments;
    }    
    
    /** 
     * Ellenőrzi, hogy a virológus megtanulta-e az összes genetikai kódot
     * @return boolean igaz, ha a virológus megtanulta az összes genetikai kódot
     */
    public boolean collectedAllGenetics(){
        System.out.println("All genetics has been collected.");
        return true;
    }

    
    /** 
     * @param genetics
     * @return boolean
     */
    public boolean checkGenetics(Genetics genetics){
        System.out.println("Checked");
        return false;
    }

    
    /** 
     * @param agent
     */
    public void setNukleotid(Agent agent){
        //TODO
    	System.out.println("Number of Nukleotid has been changed.");
    }

    
    /** 
     * @param agent
     */
    public void setAmino(Agent agent){
        //TODO
    	System.out.println("Number of Amino has been changed.");
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

	
    /** 
     * @return ArrayList<Agent>
     */
    public ArrayList<Agent> getAgents() {
		return Agents;
	}

	
    /** 
     * @param agents
     */
    public void setAgents(ArrayList<Agent> agents) {
		Agents = agents;
	}

	
    /** 
     * @return ArrayList<Genetics>
     */
    public ArrayList<Genetics> getGenetics() {
		return Genetics;
	}

	
    /** 
     * @param genetics
     */
    public void setGenetics(ArrayList<Genetics> genetics) {
		Genetics = genetics;
	}

	
    /** 
     * @return int
     */
    public int getMaxEquipments() {
		return maxEquipments;
	}

	
    /** 
     * @param maxEquipments
     */
    public void setMaxEquipments(int maxEquipments) {
		this.maxEquipments = maxEquipments;
    }
	
    /** 
     * @return int
     */
    public int getMaxSubstance() {
		return maxSubstance;
    }

    
    /** 
     * Megszámolja, hogy mennyi van a paraméterként megadott anyagból
     * @param target
     * @return int
     */
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

    
    /** 
     * @return int
     */
    public int getDefenseRating() {
        return defenseRating;
    }

    
    /** 
     * @param dr
     */
    public void setDefenseRating(int dr) {
        defenseRating = dr;
    }

    
    /** 
     * A virolügus megtámadja a paraméterként megadott virológust a paraméterként megadott tipusú ágenssel
     * @param target
     * @param agent
     */
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

    
    /** 
     * @param flag
     */
    public void setEffectFlag(int flag) {
        effectFlag = flag;
    }
}
