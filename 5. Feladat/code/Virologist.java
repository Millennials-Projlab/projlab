import java.util.ArrayList;
import java.util.jar.Attributes.Name;

public class Virologist {
    private ArrayList<Substances> Substances;
    private ArrayList<Agent> Agents;
    private ArrayList<Equipment> Equipments;
    private ArrayList<Genetics> Genetics;

    private int maxEquipments;
    private String name;
    private int maxAmino;
    private int maxNukleotid;

    
    public Virologist(int mE,String n, int mA,int mN){         //mE:maxEquipments      n:name      mA:maxAmino     mN:maxNukleotid
        Substances=new ArrayList<Substances>();
        Agents=new ArrayList<Agent>();
        Equipments=new ArrayList<Equipment>();
        Genetics=new ArrayList<Genetics>();
        maxEquipments=mE;
        name=n;
        maxAmino=mA;
        maxNukleotid=mN;
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

}
