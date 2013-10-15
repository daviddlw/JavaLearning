package david.generic;

public class CoffeeBasic {

	public void coffeeAbility() {
	};

	public void set(String name) {
	};

	public String get() {
		return "";
	};
}

class CoffeeImp extends CoffeeBasic {
	private CoffeeBasic cb;
	private String name;

	public CoffeeImp(CoffeeBasic cb) {
		// TODO Auto-generated constructor stub
		this.cb = cb;
	}

	@Override
	public void coffeeAbility() {
		// TODO Auto-generated method stub
		System.out.println(cb.get() + " can drink coffee");
	}

	@Override
	public void set(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return name;
	}
}

class MilkImp extends CoffeeImp {
	private String milkString;

	public MilkImp(CoffeeBasic cb) {
		// TODO Auto-generated constructor stub
		super(cb);
		milkString = "I also can drink milk";
	}

	public void milkAbility() {
		System.out.println(milkString);
	}
}

class CholocateImp extends CoffeeImp {
	private String colocalteString;

	public CholocateImp(CoffeeBasic cb) {
		// TODO Auto-generated constructor stub
		super(cb);
		colocalteString = "I also can drink cholocate";
	}

	public void cholocateAbility() {
		System.out.println(colocalteString);
	}
}

class SugarImp extends CoffeeImp {
	private String sugarString;

	public SugarImp(CoffeeBasic cb) {
		// TODO Auto-generated constructor stub
		super(cb);
		sugarString = "I also can drink sugar";
	}

	public void sugarAbility() {
		System.out.println(sugarString);
	}
}
