package subjects;

public class Timer extends Thread {
	private boolean running = false;
	
	public void run() {
		running = true;
		tick();
	}

	public void tick() {
		while(true) {
			Game.tick();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}

	
	/** 
	 * Visszaadja, hogy az időzító fut-e
	 * @return boolean
	 */
	public boolean isRunning() {
		return running;
	}
}
