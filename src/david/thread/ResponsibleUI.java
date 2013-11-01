package david.thread;

public class ResponsibleUI extends Thread {
	private static int d = 0;

	public ResponsibleUI() {
		// TODO Auto-generated constructor stub
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			d += (Math.PI + Math.E) / d;
		}
	}
}
