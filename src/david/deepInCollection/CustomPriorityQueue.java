package david.deepInCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class CustomPriorityQueue<T> {
	PriorityQueue<T> priorityQueue = new PriorityQueue<T>();
	private T item;

	public void add(T item) {
		this.item = item;
		priorityQueue.offer(item);
	}

	public void addAll(Collection<? extends T> collections) {
		for (T t : collections) {
			add(t);
		}
	}

	public boolean remove() {
		if (priorityQueue.isEmpty())
			return false;

		priorityQueue.remove();
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<String>();
		while (!priorityQueue.isEmpty()) {
			ls.add(priorityQueue.poll().toString());
		}

		return ls.toString();
	}
}
