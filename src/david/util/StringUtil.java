package david.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StringUtil {

	public StringUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printSplitLines() {
		System.out.println("----------------------");
	}

	/*
	 * ��Object����ת��Ϊintֵ
	 */
	public static int toInt(Object obj) {
		if (obj == null)
			return 0;
		String objStr = obj.toString();

		if (objStr.matches("\\d+")) {
			return Integer.parseInt(objStr);
		} else {
			return 0;
		}
	}

	/*
	 * ��Object����ת��Ϊdoubleֵ
	 */
	public static double toDouble(Object obj) {
		if (obj == null)
			return 0;
		String objStr = obj.toString();
		try {
			Double doubleVal = new Double(objStr);
			if (doubleVal.isNaN()) {
				return 0;
			} else {
				return doubleVal.doubleValue();
			}
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/*
	 * ��Object����ת��Ϊdoubleֵ
	 */
	public static float toFloat(Object obj) {
		if (obj == null)
			return 0;
		String objStr = obj.toString();
		try {
			Float floatVal = new Float(objStr);
			if (floatVal.isNaN()) {
				return 0;
			} else {
				return floatVal.floatValue();
			}
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/*
	 * ����ָ���ָ������ָ��ַ���
	 */
	public static String[] toSpilitArray(String sourceStr, String splitWord) {
		if (sourceStr.isEmpty())
			return new String[] {};

		if (sourceStr.contains(splitWord)) {
			return sourceStr.split(splitWord);
		} else {
			return new String[] { sourceStr };
		}
	}

	/*
	 * ����ת26���ƣ�AA��EXCEL�ã�
	 */
	public static String Hex26ToString(int num) {
		Stack<Character> ls = new Stack<Character>();
		do {
			int result = num % 26;
			if (result == 0)
				result = 26;
			num = (num - result) / 26;
			ls.add((char) (result + 64));
		} while (num > 0);

		StringBuilder sb = new StringBuilder();
		while (!ls.empty()) {
			sb.append(ls.pop());
		}

		return sb.toString();
	}

	/*
	 * ת��Object[]����ΪList<T>�б�
	 */
	public static <T> List<T> transformList(Object[] objArr) {
		@SuppressWarnings("unchecked")
		List<T> ls = (List<T>) Arrays.asList(objArr);
		return new ArrayList<T>(ls);
	}

	/*
	 * û�����Ż��߳ɶ����ŷ���true,����()[],��֮��([)]����false
	 */
	public static boolean checkIsBracketsTwining(String sourceString) {

		Stack<Character> stack = new Stack<Character>();
		boolean isValid = true;
		for (Character c : sourceString.toCharArray()) {
			boolean flag = (!stack.isEmpty() && stack.peek() == '(' && c == ')')
					|| (!stack.isEmpty() && stack.peek() == '[' && c == ')');
			if (flag) {
				isValid = true;
				stack.pop();
			} else {
				stack.push(c);
				isValid = !((c == '(' || c == ')') || (c == '[' || c == ']'));
			}
		}

		return isValid;
	}
}
