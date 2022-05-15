package subjects;
import java.util.ArrayList;
import observers.Observer;

public interface ISubject {
    public void attach(Observer observer);

    public void remove(Observer observer);

    public void notifyObservers();
}
