package david.thinkinginJava;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class BerylliumSphere {
    private static int counter;
    private final int id = counter++;

    public String toString() {
	return String.format("Sphere %d", id);
    }
}

public class ArrayDemo {

    public static void showArrayDemo() {
	// TODO Auto-generated constructor stub
	BerylliumSphere[] bSphereArr = new BerylliumSphere[10];
	for (int i = 0; i < 5; i++) {
	    bSphereArr[i] = new BerylliumSphere();
	    // bSphereArr[i].toString();
	}

	// Arrays.toString(bSphereArr);
	System.out.println(bSphereArr[4]);
    }

    public static void arrayOptions() {

	BerylliumSphere[] a;
	BerylliumSphere[] b = new BerylliumSphere[5];
	BerylliumSphere[] c = new BerylliumSphere[4];
	for (int i = 0; i < c.length; i++) {
	    if (c[i] == null) {
		c[i] = new BerylliumSphere();
	    }
	}

	BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(),
		new BerylliumSphere(), new BerylliumSphere() };

	a = Arrays.copyOf(c, c.length);

	System.out.println("a.length " + a.length + ", a=> "
		+ Arrays.toString(a));
	System.out.println("b.length " + b.length + ", b=> "
		+ Arrays.toString(b));
	System.out.println("c.length " + c.length + ", c=> "
		+ Arrays.toString(b));
	System.out.println("d.length " + d.length + ", d=> "
		+ Arrays.toString(d));
    }

    public static void showTwoDimensionArray() {
	int[][] testArray = new int[][] { { 1, 2, 3, 4 }, { 4, 5, 6 },
		{ 7, 8, 9 } };
	System.out.println(Arrays.deepToString(testArray));

	BerylliumSphere[][] test2Array = new BerylliumSphere[][] {
		{ new BerylliumSphere(), new BerylliumSphere(),
			new BerylliumSphere() },
		{ new BerylliumSphere(), new BerylliumSphere() },
		{ new BerylliumSphere() } };
	System.out.println(Arrays.deepToString(test2Array));
    }

    public static void multiplicationTable() {

	int[][] resultArray = new int[9][9];
	for (int i = 0; i < resultArray.length; i++) {
	    for (int j = 0; j < resultArray[i].length; j++) {
		resultArray[i][j] = (i + 1) * (j + 1);

	    }
	    System.out.println(Arrays.toString(resultArray[i]));
	    System.out.println();
	}
    }

    /*
     * Arrays.deepToString Demo
     */
    public static void showIntegerDoubleDemo() {

	Integer[][] intArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
		{ 10, 11, 12 } };

	Double[][] doubleArray = { { 1.1, 2.2, 3.3 }, { 4.4, 5.5, 6.6 },
		{ 7.7, 8.8, 9.9 } };

	System.out.println(String.format("Integer Array => %s",
		Arrays.deepToString(intArray)));

	System.out.println(String.format("Double Array => %s",
		Arrays.deepToString(doubleArray)));
    }

    /*
     * 生成Double数组
     */
    public static double[][] generateDoubleArray(int x, int y) {

	double[][] resultArray = new double[x][y];
	Random rand = new Random();
	for (int i = 0; i < resultArray.length; i++) {
	    for (int j = 0; j < resultArray[i].length; j++) {
		resultArray[i][j] = rand.nextInt(x * y / (i + 1 + j + 1));
	    }
	}

	return resultArray;
    }

    /*
     * 打印数组
     */
    public static void printArray(double[][] sourceArray) {

	for (int i = 0; i < sourceArray.length; i++) {
	    System.out.println(Arrays.toString(sourceArray[i]));
	    System.out.println();
	}
    }

    public static void generateArrays(int x, int y, int z) {

	Random rand = new Random();
	StringBuilder sb = new StringBuilder();

	Double[][][] resultArray = new Double[x][y][z];
	for (int i = 0; i < resultArray.length; i++) {
	    StringBuilder sbBuilder = new StringBuilder("{");
	    String sourceStr = "";
	    for (int j = 0; j < resultArray[i].length; j++) {
		for (int k = 0; k < resultArray[i][j].length; k++) {
		    // resultArray[i][j][k] = rand
		    // .nextInt((x * y / (i + 1 + j + 1)));
		    sb.append(resultArray[i][j][k] + ",");
		}
		sourceStr = sb.toString().substring(0,
			sb.toString().length() - 1);
		System.out.println(sourceStr);
	    }
	    sbBuilder.append(sourceStr);
	    sbBuilder.append("}");
	}
    }

    public static void sortSearchArray(int num) {
	int[] numArray = new int[] { 6, 5, 1, 7, 8, 6, 11, 61 };
	Arrays.sort(numArray);
	System.out.println(String.format("当前数组：%s", Arrays.toString(numArray)));
	System.out.println(Arrays.toString(numArray));
	System.out.println(Arrays.binarySearch(numArray, num));
    }

    public static boolean compareValues(int a, int b) {
	return new Integer(a).equals(b);
    }

    public static void deepEqualsDemo() {
	Integer[] a1 = { 1, 2, 3 };
	Integer[] a2 = { 1, 2, 3 };
	boolean flag = a1.equals(a2);
	boolean flag2 = Arrays.deepEquals(a1, a2);
	System.out.println(flag);
	System.out.println(flag2);
	System.out.println("a1=> " + a1.hashCode());
	System.out.println("a2=> " + a2.hashCode());
    }

    public static void equalsDemo() {

	int[] a1 = { 1, 2, 3 };
	int[] a2 = { 2, 1, 3 };
	int[] a3 = { 1, 2, 4 };
	int[] a4 = { 1, 2, 4 };

	int[] a5 = { 6, 7, 8, 9, 10 };

	int[] newArray = new int[a1.length + a5.length];
	System.arraycopy(a1, 0, newArray, 0, a1.length);
	System.arraycopy(a5, 0, newArray, a1.length, a5.length);

	System.out.println("测试数组如:\n");
	System.out.println("a1 => " + Arrays.toString(a1));
	System.out.println("a2 => " + Arrays.toString(a2));
	System.out.println("a3 => " + Arrays.toString(a3));
	System.out.println("------------------------------");
	System.out.println("a1 与 a2比较结果 =>" + Arrays.equals(a1, a2));
	System.out.println("a1 与 a3比较结果 =>" + Arrays.equals(a1, a3));
	System.out.println("a2 与 a3比较结果 =>" + Arrays.equals(a2, a3));
	System.out.println("a3 与 a4比较结果 =>" + Arrays.equals(a3, a4));

	System.out.println();
	System.out.println("拷贝后的数组 => " + Arrays.toString(newArray));
    }

    public static void tranformFromPython() {
	Integer[] intArrays = { 1, 2, 3, 4, 5 };
	List<Integer> ls = Arrays.asList(intArrays); // 当前转化的List是不能进行扩展的，即不能进行Add,Remove操作
	List<Integer> aList = new ArrayList<Integer>(ls);
	System.out.println(aList.getClass());
	System.out.println(Arrays.toString(aList.toArray()));
	System.out.println(aList.get(4));
	List<Integer> addLs = Arrays.asList(7, 8);
	aList.addAll(addLs);
	System.out.println(Arrays.toString(aList.toArray()));
	List<Integer> subList = aList.subList(2, 4);
	System.out.println(Arrays.toString(subList.toArray()));
	aList.subList(2, 4).clear();
	System.out.println(Arrays.toString(aList.toArray()));
	reverseArray(aList);
	System.out.println("--------------转化列表-------------");
	System.out.println("转换前");
	Integer[] objLs = { 1, 2, 3 };
	System.out.println(objLs.getClass());
	System.out.println("转换后");
	List<Integer> tls = transformList(objLs);
	System.out.println(tls.getClass());
    }

    public static void reverseArray(List<Integer> ls) {
	Object[] resultLs = ls.toArray();
	Arrays.sort(resultLs, Collections.reverseOrder());
	System.out.println(Arrays.toString(resultLs));
    }

    public static <T> List<T> transformList(Object[] objArr) {
	@SuppressWarnings("unchecked")
	List<T> ls = (List<T>) Arrays.asList(objArr);
	return new ArrayList<T>(ls);
    }
}
