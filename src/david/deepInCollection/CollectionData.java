package david.deepInCollection;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class CollectionData<T> extends ArrayList<T> {

	public CollectionData(Generator<T> generator, int capacity) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < capacity; i++) {
			add(generator.next());
		}
	}

	public static <T> CollectionData<T> list(Generator<T> generator,
			int capacity) {
		return new CollectionData<T>(generator, capacity);
	}
}

class GovernmentGen implements Generator<String> {
	public String[] foundations = "david has a goal of nosql db".split(" ");
	private int index = 0;

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return foundations[index++];
	}

	public int getLength() {
		return foundations.length;
	}
}

class RandomGen {
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
