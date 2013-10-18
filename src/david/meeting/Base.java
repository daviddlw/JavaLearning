package david.meeting;

public class Base {
	private String name = "base";	

	public Base() {
		// TODO Auto-generated constructor stub
		tellName();
		printName();
	}

	public void tellName() {	
		System.out.println("Base tell name " + name);
	}

	public void printName() {
		System.out.println("Base print name " + name);
	}
}
