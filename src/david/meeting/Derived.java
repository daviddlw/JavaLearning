package david.meeting;

public class Derived extends Base {
	private String name = "derived";
	private int id = 1;

	public Derived() {
		// TODO Auto-generated constructor stub
		tellName();
		printName();
	}

	public void tellName() {
		System.out.println("Derived tell name " + name + " " + id);
	}

	public void printName() {
		System.out.println("Derived print name " + name + " " + id);
	}
}
