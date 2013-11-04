package david.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.sound.midi.MidiChannel;

public class Algorithm {

    /*
     * �������⣬Fibonacci��������Ϊ���ã������ã�������-Fibonacci���У���0����������Ϊ1��
     */
    public static void rabbitAlgorithm() {
	System.out.print("�����뵽����·���: ");
	String s = new Scanner(System.in).nextLine();
	if (Pattern.matches("\\d+", s)) {
	    int month = Integer.parseInt(s);
	    for (int i = 0; i < month; i++) {
		System.out.println(String.format("��ǰ��%d���£���������%dֻ", i, fib(i)));
	    }
	} else {
	    System.err.println("������ֵ");
	}
    }

    /*
     * �ж�����demo
     */
    public static void isPrimeNumberDemo() {
	System.out.print("����Ҫ�жϵ���ֵ: ");
	String s = new Scanner(System.in).nextLine();
	if (Pattern.matches("\\d+", s)) {
	    int num = Integer.parseInt(s);
	    System.out.println(isPrimeNumber(num) ? "��" : "��");
	} else {
	    System.err.println("������ֵ");
	}
    }

    /*
     * Fibonacci��������
     */
    private static int fib(int n) {
	if (n < 2)
	    return 1;
	else
	    return fib(n - 2) + fib(n - 1);
    }

    /*
     * �ж�һ�����Ƿ�����������2������n����������ܱ�2����������������֮���ǣ�
     */
    public static boolean isPrimeNumber(int num) {
	double sqrtnum = Math.sqrt(Double.valueOf(String.valueOf(num)));
	for (int i = 2; i <= sqrtnum; i++) {
	    if (num % i == 0)
		return false;
	}

	return true;
    }

