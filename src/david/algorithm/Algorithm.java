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
     * 兔子问题，Fibonacci函数（分为成兔，幼年兔，兔总数-Fibonacci数列，第0个月幼年兔为1）
     */
    public static void rabbitAlgorithm() {
	System.out.print("请输入到达的月份数: ");
	String s = new Scanner(System.in).nextLine();
	if (Pattern.matches("\\d+", s)) {
	    int month = Integer.parseInt(s);
	    for (int i = 0; i < month; i++) {
		System.out.println(String.format("当前第%d个月，共有兔子%d只", i, fib(i)));
	    }
	} else {
	    System.err.println("不是数值");
	}
    }

    /*
     * 判断素数demo
     */
    public static void isPrimeNumberDemo() {
	System.out.print("请需要判断的数值: ");
	String s = new Scanner(System.in).nextLine();
	if (Pattern.matches("\\d+", s)) {
	    int num = Integer.parseInt(s);
	    System.out.println(isPrimeNumber(num) ? "是" : "否");
	} else {
	    System.err.println("不是数值");
	}
    }

    /*
     * Fibonacci函数问题
     */
    private static int fib(int n) {
	if (n < 2)
	    return 1;
	else
	    return fib(n - 2) + fib(n - 1);
    }

    /*
     * 判断一个数是否是素数（从2到根号n，如果其中能被2整除则不是素数，反之则是）
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
     * 123 找出所有3位数的水仙花数
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
     * 分解质因式（将一个数分解成质数的乘积）
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
	System.out.println("请输入数值1：");
	@SuppressWarnings("resource")
	int big = Integer.parseInt(new Scanner(System.in).nextLine());
	System.out.println("请输入数值2：");
	@SuppressWarnings("resource")
	int small = Integer.parseInt(new Scanner(System.in).nextLine());

	calculateMutipleAndDivide(big, small);
    }

    /*
     * 计算一个数的最小公约数，最大公倍数（两数之积除以最大公约数）
     */
    public static void calculateMutipleAndDivide(int a, int b) {
	if (a <= 0 || b <= 0) {
	    System.out.println("当前输入的数a&b，有非自然数");
	    return;
	}

	int temp = 0, result = 0, big = a, small = b;
	// 如果最大最小的数相同
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

	System.out.println("最大公约数为：" + big);
	System.out.println("最小公倍数为：" + (a * b) / big);
    }

    public static void calculateStringsDemo() {
	String s = new Scanner(System.in).nextLine();
	calculateStrings(s);
    }

    /*
     * 计算当前字符串中，英文字符，空个字符数字和其他字符的个数（正则或者其他使用ascii码判别方式）
     */
    public static void calculateStrings(String sourceStr) {
	char[] chars = sourceStr.toCharArray();
	Pattern cPattern = Pattern.compile("[A-Za-z]+"); // 英文字母
	Pattern nPattern = Pattern.compile("\\d+"); // 数字类
	Pattern sPattern = Pattern.compile("\\s+"); // 空格符
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
		"你输入的字符中=> 英文字母有：%d, 数字：%d, 空格符：%d, 其他字符：%d", cCount, nCount,
		sCount, oCount));
    }

    public static void sumSpecialNumbersDemo(int baseNum, int count) {
	// System.out.println(sumSpecialNumbers(baseNum, count));
	System.out.println(sumSpecialNumbers2(baseNum, count));
    }

    /*
     * 计算数值a+aa+aaa+aaaa+aaaaa
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
     * 1,2,3,4能组成多少个互不相同无重复的3位数，并且输出他们，最坏的情况是O(n^3)方
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
	System.out.println("共有" + ls.size() + "个数字");
	System.out.println(ls);
    }

    /*
     * 排序输出XYZ
     */
    public static void sortXYZ() {
	int[] arrays = new int[3];
	System.out.println("请输入数值x：");
	int x = Integer.parseInt(new Scanner(System.in).nextLine());
	System.out.println("请输入数值y：");
	int y = Integer.parseInt(new Scanner(System.in).nextLine());
	System.out.println("请输入数值z：");
	int z = Integer.parseInt(new Scanner(System.in).nextLine());
	
	arrays[0] = x;
	arrays[1] = y;
	arrays[2] = z;
	Arrays.sort(arrays);
	System.out.println(Arrays.toString(arrays));
    }   

    /*
     * 判断当前日期是第几天
     */
    public static void judgeDaysDemo() {
	Calendar c = Calendar.getInstance();
	c.set(2013, 1, 1);
	judgeDays(c);
    }

    /*
     * 判断当前日期是第几天
     */
    public static void judgeDays(Calendar date) {
	System.out.println(date.get(date.DAY_OF_YEAR));
    }

    /*
     * 一个正整数，加上100后他是一个完全平方数，在加上168后又是一个完全平方数，请问这个数字是多少？
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
     * 快排列表
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
     * 获取中心点
     */
    private static int getPrivotNum(int[] list, int low, int high) {
	int key = list[low]; // 第一个为初始化位

	while (low <= high) {
	    // 找到有半部分大数交换
	    while (low <= high && list[high] >= key) {
		high--;
	    }

	    if (low < high) {
		int temp = list[low];
		list[low] = list[high];
		list[high] = temp;
	    }

	    // 找到左边部分小数交换
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
