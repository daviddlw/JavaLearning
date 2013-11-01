package david.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptingLock {
	public ReentrantLock lock = new ReentrantLock();

	/*
	 * 时间锁
	 */
	public void timed() {
		boolean isCaptured = false;
		try {
			isCaptured = lock.tryLock(3, TimeUnit.SECONDS);
			System.out.println("try lock: " + isCaptured);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (isCaptured)
				lock.unlock();
		}
	}

	/*
	 * 无时间锁
	 */
	public void untimed() {
		boolean isCaptured = lock.tryLock();
		try {
			System.out.println("try lock: " + isCaptured);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (isCaptured)
				lock.unlock();
		}
	}
}
