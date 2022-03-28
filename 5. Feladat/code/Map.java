import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
* map osztaly
*/
public class Map {
	private ArrayList<Field> Fields;
	
	public Map() {
		setFields(new ArrayList<Field>());
	}
	
	public void CreateMap(int fn, int s, int h, int l) {
		Fields = new ArrayList<Field>();

		while(Fields.size() != fn) {
			System.out.println("Choose type of Field\n"
			+ "1 - Field\n"
			+ "2 - Laboratory\n"
			+ "3 - Warehouse\n"
			+ "4 - Shelter");
			Scanner console = new Scanner(System.in);
			switch(console.nextInt()) {
				case 1:
				{
					Field f = new Field();
					Fields.add(f);
					if(Fields.size() > 1) {
						Logger.addTab();
						f.setNeighbour(Fields.get(Fields.size()-2));
						Logger.log(f, "setNeighbour", Arrays.asList("Fields.get(Fields.size()-2)"));
						Logger.removeTab();

						Logger.addTab();
						Fields.get(Fields.size()-2).setNeighbour(f);
						Logger.log(Fields.get(Fields.size()-2), "setNeighbour", Arrays.asList("f"));
						Logger.removeTab();
					}
				}	
				break;
	
				case 2:
				{
					Laboratory f = new Laboratory();
					Fields.add(f);
					if(Fields.size() > 1) {
						Logger.addTab();
						f.setNeighbour(Fields.get(Fields.size()-2));
						Logger.log(f, "setNeighbour", Arrays.asList("Fields.get(Fields.size()-2)"));
						Logger.removeTab();

						Logger.addTab();
						Fields.get(Fields.size()-2).setNeighbour(f);
						Logger.log(Fields.get(Fields.size()-2), "setNeighbour", Arrays.asList("f"));
						Logger.removeTab();

						DanceGenetic danceGenetic = new DanceGenetic(1, 1);

						Logger.addTab();
						f.place(danceGenetic);
						Logger.log(f, "place", Arrays.asList("danceGenetic"));
						Logger.removeTab();
					}
				}
				break;
	
				case 3:
				{
					Warehouse f = new Warehouse();
					Fields.add(f);
					if(Fields.size() > 1) {
						Logger.addTab();
						f.setNeighbour(Fields.get(Fields.size()-2));
						Logger.log(f, "setNeighbour", Arrays.asList("Fields.get(Fields.size()-2)"));
						Logger.removeTab();

						Logger.addTab();
						Fields.get(Fields.size()-2).setNeighbour(f);
						Logger.log(Fields.get(Fields.size()-2), "setNeighbour", Arrays.asList("f"));
						Logger.removeTab();

						ArrayList<Substance> substances = new ArrayList<>();

						Logger.addTab();
						f.place(substances);
						Logger.log(f, "place", Arrays.asList("substances"));
						Logger.removeTab();
					}
				}
				break;
	
				case 4:
				{
					Shelter f = new Shelter();
					Fields.add(f);
					if(Fields.size() > 1) {
						Logger.addTab();
						f.setNeighbour(Fields.get(Fields.size()-2));
						Logger.log(f, "setNeighbour", Arrays.asList("Fields.get(Fields.size()-2)"));
						Logger.removeTab();

						Logger.addTab();
						Fields.get(Fields.size()-2).setNeighbour(f);
						Logger.log(Fields.get(Fields.size()-2), "setNeighbour", Arrays.asList("f"));
						Logger.removeTab();

						Package Package = new Package();

						Logger.addTab();
						f.place(Package);
						Logger.log(f, "place", Arrays.asList("Package"));
						Logger.removeTab();
					}
				}
				break;
	
				default:
					System.out.println("Invalid input");
					break;
			}
		}
	}

	public ArrayList<Field> getFields() {
		return Fields;
	}

	public void setFields(ArrayList<Field> fields) {
		Fields = fields;
	}
}
