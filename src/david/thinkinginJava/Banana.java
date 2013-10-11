package david.thinkinginJava;

public class Banana extends Fruit {

	@Override
	public void freshEat() throws AppleException, PearException, BananaException {
		// TODO Auto-generated method stub
		throw new BananaException();
	}

}
