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
    private boolean poisoned;

	/**
	 * virologus konstruktor
     * @param name virológus neve
     * @param maxEquipments egyszerre birtokolható felszerelések száma
     * @param maxSubstance maximális anyagok száma
     * @param currentField a mező, amelyre a virológus létrehozás után kerül
	 */
    public Virologist(String name, int maxEquipments, int maxSubstance, Field currentField){
        Substances = new ArrayList<Substance>();
        Agents = new ArrayList<Agent>();
        Equipments = new ArrayList<Equipment>();
        Genetics = new ArrayList<Genetics>();
        this.name = name;
        this.maxEquipments = maxEquipments;
        this.maxSubstance = maxSubstance;
        this.currentField = currentField;
        setPoisoned(false);
    }

    
    /** 
     * @return String
     */
    public String getName(){
        return name;
    }
    
    public Field getcurrentfield() {
    	return currentField;
    }
    
    public void setcurrentfield(Field f) {
    	currentField = f;
    }

    
    /** 
     * A virológus a paraméterként megadott mezőre lép
     * @param nf új mező
     */
    public void move(Field nf){
        ArrayList<Field> FieldNeighbours = currentField.getNeighbours();
		if(FieldNeighbours.contains(nf)) {
            currentField.leave(this);

            nf.enter(this);
		}
    }

    
    /** 
     * A virológus kilootolja a mezőt, amin áll
     */
    public void loot(){
        currentField.lootItem(this);
    }


    /** 
     * @param enemy
     */
    public void stealEquipment(Virologist enemy){
    	this.addEquipment(enemy.getEquipments().get(0));
    	enemy.getEquipments().remove(0);
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

        equipment.Effect(this);
    }

    
    /** 
     * @param substance
     */
    public void addSubstance(Substance substance){
        Substances.add(substance);
    }

    
    /** 
     * @param agent
     */
    public void removeAgent(Agent agent){
        Agents.remove(agent);
    }

    
    /** 
     * @param equipment
     */
    public void removeEquipment(Equipment equipment){
        Equipments.remove(equipment);
    }
    /** 
     * @param substance
     */
    public void removeSubstance(Substance substance){
        Substances.remove(substance);
    }

    /** 
     * @param genetics
     */
    public void addGenetics(Genetics genetics){
        Genetics.add(genetics);
    }
  
    public void removeAllGenetics(){
        Genetics.clear();
    }
    
    /** 
     * @param genetic
     */
    public void generateAgent(Genetics genetic){
        for(Genetics g : Genetics) {
            if(g.isSame(genetic)) {
                HashMap<Substance, Integer> recipe = g.getRecipe();
                for(Substance key : recipe.keySet()) {
                    if(countSubstance(key) < 1) {
                        return;
                    } 
                }

                Agent agent = g.generate();

                addAgent(agent);

                break;
            }
        }
    }

    
    /** 
     * @return ArrayList<Equipment>
     */
    public ArrayList<Equipment> getEquipments(){
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
     * @param genetic
     * @return boolean
     */
    public boolean checkGenetics(Genetics genetic) {
    	for(Genetics g : Genetics) {
            if(g.isSame(genetic)) {
            	return false;
            }
    	}
         return true;
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
            if(substance.isSame(target))
                substanceCount++;
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
            if(a.isSame(agent)) {
                a.infect(target);
                return;
            }
        }
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


	public boolean isPoisoned() {
		return poisoned;
	}


	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}
}