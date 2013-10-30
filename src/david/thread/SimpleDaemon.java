package david.thread;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " "
						+ this);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
}
