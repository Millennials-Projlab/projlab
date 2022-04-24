
public class Timer {
	private boolean timer = true;
	private Timer timert = new Timer();
	
	public void Tick() {
		timert.Tick();
		System.out.println("Time is ticking.");
	}
	
	public void Start() {
		timert.Start();
		System.out.println("Timer has started");
	}
	
	public void Stop() {
		timert.Stop();
		System.out.println("Timer has stopped");
	}

	public boolean isTimer() {
		return timer;
	}

	public void setTimer(boolean timer) {
		this.timer = timer;
	}
}
