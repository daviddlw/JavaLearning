package david.thread;

import java.util.Random;

public class ThreadLocalVarHolder {
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		private Random rand = new Random();

		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};

	public static void increment() {
		tl.set(tl.get() + 1);
	}
	
	public static Integer get() {
		return tl.get();
	}
}
