package david.thread;

import java.io.IOException;

public class UnreponsibleUI {
	private volatile double d = 1;
	public UnreponsibleUI() throws IOException {
		// TODO Auto-generated constructor stub
		while (d > 0) {
			d = (Math.PI + 1) / d;
			DemoRun.readFromSystemIn();
		}
	}
}
