package david.thinkinginJava;

public class CustomException extends Exception {
    
    private int index;
    
    public CustomException() {
	// TODO Auto-generated constructor stub
    }
    
    public CustomException(String msg) {
	// TODO Auto-generated constructor stub
	super(msg);
    }
    
    public CustomException(String msg, int index) {
	// TODO Auto-generated constructor stub
	super(msg);
	this.index = index;
    }
    
    public int val(){
	return index;
    }
    
    public String getMessage(){
	return "Override Message " + index + " " + super.getMessage();
    }
    
}
