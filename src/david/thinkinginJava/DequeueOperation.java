package david.thinkinginJava;

import java.util.Queue;

public class DequeueOperation {

    public DequeueOperation() {
	// TODO Auto-generated constructor stub
    }

    public void dequeueList(Queue<QueueCommand> qcLs) {
	while (!qcLs.isEmpty()) {
	    QueueCommand qc = qcLs.poll();
	    qc.diplay();
	}
    }
}
