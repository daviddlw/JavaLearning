package david.thread;

import java.util.concurrent.Callable;

public class FibFunction implements Callable<Integer> {

	private int num;

	public FibFunction() {
		// TODO Auto-generated constructor stub
	}
	
	public FibFunction(int n) {
		// TODO Auto-generated constructor stub
		num = n;
	}

	public int fib(int n) {
		if (n < 2)
			return 1;
		else
			return fib(n - 2) + fib(n - 1);
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return fib(num);
	}

}
