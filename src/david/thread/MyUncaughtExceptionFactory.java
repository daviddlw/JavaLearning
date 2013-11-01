package david.thread;

import java.util.concurrent.ThreadFactory;

public class MyUncaughtExceptionFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
	// TODO Auto-generated method stub
	System.out.println(this + " 创建了一个新的线程");
	Thread thread = new Thread(r);
	thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
	System.out
		.println("获取到了线程内部异常：" + thread.getUncaughtExceptionHandler());
	return thread;
    }

}
