package david.thread;

import java.security.interfaces.RSAKey;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadFibonacci implements Runnable {
	private String name;
	private int num = 0;
	private int result = 0;
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private Object lock = new Object();

	public ThreadFibonacci() {
		// TODO Auto-generated constructor stub
	}

	public ThreadFibonacci(int num) {
		// TODO Auto-generated constructor stub
		this.num = num;
	}

	public ThreadFibonacci(String name, int num) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.num = num;
	}

	public void setN(int n) {
		this.num = n;
	}

	public synchronized int fib(int n) {
		if (n < 2)
			return 1;
		else
			return fib(n - 2) + fib(n - 1);
	}

	/*
	 * 返回fibonacci函数结果
	 */
	public int result() {
		return result;
	}

	public String threadName() {
		return name;
	}

	public ConcurrentLinkedQueue<Integer> getFibList() {
		return queue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		result = fib(num);
		synchronized (lock) {
			queue.add(result);
		}
	}
}
