package david.generic;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import david.model.Student;
import david.util.CollectionUtils;

public class GenericMainFun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// carFactoryDemo();
		// tupleDemo();
		// randomList();
		// coffeeGenerator();
		// fibGenerator();
		// iterableFibnoacciDemo();
		// genericMethod();
		// collectionUtils();
		// makeList();
		// generatorsDemo();
		// basicGeneratorDemo();
		// sumDemo();
		// GenericMethod.collectionUtilDemo();
		// collectionTest();
		// clearGenericTypes();
		// Manipulator.testManipulator();
		// arrayMaker();
		// classTypeCapture();
		// boundGenericAction();
		// fruitGenericList();
		// fixedSizeStack();
		// CoffeeCheck.coffeeCheck();
		// mixinDemo();
		decoratorDemo();
		
	}
	
	/*
	 * 装饰者
	 */
	private static void decoratorDemo() {
		MilkImp ml = new MilkImp(new SugarImp(new CoffeeBasic()));
		ml.set("hello");
		ml.milkAbility();
		ml.coffeeAbility();

		SugarImp sl = new SugarImp(new CoffeeBasic());
		sl.set("world");
		sl.sugarAbility();
		sl.coffeeAbility();
	}

	private static void mixinDemo() {
		Mixin mixin1 = new Mixin();
		Mixin mixin2 = new Mixin();
		mixin1.set("daviddai");
		mixin2.set("mongodb");
		System.out.println(mixin1.get() + "|" + mixin1.getTimeStamp() + "|"
				+ mixin1.getSeriesNumber());
		System.out.println(mixin2.get() + "|" + mixin2.getTimeStamp() + "|"
				+ mixin2.getSeriesNumber());

		// System.out.println(String.format(
		// "Minin1 => get: {0}, timeStamp: {1}, seriesNumber: {2}", mixin1
		// .get().toString(), mixin1.getTimeStamp(), mixin1
		// .getSeriesNumber()));
		// System.out.println(String.format(
		// "Minin2 => get: {0}, timeStamp: {1}, seriesNumber: {2}",
		// mixin2.get(), mixin2.getTimeStamp(), mixin2.getSeriesNumber()));
	}

	private static void fixedSizeStack() {
		String testString = "a b c d e f g";
		// FixedSizeStack<String> fss = new FixedSizeStack<String>(
		// testString.length());

		FixedSizeStack<String> ls = new FixedSizeStack<String>();
		for (String s : testString.split(" ")) {
			ls.push(s);
		}

		for (int i = 0; i < testString.length(); i++) {
			String s = ls.pop();
			System.out.print(s + "|");
		}
	}

	private static void fruitGenericList() {
		List<? super Fruit> ls = new ArrayList<Fruit>();
		// ls.add(new Fruit("hello"));
		// //所谓的协变就是指子类随着父类一起变化例如a是b的子类则，可以用a[]替换b[]，注意泛型无协变
		List<? extends Fruit> ls2 = Arrays.asList(new Apple("david"));
		Apple apple = (Apple) ls2.get(0);
		System.out.println(apple.toString() + "_"
				+ apple.getClass().getSimpleName());
		boolean flag = ls2.contains(new Apple("david")); // 此处是表示Object不会根据泛型来编译器没那么聪明
		int index = ls2.indexOf(new Apple("david"));
		System.out.println("flag=> " + flag);
		System.out.println("index=> " + index);
		writeWithCard(ls, new Apple("david"));
	}

	private static <T> void writeWithCard(List<? super T> ls, T item) {
		ls.add(item);
		System.out.println(ls.toString());
	}

	/*
	 * 边界类测试
	 */
	private static void boundGenericAction() {
		// 创建泛型边界类此处先顶了IFly与IRun，他能跑能飞，但是不会游泳
		BoundGenericAction bga = new BoundGenericAction();
		ActionImp actionImp = new ActionImp();// 继承了IFly，IRun

		bga.genericFly(actionImp);
		bga.genericRun(actionImp);
		/*
		 * 因为当前genericSwim只适用于实现了ISwim的类而当前的actionImp没有实现该接口，也就表示不能达到该边界所以会编译失败。
		 * Bound mismatch: The generic method genericSwim(T) of type
		 * BoundGenericAction is not applicable for the arguments (ActionImp).
		 * The inferred type ActionImp is not a valid substitute for the bounded
		 * parameter <T extends ISwim>
		 */

		// bga.genericSwim(actionImp);
	}

	private static void classTypeCapture() {
		Building building = new Building();
		House house = new House();
		ClassTypeCapture<Building> ctcBuilding = new ClassTypeCapture<Building>(
				Building.class);
		ClassTypeCapture<House> ctcHouse = new ClassTypeCapture<House>(
				House.class);
		System.out.println("ClassTypeCapture<Building> :"
				+ ctcBuilding.isInstance(building));
		System.out.println("ClassTypeCapture<Building> :"
				+ ctcBuilding.isInstance(house));
		System.out.println("ClassTypeCapture<House> :"
				+ ctcHouse.isInstance(building));
		System.out.println("ClassTypeCapture<House> :"
				+ ctcHouse.isInstance(house));
		System.out.println("--------------分割线-------------");
		ClassTypeCapture<Student> ctcTest = new ClassTypeCapture<Student>();
		ctcTest.addType("stu", Student.class);
		System.out.println(ctcTest.createNew("stu").toString());

		try {
			int i = Integer.class.newInstance();
			System.out.println(i);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("当前类没有默认无参构造方法\n"
					+ Arrays.toString(e.getStackTrace()));
		}

	}

	/*
	 * 泛型类型擦除
	 */
	private static void clearGenericTypes() {
		Set<Integer> hsIntegers = new HashSet<Integer>();
		Map<String, Student> hsStudent = new HashMap<String, Student>();
		System.out.println(Arrays.toString(hsIntegers.getClass()
				.getTypeParameters()));

		System.out.println(Arrays.toString(hsStudent.getClass()
				.getTypeParameters()));
	}

	public static void collectionTest() {
		Set<Integer> one = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> two = new HashSet<Integer>(Arrays.asList(4, 5, 6, 7, 8));
		System.out.println(CollectionUtils.intersect(one, two));
		System.out.println(CollectionUtils.unionAll(one, two));
		System.out.println(CollectionUtils.different(one, two));
		System.out.println(CollectionUtils.complement(one, two));
	}

	public static void sumDemo() {
		System.out.println(GenericMethod.sum(1, 2, 3, 4, 5));
	}

	private static void basicGeneratorDemo() {
		System.out.println("构造方法方式:");
		for (int i = 0; i < 5; i++) {
			BasicGenerator<CountedObject> bg = new BasicGenerator<CountedObject>(
					CountedObject.class);
			System.out.println(bg.next().toString());
		}
		System.out.println("Create方法方式:");
		for (int i = 0; i < 5; i++) {
			Generator<CountedObject> bg = BasicGenerator
					.<CountedObject> create(CountedObject.class);
			System.out.println(bg.next().toString());
		}
	}

	private static void generatorsDemo() {
		Collection<Integer> ls = Generators.fill(new ArrayList<Integer>(),
				new Fibnoacci(), 6);
		System.out.println(ls);
		Collection<Coffee> ls2 = Generators.fill(new ArrayList<Coffee>(),
				new CoffeeGenerator(), 6);
		System.out.println(ls2);

		List<Integer> ls3 = Generators.fill(new ArrayList<Integer>(),
				new Fibnoacci(), 6);
		System.out.println(ls3);
	}

	public static void makeList() {
		GenericVarArgs.makeList(1, 2, 3);
		GenericVarArgs.makeList("david");
		GenericVarArgs.makeList(1, "helloworld", new Student("david.dai"));
	}

	public static void collectionUtils() {
		List<Integer> arrayList = CollectionUtils.arrayList();
		arrayList.addAll(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(arrayList.toString());

		List<Integer> linkedList = CollectionUtils.linkedList();
		linkedList.addAll(Arrays.asList(6, 7, 8, 9, 0));
		System.out.println(linkedList.toString());

		Map<Integer, Student> studentMap = CollectionUtils.hashMap();
		studentMap.put(1, new Student("david.dai"));
		studentMap.put(2, new Student("lavezhang"));
		studentMap.put(3, new Student("karlzhao"));
		System.out.println(studentMap.toString());

		Map<Integer, String> map = CollectionUtils.hashMap();
		GenericMethod.showGenericMethodInfoWithParams(map);
		GenericMethod.showGenericMethodInfoWithParams(CollectionUtils
				.<Integer, String> hashMap());
	}

	public static void genericMethod() {
		GenericMethod.showGenericMethodInfo(2.0);
		GenericMethod.showGenericMethodInfo(1);
		GenericMethod.showGenericMethodInfo("hello world");
		GenericMethod.showGenericMethodInfo(new Student("david.dai"));
		System.out.println("---------分割线----------");
		GenericMethod.showGenericMethodInfo(1, 8.8,
				new Student("moneymaker"));
		GenericMethod.showGenericMethodInfo(1, 8.9, "I want more money.");
	}

	private static void iterableFibnoacciDemo() {
		for (int i : new IterableFibnoacci(18)) {
			System.out.print(i + " ");
		}
	}

	private static void fibGenerator() {
		Fibnoacci fg = new Fibnoacci();
		for (int i = 0; i < 18; i++) {
			System.out.print(fg.next() + " ");
		}
	}

	private static void coffeeGenerator() {
		CoffeeGenerator cg = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(cg.next());
		}

		for (Coffee coffee : new CoffeeGenerator(5)) {
			System.out.println(coffee);
		}
	}

	private static void randomList() {
		String[] strArr = new String[] { "david.dai", "lavezhang", "karlzhao",
				"helloworld", "moneymaker" };

		Integer[] intArr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Student[] stuArr = new Student[] { new Student("stuOne"),
				new Student("stuTwo"), new Student("stuThree") };

		RandomList<String> rsStrLs = new RandomList<String>();
		RandomList<Integer> rsIntLs = new RandomList<Integer>();
		RandomList<Student> rsStuLs = new RandomList<Student>();

		rsIntLs.addAll(intArr);
		rsStrLs.addAll(strArr);
		rsStuLs.addAll(stuArr);

		for (String s : strArr) {
			System.out.print(rsStrLs.select() + " ");
		}

		System.out.println();

		for (Integer s : intArr) {
			System.out.print(rsIntLs.select() + " ");
		}

		System.out.println();

		for (Student student : stuArr) {
			System.out.print(rsStuLs.select() + " ");
		}
	}

	private static void tupleDemo() {
		System.out.println(TupleTest.twoTuple());
		System.out.println(TupleTest.threeTuple());
		System.out.println(TupleTest.fourTuple());
		TwoTuple<Benz, String> test = new TwoTuple<Benz, String>(new Benz(
				"test", 700), "test");
		System.out.println(test);
	}

	private static void carFactoryDemo() {
		CarFactory<Car> carFactory = new CarFactory<Car>();
		List<Car> cars = Arrays.asList(new Car[] {
				new Benz("david.dai", 99.99),
				new Cadillac("helloworld", 88.88), new Ford("fordcar", 180) });

		for (Car car : cars) {
			carFactory.addObj(car);
		}

		List<Car> resultLs = carFactory.getObj();
		for (Car car : resultLs) {
			car.showCarBrand();
		}
	}
}
