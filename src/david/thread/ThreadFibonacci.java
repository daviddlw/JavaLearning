package david.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadFibonacci implements Runnable {
    private String name;
    private int num = 0;
    private int result = 0;
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    private static Set<Integer> set = new TreeSet<Integer>();
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

    public int fib(int n) {
	Thread.yield();
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

    public void getFibList() {
	System.out.println(set);
	System.out.println(set.size());
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub
	result = fib(num);
	synchronized (lock) {
	    set.add(result);
	}
    }
}
