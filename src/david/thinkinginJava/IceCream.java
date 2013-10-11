package david.thinkinginJava;

import java.util.Arrays;
import java.util.Random;

public class IceCream {

    private static Random rand = new Random(50);
    private static final String[] FLAVORS = { "Choloate", "Strawberry",
	    "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge",
	    "Rum Raisin", "Praline Cream", "Mud Pie" };

    public IceCream() {
	// TODO Auto-generated constructor stub
    }

    public static void dynamicPickIceCream(int length) {
	if (length > FLAVORS.length) {
	    throw new IllegalArgumentException("参数长度过长，限制为" + FLAVORS.length);
	}

	String[] results = new String[length];
	boolean[] seeds = new boolean[FLAVORS.length];
	int count = 0;
	while (count != length) {
	    int index = rand.nextInt(FLAVORS.length);
	    if (!seeds[index]) {
		results[count] = FLAVORS[index];
		count++;
		seeds[index] = true;
	    }
	}

	System.out.println(Arrays.toString(results));
    }
}
