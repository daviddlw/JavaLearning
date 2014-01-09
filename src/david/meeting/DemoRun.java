package david.meeting;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

public class DemoRun {
	
	public static String reverse(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

	public static boolean compareTwoNumbers(int a, int b) {
		return a > b;
	}

	/*
	 * 关于equals的特殊注意事项
	 */
	public static void testEqualMethods() {
		String a = "aa";
		String b = "aa";
		String aa = new String("aa");
		String bb = new String("aa");
		int c = 2;
		int d = 2;
		Integer e = 2; // Integer 对于-128~127之间的数值是从cache中获取的其他范围数值是new
						// Integer()产生的
		Integer f = 2;
		Integer g = 200;
		Integer h = 200;
		System.out.println("aa == aa? => " + (a == b));
		System.out.println("new String(aa) == new String(aa)? => " + (aa == bb));
		System.out.println("aa equals aa? => " + aa.equals(bb));
		System.out.println("int 2 == int 2? => " + (c == d));
		System.out.println("Integer 2 == Integer 2? => " + (e == f));
		System.out.println("Integer 200 == Integer 200? => " + (g == h));
	}

	/*
	 * 使用ClassLoader或者Class.forName加载类的方式
	 */
	public static void testClassForName(String className, boolean isClassLoader) {
		if (isClassLoader) {
			try {
				Class<?> StringClass = ClassLoader.getSystemClassLoader().loadClass(className);
				try {
					String testStrClassLoader = (String) StringClass.newInstance();
					testStrClassLoader = "testStrClassLoader";
					System.out.println(testStrClassLoader);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Class<?> StringClass;
			try {
				StringClass = Class.forName(className);
				String testStrClassForName;
				try {
					testStrClassForName = (String) StringClass.newInstance();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				testStrClassForName = "testStrClassForName";
				System.out.println(testStrClassForName);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void reflectDemo() {
		Calendar birth = Calendar.getInstance();
		birth.set(1988, 0, 10);
		Person person = new Person(1, "david.dai", "上海市", "13088888888", birth);
		System.out.println(person);
		try {
			reflectObject(person);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * 反射和C#中的操作方式类似只是C#中可以直接通过属性来反射而java中需要通过javabean中定义的一套get方法invoke得到相应值
	 */
	private static void reflectObject(Person person) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
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
	 * 计算阶乘之和
	 */
	public static double sumFactorial(int num) {
		double total = 0;
		for (int i = 1; i <= num; i++) {
			total += factorial(i);
		}
		return total;
	}

	/*
	 * 阶乘
	 */
	public static double factorial(int num) {
		double result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}

	/*
	 * 阶乘2递归
	 */
	public static double factorial2(int num) {
		if (num > 0) {
			return num * factorial2(--num);
		} else {
			return 1;
		}
	}

	public static void fileOperations(String sourceStr) {
		byte[] bytes = sourceStr.getBytes();
		String path = "destination.txt";
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));			
			out.write(bytes);
			out.flush();
			out.close();
			System.out.println("写文件成功...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
