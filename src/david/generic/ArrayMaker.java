package david.generic;

import java.lang.reflect.Array;

public class ArrayMaker<T> {
	private Class<T> type;

	public ArrayMaker() {
		// TODO Auto-generated constructor stub
	}

	public ArrayMaker(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public T[] create(int size) {
		return (T[]) Array.newInstance(type, size);
	}
}
