package subjects;
import java.util.Iterator;

public abstract class Agent extends Subject {
	private Genetics genetic;
	private int livetime;
	protected boolean effect = false;
	
	public Agent(Genetics g, int l) {
		genetic = g;
		livetime = l;
	}
	
	/** 
	 * megvalósítja az ágens időlépését
	 * @param virologist virológus, amelynél/amelyen az ágens van
	 * @param iter ágens lista iterátora
	 */
	public void tick(Virologist virologist, Iterator<Agent> iter) {
		livetime -= 1;
		if(livetime == 0) {
			if(effect) {
				iter.remove();
				endEffect(virologist);
				return;
			}
			iter.remove();
		}
	}
	
	public void startEffect(Virologist virologist) {}
	
	public void endEffect(Virologist virologist) {}
	
	
	/** 
	 * @return Genetics
	 */
	public Genetics getGenetic() {
		return genetic;
	}
	
	/** 
	 * @param genetic
	 */
	public void setGenetic(Genetics genetic) {
		this.genetic = genetic;
	}
	
	/** 
	 * @return int
	 */
	public int getLivetime() {
		return livetime;
	}
	
	/** 
	 * @param livetime
	 */
	public void setLivetime(int livetime) {
		this.livetime = livetime;
	}
	
	
	/** 
	 * Összehasonlítja a paraméterként megadott ágenst a jelenlegi objektummal
	 * @param a
	 * @return boolean igaz, ha a két ágens tipusa megegyezik
	 */
	public boolean isSame(Agent a) {
		if(this.getClass() == a.getClass())
			return true;
		return false;
	}

	public abstract boolean isSame(String agentName);

	public abstract void infect(Virologist target, Virologist sender);
}
