package david.javalearning;

public class TicketBooth extends Thread {

    private static int threadId = 0;
    private Reservior reservior;
    private int totalCount;
    
    /*
     * ��ʼ����Ʊͤ��ʱ�������߳�
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
		   throw new RuntimeException("��ǰ�̱߳���ϣ�");
		}
	    } else {
		break;
	    }
	}
	System.out.println(String.format("%s������%d��Ʊ", this.getName(), this.totalCount));
    }
}
