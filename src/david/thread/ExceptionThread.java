package david.thread;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
	// TODO Auto-generated method stub
	throw new RuntimeException("test exception thread");
    }

}
