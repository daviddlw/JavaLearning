package david.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

import david.util.StringUtil;

public class MainFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 testBasicAnnotations();		
	}

	private static void testBasicAnnotations() {
		Class<PasswordUtils> type = PasswordUtils.class;
		Method[] methods = type.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(Arrays.toString(method.getAnnotations()));
			StringUtil.printSplitLines();
			System.out
					.println(Arrays.toString(method.getDeclaredAnnotations()));
		}
		StringUtil.printSplitLines();
		try {
			Method method = type.getDeclaredMethod("validatePassword",
					String.class);
			UseCase usecase = method.getAnnotation(UseCase.class);
			System.out.println("id : " + usecase.id() + " description: "
					+ usecase.description());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
