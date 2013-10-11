package david.javalearning;

public class Meeting {

	public static void main(String[] args) {
		Father f = new Child();
		System.out.println(f.x);
	}
}

class Father {
	int x = 10;

	public Father() {
		add(20);
	}

	public void add(int y) {
		System.out.println("Father");
		x += y;
	}
}

class Child extends Father {
	int x = 9;
	
	public Child() {
		// TODO Auto-generated constructor stub
		add(30);
	}

	public void add(int y) {
		System.out.println("Child");
		x += y;
		System.out.println(x + ":  :" + y);
	}
}
