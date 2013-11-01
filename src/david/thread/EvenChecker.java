package david.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator generator, int id) {
		// TODO Auto-generated constructor stub
		this.generator = generator;
		this.id = id;
	}

	public static void test(IntGenerator generator, int count) {
		System.out.println("Press control+c to exit");
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			service.execute(new EvenChecker(generator, i));
		}
		service.shutdown();
	}

	public static void test(IntGenerator generator) {
		test(generator, 10);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println("This val " + val + " is not even "
						+ Thread.currentThread().getName() + "=>÷’÷π");
				generator.cancel();
			} else {
				System.out.println(Thread.currentThread().getName() + "=>‘À––÷–");
			}
		}
	}

}
