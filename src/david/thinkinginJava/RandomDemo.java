package david.thinkinginJava;

import java.util.Random;

public class RandomDemo {
	public static void randomVal() {
		System.out.println(Math.random());
		Random rd = new Random();
		for (int i = 1; i <= 5; i++) {
			System.out.println(rd.nextInt(47));
		}
	}
}
