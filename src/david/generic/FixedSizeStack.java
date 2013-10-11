package david.generic;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeStack<T> {
	private List<T> ls;
	private int index = 0;

	public FixedSizeStack() {
		ls = new ArrayList<T>();
	}

	public void push(T item) {
		ls.add(item);
		index++;
	}

	public T pop() {
		return index > 0 ? ls.get(--index) : null;
	}
}
