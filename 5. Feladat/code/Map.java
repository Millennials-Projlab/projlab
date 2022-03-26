import java.util.ArrayList;

public class Map {
	private ArrayList<Field> Fields;
	
	public Map() {
		setFields(new ArrayList<Field>());
	}
	
	public void CreateMap(int fn, int s, int h, int l) {
		System.out.println("Map has been created");
	}

	public ArrayList<Field> getFields() {
		return Fields;
	}

	public void setFields(ArrayList<Field> fields) {
		Fields = fields;
	}
}
