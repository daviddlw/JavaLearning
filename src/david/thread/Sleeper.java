package david.thread;

public class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int duration) {
		// TODO Auto-generated constructor stub
		super(name);
		this.duration = duration;
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(getName()
					+ " was interrupted, is interrupted(): " + interrupted());
			return;
		}

		System.out.println(getName() + " was awakend");
	}
}
