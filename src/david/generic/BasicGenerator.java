package david.generic;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator() {
	// TODO Auto-generated constructor stub
    }

    public BasicGenerator(Class<T> type) {
	this.type = type;
    }

    @Override
    public T next() {
	// TODO Auto-generated method stub
	try {
	    return type.newInstance();
	} catch (Exception e) {
	    // TODO: handle exception
	    throw new RuntimeException();
	}
    }

    public static <T> Generator<T> create(Class<T> type) {
	return new BasicGenerator<T>(type);
    }
}

class CountedObject {
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "CountedObject" + id;
    }
}
