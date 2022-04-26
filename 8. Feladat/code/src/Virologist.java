import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
* Virológus osztály
*/
public class Virologist {
    private ArrayList<Substance> substances;
    private ArrayList<Agent> agents;
    private ArrayList<Equipment> equipments;
    private ArrayList<Genetics> genetics;

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
        substances = new ArrayList<Substance>();
        agents = new ArrayList<Agent>();
        equipments = new ArrayList<Equipment>();
        genetics = new ArrayList<Genetics>();
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

    
    public void produceAgent(String[] args) throws IncorrectParameterException{
    	Agent agent;
    	Random rand = new Random();
		int liveTime = rand.nextInt(100);
    	
    	switch(args[0]) {
    		case "Amnesia":
    			agent = new AmnesiaAgent(agent.getGenetic(), liveTime);
    			this.addAgent(agent);
    			break;
    			
    		case "DanceAgent":
    			agent = new DanceAgent(agent.getGenetic(), liveTime);
    			this.addAgent(agent);
    			break;
    			
    		case "DefenceAgent":
    			agent = new DefenceAgent(agent.getGenetic(), liveTime);
    			this.addAgent(agent);
    			break;
    			
    		case "PoisonAgent":
    			agent = new PoisonAgent(agent.getGenetic(), liveTime);
    			this.addAgent(agent);
    			break;
    			
    		default:
    			break;
    	}
    }
    
    
    public boolean checkIfEnoughGenetics(Agent agent) {
    	Genetics requiredGenetic = agent.getGenetic();
    	//???v�gigmegy a genetik�kon �s ha isSame, akkor return false?
    	return checkGenetics(requiredGenetic);
    	
    }
    
    /** 
     * A virológus a paraméterként megadott mezőre lép
     * @param nf új mező
     */
    public void move(Field nextField) throws IncorrectParameterException {
        if(nextField == null) {
            throw new IncorrectParameterException("Field does not exist.");
        }
        
        if(nextField.equals(currentField)) {
            System.out.println("Virologist is already on that field.");
            return;
        }
        
        ArrayList<Field> FieldNeighbours = currentField.getNeighbours();
		if(FieldNeighbours.contains(nextField)) {
            currentField.leave(this);
            nextField.enter(this);
            currentField = nextField;
            return;
		}
        System.out.println(nextField.getName() + " is not a neighbor of " + currentField.getName());
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
        agents.add(agent);
    }

    
    /** 
     * @param equipment
     */
    public void addEquipment(Equipment equipment){
        equipments.add(equipment);

        equipment.Effect(this);
    }

    
    /** 
     * @param substance
     */
    public void addSubstance(Substance substance){
        substances.add(substance);
    }

    
    /** 
     * @param agent
     */
    public void removeAgent(Agent agent){
        agents.remove(agent);
    }

    
    /** 
     * @param equipment
     */
    public void removeEquipment(Equipment equipment){
        equipments.remove(equipment);
    }
    /** 
     * @param substance
     */
    public void removeSubstance(Substance substance){
        substances.remove(substance);
    }

    /** 
     * @param genetics
     */
    public void addGenetics(Genetics genetics){
        this.genetics.add(genetics);
    }
  
    public void removeAllGenetics(){
        genetics.clear();
    }
    
    /** 
     * @param genetic
     */
    public void generateAgent(Genetics genetic){
        for(Genetics g : genetics) {
            if(g.isSame(genetic)) {
                HashMap<Substance, Integer> recipe = g.getRecipe();
                for(Substance key : recipe.keySet()) {
                    if(countSubstance(key) < 1) {
                        return;
                    } 
                }

                Agent agent = g.generate(this);

                addAgent(agent);

                break;
            }
        }
    }

    
    /** 
     * @return ArrayList<Equipment>
     */
    public ArrayList<Equipment> getEquipments(){
        return equipments;
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
    	for(Genetics g : genetics) {
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
    	for (int i = 0; i < agent.getGenetic().recipe.get(new Nukleotid()); i++) {
    		this.Substances.remove(new Nukleotid());
    	}
    	System.out.println("Number of Nukleotid has been changed.");
    }

    /** 
     * @param agent
     */
    public void setAmino(Agent agent){
        //TODO
    	for (int i = 0; i < agent.getGenetic().recipe.get(new Amino()); i++) {
    		this.Substances.remove(new Amino());
    	}
    	System.out.println("Number of Amino has been changed.");
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
     * @return ArrayList<Agent>
     */
    public ArrayList<Agent> getAgents() {
		return agents;
	}

	
    /** 
     * @param agents
     */
    public void setAgents(ArrayList<Agent> agents) {
		this.agents = agents;
	}

	
    /** 
     * @return ArrayList<Genetics>
     */
    public ArrayList<Genetics> getGenetics() {
		return genetics;
	}

	
    /** 
     * @param genetics
     */
    public void setGenetics(ArrayList<Genetics> genetics) {
		this.genetics = genetics;
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
        for(Substance substance : substances) {
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
        for(Agent a : agents) {
            if(a.isSame(agent)) {
                a.infect(target);
                return;
            }
        }
    }

    public void clearCollectedGenetics() {
        genetics.clear();
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

    public String toString() {
        String returnString = "";
        returnString += "Name: " + name + "\n";
        returnString += "Field: " + currentField.getName() + "\n";

        returnString += "Equipments: ";
        for(Equipment equipment : equipments) {
            returnString += equipment.toString() + " ";
        }
        returnString += equipments.size() + "/" + maxEquipments + "\n";

        returnString += "Genetics: ";
        for(Genetics genetic : genetics) {
            returnString += genetic.toString() + " ";
        }
        returnString += "\n";

        returnString += "Substances:\n";
        returnString += "\tAmino: " + countSubstance(new Amino()) + "\n";
        returnString += "\tNukleotid: " + countSubstance(new Nukleotid()) + "\n";

        // TODO: Effects

        return returnString;
    }
}