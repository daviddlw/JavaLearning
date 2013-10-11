package david.thinkinginJava;

import java.awt.List;
import java.awt.geom.FlatteningPathIterator;
import java.util.Arrays;

class ClassParameter<T> {
    public T[] func(T[] args) {
	return args;
    }
}

class MethodParameter {
    public static <T> T[] func(T[] args) {
	return args;
    }
}

public class ParameterlizedArrayType {

    public ParameterlizedArrayType() {
	// TODO Auto-generated constructor stub
    }

    public static void showParamterlizedDemo() {
	Integer[] ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Double[] doubles = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9 };
	Integer[] ints2 = new ClassParameter<Integer>().func(ints);
	Double[] doubles2 = new ClassParameter<Double>().func(doubles);
	System.out.println(Arrays.deepToString(ints2));
	System.out.println(Arrays.deepToString(doubles2));
	System.out.println("--------------华丽的分割线--------------");
	Integer[] ints3 = MethodParameter.func(ints);
	Double[] doubles3 = MethodParameter.func(doubles);
	System.out.println(Arrays.deepToString(ints3));
	System.out.println(Arrays.deepToString(doubles3));
    }

    public static void fillArray() {
	int size = 10;
	boolean[] booleanArray = new boolean[size];
	int[] intArray = new int[size];
	double[] doubleArray = new double[size];
	float[] floatArray = new float[size];
	char[] charArray = new char[size];
	short[] shortArray = new short[size];
	String[] strArray = new String[size];

	Arrays.fill(booleanArray, true);
	Arrays.fill(intArray, 88);
	Arrays.fill(doubleArray, 123.1);
	Arrays.fill(floatArray, 123.0f);
	Arrays.fill(charArray, 'a');
	Arrays.fill(shortArray, (short) 99);
	Arrays.fill(strArray, "hello world");

	System.out.println(Arrays.toString(booleanArray));
	System.out.println(Arrays.toString(intArray));
	System.out.println(Arrays.toString(doubleArray));
	System.out.println(Arrays.toString(floatArray));
	System.out.println(Arrays.toString(charArray));
	System.out.println(Arrays.toString(shortArray));
	System.out.println(Arrays.toString(strArray));
    }

    /*
     * 生成泛型数组
     */
    public static <T> T[] arrayOfGenerics(int size) {
	T[] array;
	array = (T[]) new Object[size];
	return array;
    }
}
