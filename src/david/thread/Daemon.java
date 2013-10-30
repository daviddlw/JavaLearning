package david.thread;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable {

	private Thread[] t = new Thread[10];

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			t[i] = new Thread(new DaemonSwan());
			t[i].start();
			System.out.println("DaemonSwan " + i + " started.");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("is this part always show ?");
			}
		}

		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());
		}
		while (true) {
			Thread.yield();
		}
	}
}

class DaemonSwan implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Thread.yield();
		}
	}
}
