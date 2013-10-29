package david.thread;

public class BasicThread implements Runnable {
    protected int threadCount = 10;
    private static int id = 0;
    private String taskName = "";

    public BasicThread() {
	// TODO Auto-generated constructor stub
	id++;
    }

    public BasicThread(String name) {
	// TODO Auto-generated constructor stub
	id++;
	taskName = name;
    }

    public BasicThread(int threadCount) {
	this.threadCount = threadCount;
	id++;
    }

    public String status() {
	return threadCount > 0 ? String.format(
		"[id=>%d, taskName=>%s, threadCount=>%d]", id, taskName,
		threadCount) : String.format("[taskName=>%s, game over]\n",
		taskName);
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub
	while (threadCount-- > 0) {
	    System.out.print(status());
	    Thread.yield(); // ÇÐ»»Ïß³Ì
	}
    }
}
