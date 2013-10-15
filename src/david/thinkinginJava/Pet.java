package david.thinkinginJava;

public class Pet {
	private static int counter = 0;
	private final int id = counter++;

	public int id() {
		return id;
	}

	public String name() {
		return String.format("Pet%d", id);
	}
	
	public String toString() {
		return name();
	}
}
