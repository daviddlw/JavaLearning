package david.thread;

import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			System.out.print(status() + " ");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Interrupted");
			}
		}
	}
}
