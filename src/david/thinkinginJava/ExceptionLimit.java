package david.thinkinginJava;

import david.thinkinginJava.Fruit.AppleException;
import david.thinkinginJava.Fruit.BananaException;
import david.thinkinginJava.Fruit.PearException;

public class ExceptionLimit {
	public static void showExceptionLimitDemo() {
		try {
			Fruit apple = new Apple();
			Fruit pear = new Pear();
			Fruit banana = new Banana();

			apple.freshEat();
			pear.freshEat();
			banana.freshEat();

		} catch (AppleException e) {
			e.printStackTrace();
			return;
		} catch (PearException e) {
			e.printStackTrace();
			return;
		} catch (BananaException e) {
			e.printStackTrace();
			return;
		}
	}
}
