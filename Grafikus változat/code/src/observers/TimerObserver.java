package observers;
import subjects.Timer;

public class TimerObserver {
    protected Timer subject;

    public TimerObserver(Timer subject) {
        this.subject = subject;
    }

    public void update() {

    }
}
