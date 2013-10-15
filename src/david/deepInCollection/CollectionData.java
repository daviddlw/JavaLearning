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
