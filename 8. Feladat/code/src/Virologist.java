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

    public void tick() {
        for(Agent agent : agents) {
            agent.tick(this);
        }
    }
    
    public void produceAgent(String[] args) throws IncorrectParameterException {
        Genetics genetic;
    	Agent agent;
        int liveTime;

        if(Game.random) {
            Random rand = new Random();
		    liveTime = rand.nextInt(100);
        }
        else {
            liveTime = Integer.parseInt(args[2]);
        }
    	
    	switch(args[1]) {
    		case "AmnesiaAgent":
                genetic = getLearnedGenetic(new AmnesiaGenetic());
    			break;
    			
    		case "DanceAgent":
                genetic = getLearnedGenetic(new DanceGenetic());
    			break;
    			
    		case "DefenceAgent":
                genetic = getLearnedGenetic(new DefenceGenetic());
    			break;
    			
    		case "PoisonAgent":
                genetic = getLearnedGenetic(new PoisonGenetic());
    			break;
    			
    		default:
                throw new IncorrectParameterException("This type of genetic does not exist.");
    	}

        agent = genetic.generate(this, liveTime);
        if(agent != null) {
            this.addAgent(agent);
        }
    }

    private Genetics getLearnedGenetic(Genetics pgenetic) throws IncorrectParameterException {
        for(Genetics genetic : genetics) {
            if(pgenetic.isSame(genetic)) {
            	return genetic;
            }
    	}
        throw new IncorrectParameterException("Virologist does not have that genetic learned.");
    }
    
    public void removeMaterials(Genetics genetic) {
        HashMap<Substance, Integer> recipe = genetic.getRecipe();
        for(Substance key : recipe.keySet()) {
            for(int i = 0; i < recipe.get(key); i++) {
                removeSubstance(key);
            }
        }
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
    public void addSubstance(Substance substance) throws MaximumSubstanceException {
        if(maxSubstance == substances.size()) {
            throw new MaximumSubstanceException("");
        }
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
    

    public boolean checkSubstanceRequirements(Genetics genetic) {
        HashMap<Substance, Integer> recipe = genetic.getRecipe();

        for(Substance key : recipe.keySet()) {
            if(countSubstance(key) < recipe.get(key)) {
                return false;
            }
        } 
        return true;
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
            	return true;
            }
    	}
         return false;
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
     * A virológus megtámadja a paraméterként megadott virológust a paraméterként megadott tipusú ágenssel
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

        returnString += "Agents: ";
        for(Agent agent : agents) {
            returnString += agent.toString() + " ";
        }
        returnString += "\n";

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