package david.thread;

import java.util.concurrent.ThreadFactory;

public class MyUncaughtExceptionFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
	// TODO Auto-generated method stub
	System.out.println(this + " ������һ���µ��߳�");
	Thread thread = new Thread(r);
	thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
	System.out
		.println("��ȡ�����߳��ڲ��쳣��" + thread.getUncaughtExceptionHandler());
	return thread;
    }

}
