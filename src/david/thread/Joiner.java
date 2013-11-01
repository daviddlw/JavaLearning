package david.thread;

public class Joiner extends Thread {
	private Sleeper sleeper;
	
	public Joiner(String name, Sleeper sleeper) {
		// TODO Auto-generated constructor stub
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}
