package david.thread;

public class Accessor implements Runnable {

	private final int id;

	public Accessor(int idn) {
		// TODO Auto-generated constructor stub
		id = idn;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVarHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("# %d£º%d", id, ThreadLocalVarHolder.get());
	}
	
}
