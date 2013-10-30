package david.thread;

public class LiftOff implements Runnable {

	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
		// TODO Auto-generated constructor stub
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return String.format("#%d%s", id,
				countDown > 0
						? "(" + String.valueOf(countDown) + ")"
						: "(LiftOff!)\n");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			System.out.print(status() + " ");
			Thread.yield();
		}
	}

}
