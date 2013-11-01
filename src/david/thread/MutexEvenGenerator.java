package david.thread;

import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	private ReentrantLock lock = new ReentrantLock();

	@Override
	public int next() {
		lock.lock();
		try {
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			// TODO Auto-generated method stub
			return currentEvenValue;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
		return 0;
	}
}
