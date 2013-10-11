package david.thinkinginJava;

public class InheritingException {
    public void fun() throws SimpleException {
	System.out.println("Throw SimpleException from fun()");
	throw new SimpleException();
    }
}
