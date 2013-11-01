package david.thread;

public class MyUncaughtExceptionHandler implements
	Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
	// TODO Auto-generated method stub
	System.err.println(t.getName() + ": [" + e.getMessage() + "]已经被处理了");
    }

}
