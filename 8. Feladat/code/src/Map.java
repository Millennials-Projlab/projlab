import java.util.ArrayList;
import java.util.Random;

/**
* Map osztály
*/
public class Map {
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

	public void createField(String[] args) throws IncorrectParameterException {
		checkFieldExistence(args[0]);

		Field field = new Field(args[0]);
		Fields.add(field);
	}

	public void createLaboratory(String[] args) throws IncorrectParameterException  {
		checkFieldExistence(args[0]);

		Laboratory laboratory = new Laboratory(args[0]);
		Genetics genetic;

		if(!Game.random) {
			switch(args[1]) {
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
				default:
					throw new IncorrectParameterException("Invalid genetic name");
			}	
		}
		else {
			Random rand = new Random();
			int geneticNum = rand.nextInt(3);

			switch(geneticNum) {
				case 0:
					genetic = new DanceGenetic(rand.nextInt(5), rand.nextInt(5));
					break;
				case 1:
					genetic = new DefenceGenetic(rand.nextInt(5), rand.nextInt(5));
					break;
				case 2:
					genetic = new PoisonGenetic(rand.nextInt(5), rand.nextInt(5));
					break;
				case 3:
					genetic = new AmnesiaGenetic(rand.nextInt(5), rand.nextInt(5));
					break;
				default:
					genetic = null;
					break;
			}	
		}

		laboratory.place(genetic);
		Fields.add(laboratory);
	}

	public void createWarehouse(String[] args) throws IncorrectParameterException  {
		checkFieldExistence(args[0]);

		Warehouse warehouse = new Warehouse(args[0]);
		ArrayList<Substance> substances = new ArrayList<Substance>();

		int aminoNum, nukleoNum;

		if(!Game.random) {
			aminoNum = Integer.parseInt(args[1]);
			nukleoNum = Integer.parseInt(args[2]);
		}
		else {
			Random rand = new Random();
			aminoNum = rand.nextInt(5);
			nukleoNum = rand.nextInt(5);
		}

		for(int i = 0; i < aminoNum; i++) {
			Amino a = new Amino();
			substances.add(a);
		}
		for(int i = 0; i < nukleoNum; i++) {
			Nukleotid n = new Nukleotid();
			substances.add(n);
		}

		warehouse.place(substances);
		Fields.add(warehouse);
	}

	public void createShelter(String[] args) throws IncorrectParameterException  {
		checkFieldExistence(args[0]);

		Shelter shelter = new Shelter(args[0]);
		Equipment equipment;

		if(!Game.random) {
			switch(args[1]) {
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
		}
		else {
			Random rand = new Random();
			int equipmentNum = rand.nextInt(3);

			switch(equipmentNum) {
				case 0:
					equipment = new Package();
					break;
				case 1:
					equipment = new Axe();
					break;
				case 2:
					equipment = new Gloves();
					break;
				case 3:
					equipment = new Cape();
					break;
				default:
					equipment = null;
					break;
			}
		}

		shelter.place(equipment);
		Fields.add(shelter);
	}

	private void checkFieldExistence(String name) throws IncorrectParameterException {
		if(Game.getMap().getField(name) != null) {
			throw new IncorrectParameterException("field with name " + "\""+ name +"\" already exists");
		}
	}

	public Field getField(String name) {
		for (Field field : Fields) {
			if(field.getName().equals(name)) {
				return field;
			}
		}

		return null;
	}

}
