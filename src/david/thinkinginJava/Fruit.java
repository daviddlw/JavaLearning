package david.thinkinginJava;

public abstract class Fruit {

	public class AppleException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public class PearException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public class BananaException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public abstract void freshEat() throws AppleException, PearException,
			BananaException;
}
