package david.thread;

public class EvenGenerator extends IntGenerator {
	private int currentEvenVal = 0;

	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		++currentEvenVal;
		Thread.yield();
		++currentEvenVal;
		return currentEvenVal;
	}
}
