package david.generic;

import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    
    private ArrayList<T> ls = new ArrayList<T>();
    private Random rand = new Random();
    
    public void add(T item) {
	ls.add(item);
    }
    
    public void addAll(T[] itemLs) {
	for (T t : itemLs) {
	    add(t);
	}
    }
    
    public T select() {
	return ls.get(rand.nextInt(ls.size()));
    }
}
