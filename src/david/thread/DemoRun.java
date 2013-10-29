package david.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.time.StopWatch;

public class DemoRun {

    public static void basicThreadRun(RunType type) {
	switch (type) {
	case Run: {
	    BasicThread bt = new BasicThread();
	    bt.run();
	}
	    break;
	case Start: {
	    new Thread(new BasicThread()).start();
	}
	    break;
	case MutipleThread: {
	    for (int i = 0; i < 5; i++) {
		Thread t = new Thread(new BasicThread(String.valueOf("thread"
			+ (i + 1))));
		t.start();
	    }
	}
	    break;
	default:
	    new Thread(new BasicThread()).start();
	    break;
	}

    }

    /*
     * 顺序添加fib数值到某个list
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
	System.out.println("耗时: " + stopWatch.getNanoTime());
    }

    /*
     * 多线程任务跑
     */
    public static void fibByThread() {
	StopWatch stopWatch = new StopWatch();
	stopWatch.start();

	/*
	 * 开10个线程跑
	 */
	ThreadFibonacci tf = null;
	for (int i = 0; i < 30; i++) {
	    tf = new ThreadFibonacci(i);
	    new Thread(tf).start();
	}
	tf.getFibList();

	stopWatch.stop();
	System.out.println("耗时: " + stopWatch.getNanoTime());

    }

    public static void fibonacciFunction() {
	Set<FibModel> treeSet = new TreeSet<FibModel>();
	int i = 0;
	while (i < 29) {
	    // for (int j = 1; j < 5; j++) {
	    // ThreadFibonacci tf = new ThreadFibonacci("线程" + j, i);
	    // new Thread(tf).start();
	    // treeSet.add(new FibModel(tf.threadName(), tf.fib(i)));
	    // i++;
	    // }
	    ThreadFibonacci tf = new ThreadFibonacci("线程" + i, i);
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
