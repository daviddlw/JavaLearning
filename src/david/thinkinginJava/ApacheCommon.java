package david.thinkinginJava;

import org.apache.commons.lang3.*;

public class ApacheCommon<T> {

	public T[] mergeArrays(T[] sourceOne, T[] sourceTwo) {
		T[] resultArray = (T[]) ArrayUtils.addAll(sourceOne, sourceTwo);
		return resultArray;
	}
}
