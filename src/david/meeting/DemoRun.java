package david.meeting;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import javax.swing.text.AbstractDocument.BranchElement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

public class DemoRun {

	public static boolean compareTwoNumbers(int a, int b) {
		return a > b;
	}

	public static void reflectDemo() {
		Calendar birth = Calendar.getInstance();
		birth.set(1988, 0, 10);
		Person person = new Person(1, "david.dai", "�Ϻ���", "13088888888", birth);
		System.out.println(person);
		try {
			reflectObject(person);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * �����C#�еĲ�����ʽ����ֻ��C#�п���ֱ��ͨ�������������java����Ҫͨ��javabean�ж����һ��get����invoke�õ���Ӧֵ
	 */
	private static void reflectObject(Person person) throws SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		StrBuilder sb = new StrBuilder();
		String fname = "", method = "";
		Class<? extends Person> pt = person.getClass();
		for (Field field : pt.getDeclaredFields()) {
			fname = field.getName();
			if (fname.toLowerCase() != "tostring") {
				method = String.format("get%s", StringUtils.capitalize(fname));
				Object value = pt.getMethod(method).invoke(person);
				sb.appendln(fname + " => " + value.toString() + " => " + field.getType());
			}
		}
		System.out.println(sb.toString());
	}

	/*
	 * ����׳�֮��
	 */
	public static double sumFactorial(int num) {
		double total = 0;
		for (int i = 1; i <= num; i++) {
			total += factorial(i);
		}
		return total;
	}

	/*
	 * �׳�
	 */
	public static double factorial(int num) {
		double result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

	/*
	 * �׳�2�ݹ�
	 */
	public static double factorial2(int num) {
		if (num > 0) {
			return num * factorial2(--num);
		} else {
			return 1;
		}
	}
}
