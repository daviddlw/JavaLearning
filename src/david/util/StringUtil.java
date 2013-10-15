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
	 * 将Object对象转化为int值
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
	 * 将Object对象转化为double值
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
	 * 将Object对象转化为double值
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
	 * 根据指定分隔符来分割字符串
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
	 * 数字转26进制（AA，EXCEL用）
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
	 * 转换Object[]数组为List<T>列表
	 */
	public static <T> List<T> transformList(Object[] objArr) {
		@SuppressWarnings("unchecked")
		List<T> ls = (List<T>) Arrays.asList(objArr);
		return new ArrayList<T>(ls);
	}

	/*
	 * 没有括号或者成对括号返回true,例如()[],反之如([)]则是false
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
