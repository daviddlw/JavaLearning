package david.algorithm;

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
}
