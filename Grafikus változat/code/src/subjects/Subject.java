package subjects;
import java.util.ArrayList;

import observers.*;

public abstract class Subject {
    protected ArrayList<Observer> observerList;

    public Subject() {
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
}
