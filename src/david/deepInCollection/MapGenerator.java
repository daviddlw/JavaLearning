package david.deepInCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapGenerator {

    private Random rand = new Random();
    private char[] characters = "ABCDEFGHIJKLMNOQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
	    .toCharArray();
    private Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
    private Map<String, String> map = new HashMap<String, String>();

    public Map<String, String> generateRandomMapData(int size) {
	for (int i = 0; i < size; i++) {
	    String key = size == 0 ? String.valueOf(characters[rand
		    .nextInt(characters.length)])
		    : String.valueOf(characters[Math.abs(rand.nextInt(size)) % characters.length])
			    + String.valueOf(characters[rand
				    .nextInt(characters.length)]);

	    String value = size == 0 ? String.valueOf(numbers[rand
		    .nextInt(numbers.length)]) : String.valueOf(numbers[Math
		    .abs(rand.nextInt(size)) % numbers.length])
		    + String.valueOf(numbers[rand.nextInt(numbers.length)]);

	    map.put(key, value);
	}

	return map;
    }
}
