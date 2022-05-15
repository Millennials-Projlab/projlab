package subjects;
import java.util.ArrayList;
import observers.Observer;

public class Timer extends Thread implements ISubject {
	private boolean running = false;
	private ArrayList<Observer> observerList;

    public Timer() {
        observerList = new ArrayList<Observer>();
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observerList) {
            observer.update();
        }
    }
	
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
