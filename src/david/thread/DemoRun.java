package david.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class DemoRun {

	public static void timerCalculate() {
		Timer timer = new Timer("���Ժ�̨", false);
		timer.schedule(new TimerTask() {
			int count = 10;
			int total = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 10; i++) {
					total += i;
				}
				System.out.println("Total=>" + total);
			}
		}, 2000);
		try {
			System.out.println("������......");			
			TimeUnit.MILLISECONDS.sleep(2100);
//			Thread.sleep(2100);			
			System.out.println("������ɣ�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void serialNumberDemo(boolean isInner) {
		ExecutorService service = Executors.newCachedThreadPool();
		if (isInner) {
			final CircularSet cs = new CircularSet(1000);
			for (int i = 0; i < 10; i++) {
				service.execute(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						while (true) {
							int serial = new SerialNumberGenerator().next();
							if (cs.contains(serial)) {
								System.out.println("���ظ�ֵ��" + serial);
								System.exit(0);
							}
							cs.add(serial);
						}
					}
				});
			}
		} else {
			service.execute(new SerialNumberChecker());
		}
		System.out.println("û���ظ�ֵ");
		System.exit(0);
	}

	public static void attemptingLock() {
		final AttemptingLock attemptingLock = new AttemptingLock();
		attemptingLock.untimed();
		attemptingLock.timed();

		new Thread() {
			{
				setDaemon(true);
			}
			public void run() {
				attemptingLock.lock.lock();
				System.out.println("acquired!");
			};
		}.start();

		// Thread back = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// // TODO Auto-generated method stub
		// attemptingLock.lock.lock();
		// System.out.println("acquired!");
		// }
		// });
		// back.setDaemon(true);
		// back.start();

		attemptingLock.untimed();
		attemptingLock.timed();
	}

	public static void personAccountDemo() {
		ExecutorService service = Executors.newCachedThreadPool();
		PersonAccount personAccount = new PersonAccount();
		// personAccount.init();
		for (int i = 0; i < 3; i++) {
			service.execute(personAccount);
		}
	}

	/*
	 * �̵߳��쳣�������
	 */
	public static void exceptionThread(boolean enableUncaughtExceptin) {
		if (enableUncaughtExceptin) {
			Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
			ExecutorService service = Executors
					.newCachedThreadPool(new MyUncaughtExceptionFactory());
			service.execute(new ExceptionThread());
		} else {
			// ���߳���run�������׳����쳣��û�а취��try-catch�����
			try {
				ExecutorService service = Executors.newCachedThreadPool();
				service.execute(new ExceptionThread());
			} catch (RuntimeException e) {
				// TODO: handle exception
				System.out.println("exception has been catched!");
			}
		}
	}

	public static void readFromSystemIn() {
		@SuppressWarnings("resource")
		String s = new Scanner(System.in).nextLine();
		System.out.println(s);
	}

	public static void sleeperAndJoiner() {
		Sleeper sleeperOne = new Sleeper("sleeperOne", 1500);
		Sleeper sleeperTwo = new Sleeper("sleeperTwo", 1500);

		Joiner joinerOne = new Joiner("joinerOne", sleeperOne);
		Joiner joinerTwo = new Joiner("joinerTwo", sleeperTwo);

		sleeperOne.interrupt();
	}

	public static void daemonDemo() {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();

		// ע�͵�������仰�ᵼ�£��������̣߳��Ǻ�̨�̣߳��Ľ��������к�̨�̵߳Ĺرս���
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("d is Daemon => " + d.isDaemon());
	}

	public static void simpleDaemonFactory() {
		ExecutorService es = Executors
				.newCachedThreadPool(new SimpleDaemonFactory());
		for (int i = 0; i < 10; i++) {
			es.execute(new SimpleDaemon());
		}
	}

	public static void simpleDaemon() {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new SimpleDaemon());
			thread.setDaemon(true);
			thread.start();// ֱ��дrun���Ƿ�������û�п����̣߳�����ֻ�����̣߳�, start��Ϊ�˽��̼߳������
		}
	}

	public static void simplePriority() {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			es.execute(new SimplePriority(Thread.MIN_PRIORITY));
			es.execute(new SimplePriority(Thread.MIN_PRIORITY));
		}
	}

	public static void sleepTaskNoRunnable() {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			Future<Integer> f = es.submit(new SleepingTaskContainsReturn());
			try {
				System.out.println("˯��ʱ�䣺" + f.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		es.shutdown();
	}

	public static void sleepTask() {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			es.execute(new SleepingTask());
		}
		es.shutdown();
	}

	/*
	 * ˳��ִ��fib���������ܺ�
	 */
	public static void calculateFibonaciiTotalByThread(int count) {
		System.out.println("�߳�ִ��");
		int total = 0;
		List<Integer> ls = new ArrayList<Integer>();
		ExecutorService es = Executors.newCachedThreadPool();
		// ExecutorService es = Executors.newSingleThreadExecutor();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0; i < count; i++) {
			Future<Integer> obj = es.submit(new FibFunction(i));
			int num = 0;
			try {
				// num = new FibFunction().fib(i);
				num = obj.get();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			ls.add(num);
			total += num;
		}
		es.shutdown();
		stopWatch.stop();
		System.out.println(ls);
		System.out.println("Total: " + total + "����ʱ: "
				+ stopWatch.getNanoTime());
	}

	/*
	 * ˳��ִ��fib���������ܺ�
	 */
	public static void calculateFibonaciiTotalBySeq(int count) {
		System.out.println("˳��ִ��");
		int total = 0;
		List<Integer> ls = new ArrayList<Integer>();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0; i < count; i++) {
			FibFunction fibFunction = new FibFunction();
			int num = fibFunction.fib(i);
			ls.add(num);
			total += num;
		}
		stopWatch.stop();
		System.out.println(ls);
		System.out.println("Total: " + total + "����ʱ: "
				+ stopWatch.getNanoTime());
	}

	public static void liftOffByExecutorNonFix() {
		System.out.println("�߳�ִ��");
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			es.execute(new LiftOff());
		}
		es.shutdown();
	}

	public static void liftOffByExecutorFix() {
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			es.execute(new LiftOff());
		}
		es.shutdown();
	}

	public static void liftOffBySingleExecutor() {
		ExecutorService es = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			es.execute(new LiftOff());
		}
		es.shutdown();
	}

	public static void liftOffByScheduledThread() {
		ExecutorService es = Executors.newScheduledThreadPool(1000);
		for (int i = 0; i < 5; i++) {
			es.execute(new LiftOff());
		}
		es.shutdown();
	}

	public static void basicThreadRun(RunType type) {
		switch (type) {
			case Run : {
				BasicThread bt = new BasicThread();
				bt.run();
			}
				break;
			case Start : {
				new Thread(new BasicThread()).start();
			}
				break;
			case MutipleThread : {
				for (int i = 0; i < 5; i++) {
					Thread t = new Thread(new BasicThread(
							String.valueOf("thread" + (i + 1))));
					t.start();
				}
			}
				break;
			default :
				new Thread(new BasicThread()).start();
				break;
		}

	}

	/*
	 * ˳�����fib��ֵ��ĳ��list
	 */
	public static void fibBySequence() {
		StopWatch stopWatch = new StopWatch();
		List<Integer> ls = new ArrayList<Integer>();
		stopWatch.start();
		for (int i = 0; i < 30; i++) {
			ls.add(fib(i));
		}
		stopWatch.stop();
		System.out.println(ls);
		System.out.println("��ʱ: " + stopWatch.getNanoTime());
	}

	public static void fibByExecutor() {
		Set<Integer> result = new TreeSet<Integer>();
		// ExecutorService es = Executors.newCachedThreadPool();
		ExecutorService es = Executors.newCachedThreadPool();
		ThreadFibonacci tf = null;

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		for (int i = 0; i < 25; i++) {
			tf = new ThreadFibonacci(i);
			try {
				// result.add(es.submit(tf).get());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		es.shutdown();

		stopWatch.stop();
		System.out.println("��ʱ: " + stopWatch.getNanoTime());

		System.out.println(result);
	}

	/*
	 * ���߳�������
	 */
	public static void fibByThread() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		/*
		 * ��10���߳���
		 */
		ThreadFibonacci tf = null;
		Set<Integer> result = new TreeSet<Integer>();
		for (int i = 0; i < 25; i++) {
			if (i <= 10) {
				tf = new ThreadFibonacci(i);
				new Thread(tf).start();
			} else if (i > 10 && i <= 20) {
				tf = new ThreadFibonacci(i);
				new Thread(tf).start();
			} else {
				tf = new ThreadFibonacci(i);
				new Thread(tf).start();
			}
		}

		stopWatch.stop();
		System.out.println("��ʱ: " + stopWatch.getNanoTime());

		for (Integer item : tf.getFibList()) {
			result.add(item);
		}

		System.out.println(result);
	}

	public static void fibonacciFunction() {
		Set<FibModel> treeSet = new TreeSet<FibModel>();
		int i = 0;
		while (i < 29) {
			// for (int j = 1; j < 5; j++) {
			// ThreadFibonacci tf = new ThreadFibonacci("�߳�" + j, i);
			// new Thread(tf).start();
			// treeSet.add(new FibModel(tf.threadName(), tf.fib(i)));
			// i++;
			// }
			ThreadFibonacci tf = new ThreadFibonacci("�߳�" + i, i);
			new Thread(tf).start();
			treeSet.add(new FibModel(tf.threadName(), tf.fib(i)));
			i++;
		}

		int j = 1;
		for (FibModel map : treeSet) {
			if (j % 5 == 0) {
				System.out.println();
			}
			System.out.print(map + " ");
			j++;
		}
	}

	public static int fib(int n) {
		Thread.yield();
		if (n < 2)
			return 1;
		else
			return fib(n - 2) + fib(n - 1);
	}
}

class FibModel implements Comparable<FibModel> {
	private String name;
	private int result;

	public FibModel(String name, Integer result) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.result = result;
	}

	@Override
	public int compareTo(FibModel value) {
		// TODO Auto-generated method stub
		return this.result == 0 ? 0 : (this.result > value.result ? 1 : -1);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[result: %d => thread: %s]", result, name);
	}

}

enum RunType {
	Run, Start, MutipleThread
}
