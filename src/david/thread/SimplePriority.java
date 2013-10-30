package david.thread;

public class SimplePriority implements Runnable {

	private int countDown = 5;
	private volatile double result = 0;
	private int priority;

	public SimplePriority(int priority) {
		// TODO Auto-generated constructor stub
		this.priority = priority;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName() + ": " + countDown;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			for (int i = 1; i < 10000; i++) {
				result += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
		}
	}
}
