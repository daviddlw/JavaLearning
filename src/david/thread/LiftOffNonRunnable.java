package david.thread;

public class LiftOffNonRunnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOffNonRunnable() {
		// TODO Auto-generated constructor stub
	}

	public LiftOffNonRunnable(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return String.format("#%d%s", id,
				countDown > 0
						? "(" + String.valueOf(countDown) + ")"
						: "(LiftOff!)\n");
	}
}
