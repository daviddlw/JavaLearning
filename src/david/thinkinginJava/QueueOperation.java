package david.thinkinginJava;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOperation {

    private Queue<QueueCommand> queueLs = new LinkedList<QueueCommand>();

    public QueueOperation() {
	// TODO Auto-generated constructor stub
    }

    public void fillQueue(QueueCommand qc) {
	queueLs.add(qc);
    }
    
    public Queue<QueueCommand> getQueue() {
	return queueLs;
    }
}
