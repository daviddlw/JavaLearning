package david.javalearning;

public class RecursionDemo {

	private static int total = 0;

	/*
	 * µÝ¹é¼Ó·¨
	 */
	public static int recursionCalculate(int num) {
		if (num <= 0)
			return total;

		total += num;
		num--;
		return recursionCalculate(num);
	}
}

