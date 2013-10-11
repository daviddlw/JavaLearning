package david.thinkinginJava;

public class WhoCalled {

	private static int count = 0;

	public static void first() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			for (StackTraceElement item : e.getStackTrace()) {
				System.out.println(item.getClassName() + ":"
						+ item.getMethodName());
			}
		} finally {
			count++;
			if (count == 2) {
				System.out.println("You can see this special message!");
			}
			System.out.println(String.format("%d =>This is finally!", count));
		}
	}

	public static void firstRuntime() {
		throw new RuntimeException();
	}

	public static void second() {
		first();
		// firstRuntime();
	}

	private static void third() {
		second();
	}

	public static void showDemo() {
		first();
		System.out.println("----------------");
		second();
		System.out.println("----------------");
		third();
	}
}
