import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* Game osztály
*/
public class Game {
	private Map Map;
	private ArrayList<Virologist> Players;
	
	public Game() {
		Players = new ArrayList<Virologist>();
	}
	
	public void Start() {
		Map map = new Map();
		List<Object> parameters = new ArrayList<Object>();

		System.out.println("Choose number of Fields");
		
		Scanner console = new Scanner(System.in);
		int fieldNumber = console.nextInt();
		parameters.add(fieldNumber);
		parameters.add(0);
		parameters.add(0);
		parameters.add(0);

		Logger.addTab();
		Logger.log(map, "CreateMap", parameters);
		map.CreateMap(fieldNumber, 0, 0, 0);
		Logger.removeTab();
	}
	
	public void End() {
		System.out.println("Game has ended.");
	}

	
	/** 
	 * @return Map
	 */
	public Map getMap() {
		return Map;
	}

	
	/** 
	 * @param map
	 */
	public void setMap(Map map) {
		Map = map;
	}

	
	/** 
	 * @return ArrayList<Virologist>
	 */
	public ArrayList<Virologist> getPlayers() {
		return Players;
	}

	
	/** 
	 * @param players
	 */
	public void setPlayers(ArrayList<Virologist> players) {
		Players = players;
	}

	
	/** 
	 * @param v
	 */
	public void addPlayer(Virologist v) {
		Players.add(v);
	}
	
	public void Tick() {
		Logger.addTab();
		for(Virologist virologist : Players) {
			Logger.log(virologist, "collectedAllGenetics", "");
			if (virologist.collectedAllGenetics() == true) {
				Logger.addTab();
				Logger.log(this, "End", "");
				End();
				Logger.removeTab();
				
				Logger.removeTab();
				return;
			}
		}
		Logger.removeTab();
	}
}
