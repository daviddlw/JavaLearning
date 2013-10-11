package david.deepInCollection;

import java.util.Arrays;
import java.util.Queue;

public class QueueBehavior {
	public <T> void testQueue(Queue<T> queue, Generator<T> gen) {
		for (int i = 0; i < 8; i++) {
			queue.offer(gen.next());
		}
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
}

class NumberGen implements Generator<String> {
	private Object[] numberStings = Arrays.asList("one", "two", "three",
			"four", "five", "six", "seven", "eight").toArray();
	private int index;

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return String.valueOf(numberStings[index++]);
	}
}
