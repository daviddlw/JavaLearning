package david.thinkinginJava;

public class Man {
    
    private static int count=1;
    private final int id = count++;
    
    public Man() {
	// TODO Auto-generated constructor stub
    }
    
    public int id() {
	return id;
    }
    
}
