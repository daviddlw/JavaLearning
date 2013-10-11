package david.thinkinginJava;

public class QueueCommand {
    private String queryString = "";

    public QueueCommand() {
	// TODO Auto-generated constructor stub
    }

    public QueueCommand(String name) {
	this.queryString = name;
    }
    
    public void diplay() {
	System.out.println(queryString);
    }
}
