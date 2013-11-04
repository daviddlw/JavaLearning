package david.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
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
}
