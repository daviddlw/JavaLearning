package david.generic;

import java.util.Collection;
import java.util.List;

public class Generators {
    
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n) {
	for (int i = 0; i < n; i++) {
	    collection.add(generator.next());
	}
	
	return collection;
    }
    
    public static <T> List<T> fill(List<T> collection, Generator<T> generator, int n) {
	for (int i = 0; i < n; i++) {
	    collection.add(generator.next());
	}
	
	return collection;
    }
}
