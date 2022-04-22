import java.util.ArrayList;

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
		if(Game.getMap().getField(args[0]) != null) {
			throw new IncorrectParameterException("field with name " + "\""+ args[0] +"\" already exists");
		}


		Field field = new Field(args[0]);
		Fields.add(field);

		
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
