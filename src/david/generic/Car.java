package david.generic;

public abstract class Car {

	protected String name;
	protected double speed;

	public Car() {
		// TODO Auto-generated constructor stub
		this.name = "";
		this.speed = 0;
	}

	public Car(String name, double speed) {
		this.name = name;
		this.speed = speed;
	}

	protected void showCarBrand() {
		System.out.println("This is a car");
	};

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{name: %s, speed: %s}", name,
				String.valueOf(speed));
	}
}

class Benz extends Car {

	public Benz() {
		// TODO Auto-generated constructor stub
	}

	public Benz(String name, double speed) {
		// TODO Auto-generated constructor stub
		super(name, speed);
	}

	@Override
	protected void showCarBrand() {
		// TODO Auto-generated method stub
		System.out.println(String.format(
				"This is a Benz car => { name: %s, speed:%s }", name,
				String.valueOf(speed)));
	}
}

class Cadillac extends Car {

	public Cadillac() {
		// TODO Auto-generated constructor stub
	}

	public Cadillac(String name, double speed) {
		// TODO Auto-generated constructor stub
		super(name, speed);
	}

	@Override
	protected void showCarBrand() {
		// TODO Auto-generated method stub
		System.out.println(String.format(
				"This is a Cadillac car => { name: %s, speed:%s }", name,
				String.valueOf(speed)));
	}
}

class Ford extends Car {

	public Ford() {
		// TODO Auto-generated constructor stub
	}

	public Ford(String name, double speed) {
		// TODO Auto-generated constructor stub
		super(name, speed);
	}

	@Override
	protected void showCarBrand() {
		// TODO Auto-generated method stub
		System.out.println(String.format(
				"This is a Ford  car => { name: %s, speed:%s }", name,
				String.valueOf(speed)));
	}
}