    /*
     * 123 �ҳ�����3λ����ˮ�ɻ���
     */
    public static void isDaffodilsNumber() {
	int a = 0, b = 0, c = 0;
	for (int i = 100; i < 1000; i++) {
	    a = i / 100;
	    b = (i / 10) % 10;
	    c = i % 10;
	    boolean flag = Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) == i;
	    if (flag) {
		System.out.println(i);
	    }
	}
    }

    /*
     * �ֽ�����ʽ����һ�����ֽ�������ĳ˻���
     */
    public static void divideToPrimeNumbers() {
	int num = Integer.parseInt(new Scanner(System.in).nextLine());
	List<Integer> resultLs = new ArrayList<Integer>();
	int i = 2;
	while (i <= num) {
	    if (num == i) {
		resultLs.add(i);
		break;
	    } else if (num % i == 0) {
		resultLs.add(i);
		num = num / i;
	    } else {
		i++;
	    }
	}

	Integer[] ls = new Integer[resultLs.size()];
	resultLs.toArray(ls);
	System.out.println(Arrays.toString(ls));
    }

    public static void calculateMutipleAndDivideDemo() {
	System.out.println("��������ֵ1��");
	@SuppressWarnings("resource")
	int big = Integer.parseInt(new Scanner(System.in).nextLine());
	System.out.println("��������ֵ2��");
	@SuppressWarnings("resource")
	int small = Integer.parseInt(new Scanner(System.in).nextLine());

	calculateMutipleAndDivide(big, small);
    }

    /*
     * ����һ��������С��Լ������󹫱���������֮���������Լ����
     */
    public static void calculateMutipleAndDivide(int a, int b) {
	if (a <= 0 || b <= 0) {
	    System.out.println("��ǰ�������a&b���з���Ȼ��");
	    return;
	}

	int temp = 0, result = 0, big = a, small = b;
	// ��������С������ͬ
	if (big < small) {
	    temp = big;
	    big = small;
	    small = temp;
	}

	while (small > 0) {
	    if (big == small)
		break;
	    result = big % small;
	    big = small;
	    small = result;
	}

	System.out.println("���Լ��Ϊ��" + big);
	System.out.println("��С������Ϊ��" + (a * b) / big);
    }

    public static void calculateStringsDemo() {
	String s = new Scanner(System.in).nextLine();
	calculateStrings(s);
    }

    /*
     * ���㵱ǰ�ַ����У�Ӣ���ַ����ո��ַ����ֺ������ַ��ĸ����������������ʹ��ascii���б�ʽ��
     */
    public static void calculateStrings(String sourceStr) {
	char[] chars = sourceStr.toCharArray();
	Pattern cPattern = Pattern.compile("[A-Za-z]+"); // Ӣ����ĸ
	Pattern nPattern = Pattern.compile("\\d+"); // ������
	Pattern sPattern = Pattern.compile("\\s+"); // �ո��
	int cCount = 0, nCount = 0, sCount = 0, oCount = 0;

	for (char c : chars) {
	    if (cPattern.matcher(String.valueOf(c)).matches()) {
		cCount++;
	    } else if (nPattern.matcher(String.valueOf(c)).matches()) {
		nCount++;
	    } else if (sPattern.matcher(String.valueOf(c)).matches()) {
		sCount++;
	    } else {
		oCount++;
	    }
	}

	System.out.println(String.format(
		"��������ַ���=> Ӣ����ĸ�У�%d, ���֣�%d, �ո����%d, �����ַ���%d", cCount, nCount,
		sCount, oCount));
    }

    public static void sumSpecialNumbersDemo(int baseNum, int count) {
	// System.out.println(sumSpecialNumbers(baseNum, count));
	System.out.println(sumSpecialNumbers2(baseNum, count));
    }

    /*
     * ������ֵa+aa+aaa+aaaa+aaaaa
     */
    public static double sumSpecialNumbers(int baseNum, int count) {
	double total = 0;
	double temp = 0;

	for (int i = 0; i < count; i++) {
	    for (int j = 0; j <= i; j++) {
		temp += (baseNum * Math.pow(10, j));
	    }
	    total += temp;
	    temp = 0;
	}

	return total;
    }

    public static double sumSpecialNumbers2(int baseNum, int count) {

	double total = 0;
	int i = 0, temp = 0;
	while (i < count) {
	    temp += baseNum;
	    total += temp;
	    baseNum = baseNum * 10;
	    i++;
	}

	return total;
    }

    /*
     * 1,2,3,4����ɶ��ٸ�������ͬ���ظ���3λ��������������ǣ���������O(n^3)��
     */
    public static void combineDiffNumbers() {
	List<Integer> ls = new ArrayList<Integer>();
	for (int i = 1; i <= 4; i++) {
	    for (int j = 1; j <= 4; j++) {
		for (int k = 1; k <= 4; k++) {
		    if (i != j && j != k && k != i) {
			ls.add(i * 100 + j * 10 + k);
		    }
		}
	    }
	}
	System.out.println("����" + ls.size() + "������");
	System.out.println(ls);
    }

    /*
     * �������XYZ
     */
    public static void sortXYZ() {
	int[] arrays = new int[3];
	System.out.println("��������ֵx��");
	int x = Integer.parseInt(new Scanner(System.in).nextLine());
	System.out.println("��������ֵy��");
	int y = Integer.parseInt(new Scanner(System.in).nextLine());
	System.out.println("��������ֵz��");
	int z = Integer.parseInt(new Scanner(System.in).nextLine());
	
	arrays[0] = x;
	arrays[1] = y;
	arrays[2] = z;
	Arrays.sort(arrays);
	System.out.println(Arrays.toString(arrays));
    }   

    /*
     * �жϵ�ǰ�����ǵڼ���
     */
    public static void judgeDaysDemo() {
	Calendar c = Calendar.getInstance();
	c.set(2013, 1, 1);
	judgeDays(c);
    }

    /*
     * �жϵ�ǰ�����ǵڼ���
     */
    public static void judgeDays(Calendar date) {
	System.out.println(date.get(date.DAY_OF_YEAR));
    }

    /*
     * һ��������������100������һ����ȫƽ�������ڼ���168������һ����ȫƽ������������������Ƕ��٣�
     */
    public static void guessNumber() {
	List<Integer> ls = new ArrayList<Integer>();
	for (int i = 0; i < 100000; i++) {
	    if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 268) % 1 == 0) {
		ls.add(i);
	    }
	}

	System.out.println(ls);
    }

    /*
     * �����б�
     */
    public static void quickSortDemo() {
	int[] array = new int[] { 4, 3, 1, 5, 2 };
	System.out.println(Arrays.toString(array));
	Algorithm.quickSort(array, 0, array.length - 1);
	System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] list, int low, int high) {
	if (low < high) {
	    int middle = getPrivotNum(list, low, high);
	    quickSort(list, 0, middle - 1);
	    quickSort(list, middle + 1, high);
	}
    }

    /*
     * ��ȡ���ĵ�
     */
    private static int getPrivotNum(int[] list, int low, int high) {
	int key = list[low]; // ��һ��Ϊ��ʼ��λ

	while (low <= high) {
	    // �ҵ��а벿�ִ�������
	    while (low <= high && list[high] >= key) {
		high--;
	    }

	    if (low < high) {
		int temp = list[low];
		list[low] = list[high];
		list[high] = temp;
	    }

	    // �ҵ���߲���С������
	    while (low <= high && list[low] <= key) {
		low++;
	    }

	    if (low < high) {
		int temp = list[low];
		list[low] = list[high];
		list[high] = temp;
	    }
	}

	list[low] = key;
	return low;
    }
}
