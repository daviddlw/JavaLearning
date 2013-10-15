package david.deepInCollection;

import java.util.Random;

public class RandomGen {
    private int size;
    private static String alphStrings = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static char[] characters = alphStrings.toCharArray();
    private static Random rand = new Random();

    public RandomGen(int size) {
	// TODO Auto-generated constructor stub
	this.size = size;
    }

    public Generator<String> getString() {

	return new Generator<String>() {

	    @Override
	    public String next() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
		    sb.append(characters[rand.nextInt(characters.length)]);
		}
		return sb.toString();
	    }
	};

    }

    public static Generator<Integer> getInteger() {
	return new Generator<Integer>() {

	    @Override
	    public Integer next() {
		// TODO Auto-generated method stub
		return rand.nextInt(10000);
	    }
	};
    }

}
