package david.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SleepingTaskContainsReturn extends LiftOffNonRunnable
		implements
			Callable<Integer> {

	public SleepingTaskContainsReturn() {
		// TODO Auto-generated constructor stub
	}

	public SleepingTaskContainsReturn(int n) {
		// TODO Auto-generated constructor stub
		super(n);
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub

		int time = 0;
		Random rand = new Random();
		while (countDown-- > 0) {
			System.out.print(status() + " ");
			time = rand.nextInt(1000);
			TimeUnit.MICROSECONDS.sleep(time);
		}

		return time;
	}

}
