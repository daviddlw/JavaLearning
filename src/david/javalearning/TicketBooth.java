package david.javalearning;

public class TicketBooth extends Thread {

    private static int threadId = 0;
    private Reservior reservior;
    private int totalCount;
    
    /*
     * 初始化售票亭的时候启动线程
     */
    public TicketBooth(Reservior r) {
	super(String.format("Thread Id: %s", ++threadId));
	this.reservior = r;
	this.start();
    }
    
    public String toString() {
	return super.getName();
    }
    
    public void run() {
	while (true) {
	    if(this.reservior.sellTickets()){
		this.totalCount = this.totalCount + 1;
		System.out.println(String.format("%s sell 1 ticket.", this.getName()));
		try {
		    sleep((int)Math.random()*100);
		} catch (InterruptedException e) {
		   throw new RuntimeException("当前线程被打断！");
		}
	    } else {
		break;
	    }
	}
	System.out.println(String.format("%s共卖了%d张票", this.getName(), this.totalCount));
    }
}
