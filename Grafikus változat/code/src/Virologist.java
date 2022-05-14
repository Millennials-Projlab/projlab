import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
* Virológus osztály
*/
public class Virologist {
    private ArrayList<Substance> substances;
    private ArrayList<Agent> agents;
    private ArrayList<Agent> effects;
    private ArrayList<Equipment> equipments;
    private ArrayList<Genetics> genetics;

    private int maxEquipments;
    private String name;
    private int maxSubstance;
    private Field currentField;
    private double defenseRating;

    /**
     * 0: no effect
     * 1: dance/poisoned
     * 2: bear dance
     * 3: immunity (not to be confused with Cape!)
    */
    private int effectFlag;

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
        effects = new ArrayList<Agent>();
        equipments = new ArrayList<Equipment>();
        genetics = new ArrayList<Genetics>();
        this.name = name;
        this.maxEquipments = maxEquipments;
        this.maxSubstance = maxSubstance;
        this.currentField = currentField;
    }
    
    /** 
     * @return String
     */
    public String getName(){
        return name;
    }
    
    
    /** 
     * @return Field
     */
    public Field getCurrentField() {
    	return currentField;
    }

    public void tick() {
        Iterator<Agent> agentIter = agents.iterator();
		while(agentIter.hasNext()) {
			Agent agent = agentIter.next();
			agent.tick(this, agentIter);	
		}

        Iterator<Agent> effectIter = effects.iterator();
		while(effectIter.hasNext()) {
			Agent effect = effectIter.next();
			effect.tick(this, effectIter);	
		}
    }
    
    
    /** 
     * Elkészíti a megadott ágenst, ha a virológus ismeri a genetikai kódját és van elég anyaga
     * @param args
     * @throws IncorrectParameterException
     */
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

        System.out.println("CREATED: " + agent);
    }

    
    /** 
     * @param pgenetic
     * @return Genetics
     * @throws IncorrectParameterException
     */
    private Genetics getLearnedGenetic(Genetics pgenetic) throws IncorrectParameterException {
        for(Genetics genetic : genetics) {
            if(pgenetic.isSame(genetic)) {
            	return genetic;
            }
    	}
        throw new IncorrectParameterException("Virologist does not have that genetic learned.");
    }

    /** 
     * A virológus megtámadja a paraméterként megadott virológust a paraméterként megadott tipusú ágenssel
     * @param target
     * @param agentName
     */
    public void infect(Virologist target, String agentName) {
        if(isVirologistPoisoned()) {
            return;
        }
        if(!isTargetTouchable(target)) {
            return;
        }

        for(Agent agent : agents) {
            if(agent.isSame(agentName)) {
                agents.remove(agent);
                agent.infect(target, this);
                return;
            }
        }

        if(agentName.equals("BearAgent") && effectFlag == 2) {
            new BearAgent().infect(target, this);
        }

        System.out.println("Virologist does not have that Agent.");
    }

    
    /** 
     * Visszaadja, hogy a virológus le van-e bénulva
     * @return boolean
     */
    private boolean isVirologistPoisoned() {
        if(effectFlag < 0 && effectFlag < 3) {
            System.out.println("Virologist is poisoned and can't interact right now.");
            return true;
        }
        return false;
    }

    
    /** 
     * Visszaadja, hogy a célpont érinthető-e
     * @param target
     * @return boolean
     */
    private boolean isTargetTouchable(Virologist target) {
        if(target.getCurrentField() != currentField) {
            System.out.println("Target virologist is not on the same field.");
            return false;
        }
        return true;
    }

    public void axeHit() {
        for(Agent agent : agents) {
            if(agent.isSame("BearAgent")) { 
                agent.endEffect(this);
                return;
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

        if(isVirologistPoisoned()) {
            return;
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
        if(isVirologistPoisoned()) {
            System.out.println("Virologist is poisoned");
            return;
        }
        currentField.lootItem(this);
    }
    
    /** 
     * @param agent
     */
    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    /** 
     * @param equipment
     */
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        equipment.startEffect(this);
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
     * @param equipment
     */
    public void removeEquipment(Equipment equipment) {
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
  
    
    /** 
     * Ellenőrzi, hogy van-e elég anyag az ágens létrehozásához
     * @param genetic
     * @return boolean
     */
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
     * @param maxSubstance
     */
    public void setMaxSubstance(int maxSubstance) {
        this.maxSubstance = maxSubstance;
    }
	
    /** 
     * @return int
     */
    public int getMaxSubstance() {
		return maxSubstance;
    }

    
    /** 
     * @return int
     */
    public int getMaxEquipments() {
        return maxEquipments;
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
     * @param defenseRating
     */
    public void setDefenseRating(double defenseRating) {
        this.defenseRating = defenseRating;
    }

    /** 
     * @return double defenseRating
     */
    public double getDefenseRating() {
        return defenseRating;
    }

    public void clearCollectedGenetics() {
        genetics.clear();
    }
    
    /** 
     * @param flag
     */
    public void setEffectFlag(int flag) {
        effectFlag = flag;
    }

    
    /** 
     * @return int
     */
    public int getEffectFlag() {
        return effectFlag;
    }

    
    /** 
     * @param effect
     * @param sender
     */
    public void addEffect(Agent effect, Virologist sender) {
        if(hasEquipment("Cape")) {
            Random rand = new Random();
            if(rand.nextDouble(0, 100) > defenseRating) {
                effect.endEffect(this);
                return;
            }   
        }
        if(hasEquipment("Gloves")) {
            useGloves();
            effect.endEffect(this);
            addAgent(effect);
            infect(sender, effect.toString());
            return;
        }
        effects.add(effect);
    }

    
    /** 
     * @param effect
     */
    public void removeEffect(Agent effect) {
        effects.remove(effect);
    }

    public void useGloves() {
        for(Equipment equipment : equipments) {
            if(equipment.toString().equals("Gloves")) {
                ((Gloves)equipment).use(this);
                return;
            }
        }
    }

    
    /** 
     * Ellenőrzi a megadott felszerelés meglétét
     * @param name
     * @return boolean
     */
    public boolean hasEquipment(String name) {
        for(Equipment equipment : equipments) {
            if(equipment.toString().equals(name)) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * Használja a baltát, ha van
     * @param target
     */
    public void useAxe(Virologist target) {
        if(hasEquipment("Axe")) {
            for(Equipment equipment : equipments) {
                if(equipment.toString().equals("Axe")) {
                    ((Axe)equipment).use(this);
                    return;
                }
            }
        }
    }

    
    /** 
     * true, ha van még bénító effect a virológuson
     * @return boolean
     */
    public boolean checkPoisonEffects() {
        for(Agent effect : effects) {
            if(effect.isSame("DanceAgent") || effect.isSame("PoisonAgent")) {
                return true;
            }
        }
        return false;
    }

    
    /** 
     * Eltávolítja az anyagokat a virológus zsákjából
     * @param genetic
     */
    public void removeMaterials(Genetics genetic) {
        HashMap<Substance, Integer> recipe = genetic.getRecipe();
        for(Substance key : recipe.keySet()) {
            for(int i = 0; i < recipe.get(key); i++) {
                removeSubstance(key);
            }
        }
    }
    
    /** 
     * @return String
     */
    public String toString() {
        String returnString = "";
        returnString += "Name: " + name + "\n";
        returnString += "Field: " + currentField.getName() + "\n";

        returnString += "Agents: ";
        for(Agent agent : agents) {
            returnString += agent.toString() + " ";
        }
        returnString += "\n";

        returnString += "Effects: ";
        for(Agent effect : effects) {
            returnString += effect.toString() + " ";
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

        return returnString;
    }
}
