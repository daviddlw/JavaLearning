package david.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
 * 总数计数器
 */
class Count {
	private int count = 0;
	private Random rand = new Random();

	public synchronized int increament() {
		int temp = count;
		if (rand.nextBoolean()) {
			Thread.yield();
		}
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
}

/*
 * 大门入口类
 */
public class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> ls = new ArrayList<Entrance>();
	private int number = 0;
	private final int id;
	private static volatile boolean canceled = false;

	public Entrance(int id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		ls.add(this);
	}

	public static void cancel() {
		canceled = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!canceled) {
			synchronized (this) {
				number++;
			}
			System.out.println(this + " Total: " + count.increament());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Entrance %d: %d", id, getValue());
	}

	public static int getTotal() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance item : ls) {
			sum += item.getValue();
		}
		return sum;
	}
}
