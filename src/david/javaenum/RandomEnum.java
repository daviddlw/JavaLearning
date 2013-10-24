package david.javaenum;

import java.util.Random;

public class RandomEnum {
	private static Random rand = new Random();

	public static <T extends Enum<T>> T random(Class<T> enumClass) {
		return random(enumClass.getEnumConstants());
	}

	private static <T> T random(T[] enums) {
		return enums[rand.nextInt(enums.length)];
	}
}
