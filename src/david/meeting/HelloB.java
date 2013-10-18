package david.meeting;

public class HelloB extends HelloA {
	public HelloB() {
		// TODO Auto-generated constructor stub
		System.out.println("HelloB");
	}

	{
		System.out.println("I'm class B");
	}

	static {
		System.out.println("static B");
	}
}
