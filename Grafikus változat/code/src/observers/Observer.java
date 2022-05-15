package observers;
import subjects.*;

public abstract class Observer {
    private Subject subject;

    public abstract void update(Subject subject);
}
