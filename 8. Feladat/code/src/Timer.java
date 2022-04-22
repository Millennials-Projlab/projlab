
public class Timer {
	private boolean timer = true;
	
	public void Tick() {
		System.out.println("Time is ticking.");
	}
	
	public void Start() {
		System.out.println("Timer has started");
	}
	
	public void Stop() {
		System.out.println("Timer has stopped");
	}

	public boolean isTimer() {
		return timer;
	}

	public void setTimer(boolean timer) {
		this.timer = timer;
	}
}
