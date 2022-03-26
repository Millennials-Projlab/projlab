import java.util.ArrayList;

public class Game {
	private Map Map;
	private ArrayList<Virologist> Players;
	
	public Game() {
		setMap(new Map());
		setPlayers(new ArrayList<Virologist>());
	}
	
	public void Start() {
		System.out.println("Map has been set up.");
	}
	
	public void End() {
		System.out.println("Game has ended.");
	}

	public Map getMap() {
		return Map;
	}

	public void setMap(Map map) {
		Map = map;
	}

	public ArrayList<Virologist> getPlayers() {
		return Players;
	}

	public void setPlayers(ArrayList<Virologist> players) {
		Players = players;
	}
	
}
