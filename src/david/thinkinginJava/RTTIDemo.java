package david.thinkinginJava;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

class Candy {
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Candy");
	}
}

class Toy {
	protected boolean tag = false;

	public Toy() {
		// TODO Auto-generated constructor stub
	}

	public Toy(int i) {
		// System.out.println(i);
	}

	public boolean getTagVal() {
		return tag;
	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoot,
		DavidAdded {
	private int toyCount = 100;
	private String toyName = "测试";

	public FancyToy() {
		// TODO Auto-generated constructor stub
		super(1);
	}

	public FancyToy(boolean tag) {
		this.tag = tag;
	}
}

class RobotToy extends Toy {

	public RobotToy(boolean tag) {
		this.tag = tag;
	}

	public RobotToy(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoot {
}

interface DavidAdded {
}

public class RTTIDemo {

	public static void rttiDemo() {

		System.out.println("Inside main function");
		new Candy();
		System.out.println("After create candy");
		// new Gum();
		try {
			Class.forName("david.thinkinginJava.Gum");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Could not found gum");
		}
		System.out.println("After create gum");
		new Cookie();
		System.out.println("After create cookie");

	}

	public static void classCastDemo() {
		Toy fancyToy = new FancyToy(true);
		Class<FancyToy> typeClass = FancyToy.class;
		FancyToy newFancyToy = typeClass.cast(fancyToy);
		System.out.println(newFancyToy.getTagVal());
	}

	public static void showClassDemo() {
		Class<?> c = null;
		try {
			// c = Class.forName("david.thinkinginJava.FancyToy");
			c = Class.forName(FancyToy.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
		printRttiInfo(c);
		for (Class face : c.getInterfaces()) {
			printRttiInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			// TODO: handle exception
			System.out.println("Cannot instantiate.");
			System.exit(1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		printRttiInfo(obj.getClass());
	}

	public static void transformClasses() {
		try {
			Toy parent = new FancyToy();
			FancyToy child = (FancyToy) parent;
			Toy child2 = new FancyToy(true);
			Toy child3 = new RobotToy(false);
			// RobotToy child2 = (RobotToy) parent;
			printRttiInfoByObj(child);
			printRttiInfoByObj(child2);
			printRttiInfoByObj(child3);
		} catch (ClassCastException e) {
			// TODO: handle exception
			System.out.println("类型转换异常");
			System.out.println(e.getMessage());
		}
	}

	public static void boundClassReferences() {
		Class<? extends Number> boundClass = int.class;
		boundClass = double.class;
		boundClass = long.class;
	}

	public static boolean isObjPrimitive(Object obj) {
		Class<? extends Object> c = obj.getClass();
		return c.isPrimitive();
	}

	public static void primitiveDemo() {
		String str = "hello world";
		char pnum = 'a';
		Integer mixnum = 100;
		System.out.println("str =>" + isObjPrimitive(str));
		System.out.println("pnum =>" + isObjPrimitive(pnum));
		System.out.println("mixnum =>" + isObjPrimitive(mixnum));
		System.out.println(char.class);
	}

	/*
	 * 递归输出对应当前所有类的域属性包括继承过来的自己自带的
	 */
	private static void displayAllDeclaredFields(Class<? extends Object> c) {
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		Class<? extends Object> superClass = c.getSuperclass();
		if (superClass != null) {
			displayAllDeclaredFields(superClass);
		}
	}

	private static void displayAllDeclaredFieldsByObj(Object obj) {
		displayAllDeclaredFields(obj.getClass());
	}

	public static void displayAllDeclaredFieldsDemo() {
		displayAllDeclaredFieldsByObj(new FancyToy());
	}

	/*
	 * 递归输出当前对应所属类的继承体系类
	 */
	private static void displayAllClasses(Class<? extends Object> c) {
		Class<? extends Object>[] interfacesLs = c.getInterfaces();
		Class<? extends Object>[] classLs = c.getClasses();
		Class<? extends Object> superClass = c.getSuperclass();

		// if (interfacesLs.length > 0) {
		for (Class<? extends Object> item : interfacesLs) {
			System.out.println(item.getName());
			displayAllClasses(item);
		}
		// }

		if (classLs.length > 0) {
			for (Class<? extends Object> item : classLs) {
				System.out.println(item.getName());
				displayAllClasses(item);
			}
		}

		if (superClass != null) {
			System.out.println(superClass.getName());
			superClass = superClass.getSuperclass();
			if (superClass != null) {
				displayAllClasses(superClass);
			}
		}
	}

	private static void displayAllClassesByObj(Object obj) {
		displayAllClasses(obj.getClass());
	}

	public static void displayClassesDemo() {
		displayAllClassesByObj(new FancyToy());
	}

	/*
	 * 根据对象反射相应值
	 */
	private static void printRttiInfoByObj(Object obj) {
		Class<? extends Object> cls = obj.getClass();
		System.out.println("Class name: " + cls);
		System.out.println("Is Interface: " + cls.isInterface());
		System.out.println("Simple name: " + cls.getSimpleName());
		System.out.println("Canonical: " + cls.getCanonicalName());
		try {
			System.out.print("Tag: " + cls.getMethod("getTagVal").invoke(obj)); // 反射获取属性值
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("-------------------");
	}

	/*
	 * 根据类型展示相应属性值
	 */
	private static void printRttiInfo(Class c) {
		System.out.println("Class name: " + c.getName());
		System.out.println("Is Interface: " + c.isInterface());
		System.out.println("Simple name: " + c.getSimpleName());
		System.out.println("Canonical: " + c.getCanonicalName());
		try {
			System.out.print("Tag: " + c.getMethod("getTagVal").invoke(c));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------");
	}

	/*
	 * instanceof与直接比较getClass()值方式的不同
	 */
	public static void instanceOfDemo(Object obj) {
		System.out.println("Testing object is =>" + obj.getClass());
		System.out.println("Obj instanceof toy =>" + (obj instanceof Toy));
		System.out.println("Obj instance of fancytoy =>"
				+ (obj instanceof FancyToy));
		System.out.println("Toy.instanceof obj =>" + Toy.class.isInstance(obj));
		System.out.println("Fancy.instanceof obj =>"
				+ FancyToy.class.isInstance(obj));
		System.out.println("Obj class is equals Toy =>"
				+ obj.getClass().equals(Toy.class));
		System.out.println("Obj class is equals FancyToy =>"
				+ obj.getClass().equals(FancyToy.class));
		System.out.println("Obj class == Toy =>"
				+ (obj.getClass() == Toy.class));
		System.out.println("Obj class == FancyToy =>"
				+ (obj.getClass() == FancyToy.class));
	}

	public static void showInstanceOfDemo() {
		instanceOfDemo(new Toy());
		System.out.println("---------------------------");
		instanceOfDemo(new FancyToy());
	}

	/*
	 * 反射属性值
	 */
	public static void reflectObjValues(Object obj) {
		Class<? extends Object> objType = obj.getClass();
		System.out.println("Object type is " + objType);
		Field[] fields = objType.getDeclaredFields();
		try {
			for (Field field : fields) {
				String objProp = field.getName().length() < 1 ? "" : field
						.getName()
						.substring(0, 1)
						.toUpperCase().concat(field.getName().substring(1));
				String objValue = objType
						.getMethod("get" + objProp)
						.invoke(obj).toString();
				System.out.println(String.format(
						"Property Name: %s, Propecty Values：%s", objProp,
						objValue));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
