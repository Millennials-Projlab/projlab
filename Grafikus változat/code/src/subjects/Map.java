package subjects;
import java.util.ArrayList;
import java.util.Random;
import main.*;
import main.Package;


/**
* Map osztály
*/
public class Map extends Subject {
	private ArrayList<Field> Fields;
	
	public Map() {
		Fields = new ArrayList<Field>();
	}
	
	/** 
	 * @return ArrayList<Field>
	 */
	public ArrayList<Field> getFields() {
		return Fields;
	}

	
	/** 
	 * @param args
	 * @throws IncorrectParameterException
	 */
	public void createField(String name) throws IncorrectParameterException {
		checkFieldExistence(name);

		Field field = new Field(name);
		Fields.add(field);

		System.out.println("CREATED: Field " + name);
	}
	
	/** 
	 * @param args
	 * @throws IncorrectParameterException
	 */
	public void createLaboratory(String name, String geneticName) throws IncorrectParameterException  {
		checkFieldExistence(name);

		Laboratory laboratory = new Laboratory(name);
		Genetics genetic;

		switch(geneticName) {
			case "DanceGenetic":
				genetic = new DanceGenetic(1, 1);
				break;
			case "DefenceGenetic":
				genetic = new DefenceGenetic(1, 1);
				break;
			case "PoisonGenetic":
				genetic = new PoisonGenetic(1, 1);
				break;
			case "AmnesiaGenetic":
				genetic = new AmnesiaGenetic(1, 1);
				break;
			case "BearGenetic":
				genetic = new BearGenetic();
				break;
			default:
				throw new IncorrectParameterException("Invalid genetic name");
		}
		laboratory.place(genetic);
		Fields.add(laboratory);

		System.out.println("CREATED: " + genetic);
		System.out.println("CREATED: Laboratory " + laboratory.getName());
	}

	
	/** 
	 * @param args
	 * @throws IncorrectParameterException
	 */
	public void createWarehouse(String name) throws IncorrectParameterException  {
		checkFieldExistence(name);

		Warehouse warehouse = new Warehouse(name);
		ArrayList<Substance> substances = new ArrayList<Substance>();

		int aminoNum, nukleoNum;

		Random rand = new Random();
		aminoNum = rand.nextInt(5);
		nukleoNum = rand.nextInt(5);

		for(int i = 0; i < aminoNum; i++) {
			Amino a = new Amino();
			substances.add(a);
			System.out.println("CREATED: Amino");
		}
		for(int i = 0; i < nukleoNum; i++) {
			Nukleotid n = new Nukleotid();
			substances.add(n);
			System.out.println("CREATED: Nukleotid");
		}

		warehouse.place(substances);
		Fields.add(warehouse);

		System.out.println("CREATED: Warehouse " + warehouse.getName());
	}

	
	/** 
	 * @param args
	 * @throws IncorrectParameterException
	 */
	public void createShelter(String name, String equipmentName) throws IncorrectParameterException  {
		checkFieldExistence(name);

		Shelter shelter = new Shelter(name);
		Equipment equipment;

		switch(equipmentName) {
			case "Package":
				equipment = new Package();
				break;
			case "Axe":
				equipment = new Axe();
				break;
			case "Gloves":
				equipment = new Gloves();
				break;
			case "Cape":
				equipment = new Cape();
				break;
			default:
				throw new IncorrectParameterException("Invalid equipment name");
		}
		shelter.place(equipment);
		Fields.add(shelter);

		System.out.println("CREATED: " + equipment);
		System.out.println("CREATED: Shelter " + shelter.getName());
	}

	
	/** 
	 * @param args
	 * @throws IncorrectParameterException
	 */
	public void setNeighbor(String fieldName1, String fieldName2) throws IncorrectParameterException  {
		Field field1 = getField(fieldName1);
		Field field2 = getField(fieldName2);

		if(field1 == null) {
			throw new IncorrectParameterException("field with name " + "\""+ fieldName1 +"\" does not exist");
		}
		if(field2 == null) {
			throw new IncorrectParameterException("field with name " + "\""+ fieldName2 +"\" does not exist");
		}

		field1.setNeighbour(field2);
		field2.setNeighbour(field1);
	}

	
	/** 
	 * Ellenőrzi, hogy létezik-e már mező a megadott névvel
	 * @param name
	 * @throws IncorrectParameterException
	 */
	private void checkFieldExistence(String name) throws IncorrectParameterException {
		if(Game.getMap().getField(name) != null) {
			throw new IncorrectParameterException("field with name " + "\""+ name +"\" already exists");
		}
	}

	
	/** 
	 * @param name
	 * @return Field
	 */
	public Field getField(String name) {
		for (Field field : Fields) {
			if(field.getName().equals(name)) {
				return field;
			}
		}

		return null;
	}

}
