package subjects;
import java.util.ArrayList;

import observers.*;

public abstract class Subject {
    private ArrayList<Observer> observerList;

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observerList) {
            observer.update(this);
        }
    }
}
