package david.thinkinginJava;

import java.io.PrintStream;
import java.text.Collator;
import java.util.*;

import david.javalearning.CompTypeComparator;
import david.javalearning.CustomThread;
import david.javalearning.CustomThreadRunnable;
import david.javalearning.HelloWorldSwing;
import david.javalearning.Human;
import david.javalearning.IODemo;
import david.javalearning.Polymorphism;
import david.javalearning.Reservior;
import david.javalearning.StringDemo;
import david.javalearning.StudentInfo;
import david.javalearning.TicketBooth;
import david.javalearning.TryCatchDemo;
import david.javalearning.Woman;
import david.util.HiddenImp;
import david.util.IDemoInteface;

public class DemoRun {

    public DemoRun() {
	// TODO Auto-generated constructor stub
    }

    /*
     * String API学习
     */
    public static void stringUtilDemo() {
	StringDemo.stringAPILearning();
	StringDemo.stringFormatter();
    }

    /*
     * 异常处理类
     */
    public static void tryCatchDemo() {
	TryCatchDemo.readFileTryCatch();
	TryCatchDemo.testThrowExceptions();
	TryCatchDemo.testException();
    }

    /*
     * IO处理类
     */
    public static void ioDemo() {
	IODemo.writeFileSample();
	IODemo.readFileSample(false);
    }

    /*
     * 多态demo
     */
    public static void polymorphismDemo() {
	Polymorphism.PolymorphismSample();

	Human human = new Human(188.81);
	Class<? extends Human> humanClass = human.getClass();
	System.out.println(humanClass.getName());
	System.out.println(humanClass.getPackage());

	System.out.println(human.getHeight());
	human.growHeight(100);
	System.out.println(human.getHeight());

	Human woman = new Woman();
	Class<? extends Human> womanClass = woman.getClass();
	System.out.println(womanClass.getName());
	System.out.println(womanClass.getPackage());
	((Woman) woman).setHeight(100);
	System.out.println(woman.getHeight());

	try {
	    Class<?> newHuman = Class.forName("david.javalearning.Human");
	    System.out.println(newHuman.getName());

	    Class<?> newWoman = Class.forName("david.javalearning.Woman");
	    System.out.println(newWoman.getName());

	    Object obj = newWoman.newInstance();
	    System.out.println(obj instanceof Woman);
	    System.out.println(obj instanceof Human);
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	    // TODO: handle exception
	} catch (ClassCastException e) {
	    e.printStackTrace();
	    // TODO: handle exception
	} catch (Exception e) {
	    e.printStackTrace();
	    // TODO: handle exception
	}
    }

    /*
     * 线程类
     */
    public static void threadDemo() {
	CustomThread threadOne = new CustomThread();
	CustomThread threadTwo = new CustomThread();
	threadOne.start();
	threadTwo.start();
    }

    /*
     * runnable demo
     */
    public static void runnableDemo() {
	Thread runnableOne = new Thread(new CustomThreadRunnable(), "First");
	Thread runnableTwo = new Thread(new CustomThreadRunnable(), "Two");
	runnableOne.start();
	runnableTwo.start();
	runnableOne.toString();
	runnableTwo.toString();

	Reservior reservior = new Reservior(100);
	TicketBooth tb1 = new TicketBooth(reservior);
	TicketBooth tb2 = new TicketBooth(reservior);
	TicketBooth tb3 = new TicketBooth(reservior);
    }

    public static void arrayDemo() {
	String[] ls = new String[] { "aa", "bb", "cc" };
	System.out.println(ls[2]);
    }

    public static void iteratorDemo() {
	Collection<String> arrLs = new ArrayList<String>();
	arrLs.add("aa");
	arrLs.add("bb");
	arrLs.add("cc");
	Iterator<String> iterator = arrLs.iterator();
	while (iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
    }

    public static void removeSimpleList() {
	java.util.List<String> ls = new ArrayList<String>();
	ls.add("david.dai");
	ls.add("lave.zhang");
	ls.add("hello.world");

	for (String string : ls) {
	    System.out.println(string);
	}
	Stack<String> stack = new Stack<String>();
	stack.push("david.dai");
	stack.push("lave.zhang");
	// ls.remove("david.dai");
	ls.removeAll(stack);

	System.out.println("-----------after remove---------------");
	for (String string : ls) {
	    System.out.println(string);
	}

	System.out.println(ls.size());
    }

    /*
     * Copy Array
     */
    public static void copyArray() {
	int[] sourceArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
	int[] destArray = new int[sourceArray.length];
	System.arraycopy(sourceArray, 0, destArray, 0, sourceArray.length - 1);
	StringBuilder sourceSb = new StringBuilder();
	StringBuilder destSb = new StringBuilder();

	for (int i : sourceArray) {
	    sourceSb.append(i + ",");
	}
	System.out.println("sourceArray: "
		+ sourceSb.substring(0, sourceSb.toString().length() - 1));

	for (int i : destArray) {
	    destSb.append(i + ",");
	}

	System.out.println("destArray:"
		+ destSb.substring(0, destSb.toString().length() - 1));
    }

    public static String internalClassDemo(boolean isReverse) {
	StudentInfo davidStudentInfo = new StudentInfo("david.dai");
	StudentInfo hapStudentInfo = new StudentInfo("lave.zhang");
	StudentInfo.Grade stuGrade = davidStudentInfo.new Grade(100, 80, 99);
	StudentInfo.Grade hapGrade = hapStudentInfo.new Grade(99, 88, 77);
	String result = "";
	if (isReverse) {
	    result = String.format("%2$s\n%1$s", stuGrade.getGradeInfo(),
		    hapGrade.getGradeInfo());
	} else {
	    result = String.format("%1$s\n%2$s", stuGrade.getGradeInfo(),
		    hapGrade.getGradeInfo());
	}

	return result;

    }

    /*
     * 中文排序
     */
    public static void sortNamesString(boolean isChinese) {
	String[] chineseNames = new String[] { "戴励维", "赵晨", "张雷", "王小平" };
	String[] englishNames = new String[] { "david.dai", "karl.zhao",
		"lave.zhang", "sharping.wang" };
	String[] resultStrings;
	if (isChinese) {
	    Arrays.sort(chineseNames,
		    Collator.getInstance(java.util.Locale.CHINA));
	    resultStrings = chineseNames.clone();
	    // Arrays.sort(chineseNames);
	    // resultStrings = chineseNames.clone();
	} else {
	    Arrays.sort(englishNames);
	    resultStrings = englishNames.clone();
	}

	for (String name : resultStrings) {
	    System.out.println(name);
	}
    }

    public static void testCommonUil() {
	Object obj = "4123.2312";
	// System.out.println(david.util.StringUtil.toInt(obj));
	System.out.println(david.util.StringUtil.toDouble(obj));
    }

    public static void showGUI() {

	Runnable runnable = new Runnable() {

	    @Override
	    public void run() {
		// TODO Auto-generated method stub
		HelloWorldSwing.createAndShowGUI();
	    }
	};
	javax.swing.SwingUtilities.invokeLater(runnable);
    }

    public static void FormatterDemo() {
	PrintStream psOut = System.out;
	PrintStream psErr = System.err;
	Turtle outTurtle = new Turtle("david.dai", new Formatter(psOut));
	Turtle errTurtle = new Turtle("yuejiaohu", new Formatter(psErr));
	outTurtle.move(2, 3);
	outTurtle.move(5, 6);
	errTurtle.move(100, 30);
	errTurtle.move(3, 200);
    }

    /*
     * 输出99乘法表
     */
    public static void showNineToNine() {
	for (int i = 1; i <= 9; i++) {
	    StringBuilder sb = new StringBuilder();
	    for (int j = 1; j <= 9; j++) {

		if (j != 9)
		    sb.append(String.format("%s ",
			    (i * j) <= 9 ? String.format("0%d", i * j) : i * j));
	    }
	    System.out.println(sb.toString());
	    System.out.println();
	}
    }

    public static void replaceDemo(ReplaceEnum type) {
	String sourceStr = "david";
	System.out.println(RegexBuddy.replaceDemo(type, sourceStr));
    }

    /*
     * arrayGeneratorDemo数组生成
     */
    public static void arrayGeneratorDemo(SortType type) {
	int size = 10;
	CompType[] arrs = new CompType[size];
	Random rand = new Random(47);
	for (int i = 0; i < size; i++) {
	    arrs[i] = new CompType(rand.nextInt(100), rand.nextInt(100));
	}

	System.out.println("排序前：\n");
	System.out.println(Arrays.toString(arrs));
	switch (type) {
	case Default:
	    Arrays.sort(arrs);
	    break;
	case Reservse:
	    Arrays.sort(arrs, Collections.reverseOrder());
	    break;
	case Custom:
	    Arrays.sort(arrs, new CompTypeComparator());
	    break;
	default:
	    Arrays.sort(arrs);
	    break;
	}

	System.out.println("排序后：\n");
	System.out.println(Arrays.toString(arrs));
    }

    /*
     * 持有对象Demo
     */
    public static void collectionStoreDemo() {
	ArrayList<Man> ls = new ArrayList<Man>();
	ls.add(new Man());
	ls.add(new Man());
	ls.add(new Man());
	ls.add(new Male());
	for (int i = 0; i < ls.size(); i++) {
	    System.out.println(ls.get(i).id());
	    System.out.println(ls.get(i).hashCode());
	}
    }

    public static boolean retainAllDemo() {
	List<String> sourceLs = new ArrayList<String>(
		Arrays.asList(new String[] { "1", "2", "3", "4" }));
	Set<String> targetSet = new HashSet<String>();
	for (int i = 2; i <= 5; i++) {
	    targetSet.add(String.valueOf(i));
	}
	boolean flag = sourceLs.retainAll(targetSet);
	System.out.println(sourceLs.toString());
	System.out.println(targetSet.toString());
	return flag;
    }

    public static void petDemo() {
	List<Pet> pets = new ArrayList<Pet>(Arrays.asList(new Pet[] {
		new Pet(), new Pet() }));
	for (Pet pet : pets) {
	    System.out.println(String.format("id：%d, name：%s", pet.id(),
		    pet.name()));
	}
    }

    public static void petDemoRun() {
	Random rand = new Random(47);
	List<Pet> pets = new LinkedList<Pet>(Arrays.asList(new Pet[] {
		new Pet(), new Pet(), new Pet(), new Pet() }));

	System.out.println("1：" + pets.toString());
	System.out.println(new Pet());
	System.out.println("2：" + pets.toString());
	System.out.println("3：" + pets.subList(2, 4).toString());

	Iterator<Pet> pi = pets.iterator();
	while (pi.hasNext()) {
	    Pet pet = pi.next();
	    System.out.println(pet.id() + "_" + pet.name());
	}

	ListIterator<Pet> lkpi = pets.listIterator();
	while (lkpi.hasNext()) {
	    Pet pet = lkpi.next();
	    System.out
		    .format("current obj=>%s\ncurrent index=>%d\nprevious index=>%d\nnext index=>%d\n----------\n",
			    pet.name(), pet.id(), lkpi.previousIndex(),
			    lkpi.nextIndex());
	    System.out.println(lkpi.previous().id());
	    lkpi.next();
	}
    }

    /*
     * 使用ListInterator倒叙查找
     */
    public static void reserveNumbers(List<Integer> ls) {
	List<Integer> resultLs = new ArrayList<Integer>();
	ListIterator<Integer> lIter = ls.listIterator(ls.size());
	while (lIter.hasPrevious()) {
	    Integer num = lIter.previous();
	    resultLs.add(num);
	}

	System.out.println(resultLs.toString());
    }

    public static void linkedListDemo() {

	LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(1, 2,
		3, 4, 5, 6, 7, 8, 9));
	System.out.println("size=> " + list.size());
	System.out.println("hashCode=>" + list.hashCode());
	System.out.println(String.format("index %d => %s", 1, list.get(1)));
	System.out.println("peek=>" + list.peek());
	System.out.println("peekFirst=>" + list.peekFirst());
	System.out.println("peekLast=>" + list.peekLast());
	System.out.println("getFirst=>" + list.getFirst());
	System.out.println("getLast=>" + list.getLast());
	System.out.println("poll=>" + list.poll());
	System.out.println("pollFirst=>" + list.pollFirst());
	System.out.println("pollLast=>" + list.pollLast());
    }

    public static void stackDemo() {
	List<String> resultLs = new ArrayList<String>();
	Stack<String> stack = new Stack<String>();
	stack.push("U");
	stack.push("n");
	stack.push("c");
	while (!stack.isEmpty()) {
	    resultLs.add(stack.pop());
	}
	stack.push("e");
	stack.push("r");
	stack.push("t");
	while (!stack.isEmpty()) {
	    resultLs.add(stack.pop());
	}
	stack.push("a");
	resultLs.add(stack.pop());
	stack.push("i");
	resultLs.add(stack.pop());
	stack.push("n");
	stack.push("t");
	stack.push("y");
	while (!stack.isEmpty()) {
	    resultLs.add(stack.pop());
	}
	stack.push("r");
	stack.push("u");
	while (!stack.isEmpty()) {
	    resultLs.add(stack.pop());
	}
	stack.push("l");
	stack.push("e");
	stack.push("s");
	while (!stack.isEmpty()) {
	    resultLs.add(stack.pop());
	}
	System.out.println(resultLs.toString());
	// cnUtreaiytnursel
    }

    public static void generateRandomNum() {
	Set<Integer> set = new HashSet<Integer>();
	Map<Integer, Integer> mapValue = new HashMap<Integer, Integer>();
	Random rand = new Random(47);
	for (int i = 0; i < 10000; i++) {
	    int rn = rand.nextInt(30);
	    set.add(rn);
	    Integer count = mapValue.get(rn);
	    mapValue.put(rn, count == null ? 1 : count + 1);
	}
	System.out.println(set.toString());
	System.out.println("------随机数统计-----");
	System.out.println(mapValue);
    }

    /*
     * 使用nextDouble均匀分布在0.0到1.0之间的值
     */
    public static void generateRandomNum2() {
	Set<Integer> list = new HashSet<Integer>();
	List<Double> ls = new ArrayList<Double>();
	Random rand = new Random();
	for (int i = 0; i < 100; i++) {
	    ls.add(rand.nextDouble() * 100);
	}
	for (Double item : ls) {
	    list.add(Integer.parseInt(String.valueOf(Math.round(item))));
	}
	System.out.println(list.toString());
    }

    public static void linkedListPeekAndElement() {
	Queue<Integer> queue = new LinkedList<Integer>();
	queue.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

	while (queue.peek() != null) {
	    System.out.println(queue.remove());
	}
    }

    /*
     * thinking in java queue demo, 持有对象练习27
     */
    public static void queueDemo() {
	QueueOperation queueOperation = new QueueOperation();
	List<QueueCommand> ls = new ArrayList<QueueCommand>(
		Arrays.asList(new QueueCommand[] {
			new QueueCommand("daviddai"),
			new QueueCommand("karlzhao"),
			new QueueCommand("sharpingwang"),
			new QueueCommand("lavezhang") }));
	for (QueueCommand qc : ls) {
	    queueOperation.fillQueue(qc);
	}

	Queue<QueueCommand> queue = queueOperation.getQueue();
	new DequeueOperation().dequeueList(queue);
    }

    public static void priorityQueue() {
	Queue<Integer> ls = new PriorityQueue<Integer>();
	Random rand = new Random(47);
	for (int i = 0; i < 10; i++) {
	    ls.offer(rand.nextInt(i + 10));
	}
	while (!ls.isEmpty()) {
	    System.out.println(ls.poll());
	}
    }

    public static void testIterable() {
	SubIterable si = new SubIterable();
	for (String s : si) {
	    System.out.println(s);
	}
    }

    public static void testException() {
	InheritingException ie = new InheritingException();
	try {
	    ie.fun();
	} catch (SimpleException e) {
	    System.out.println("catch it!");
	}
    }

    public static void arrayOfPrimativesDemo() {
	ArrayOfPrimatives aop = new ArrayOfPrimatives();
	aop.showOriginalArray();
	aop.changeArray();
	aop.showResultArray();
    }

    public static void mergeArrayDemo() {
	ApacheCommon<Integer> apc = new ApacheCommon<Integer>();
	Integer[] a1 = new Integer[] { 1, 2, 3 };
	Integer[] a2 = new Integer[] { 3, 4, 5 };
	Integer[] result = apc.mergeArrays(a1, a2);
	System.out.println(Arrays.toString(result));
	System.out.println(Arrays.asList(result));
    }

    public static void stringUtilsDemo() {
	String str = "a";
	String str2 = "A";
	// System.out.println(StringUtils.isAlpha(str));
	// System.out.println(StringUtils.isAlpha(str2));
    }

    public static void objectToStringDemo() {

	List<Student> ls = Arrays.asList(new Student[] {
		new Student(1, "daviddai"), new Student(2, "lavezhang"),
		new Student(3, "karlzhao") });

	for (Student item : ls) {
	    System.out.println(item.toString());
	}
    }

    public static void optionTrailingArgsDemo() {
	OptionTrailingArguments ota = new OptionTrailingArguments();
	ota.showArrayItems(1, new String[] { "david", "hello", "world" });
	ota.showArrayItems(2, new Integer[] { 1, 2 });
	ota.showArrayItems(3, new Student[] { new Student(1, "stu1"),
		new Student(2, "stu2") });
    }

    public static void displayRMB() {
	for (RMBEnum rmb : RMBEnum.values()) {
	    System.out.println(String.format("枚举值：%d, 枚举名：%s", rmb.ordinal(),
		    rmb.toString()));
	}
    }

    public static void displayRMB(RMBEnum type) {
	System.out.println("枚举简介\n");
	displayRMB();
	System.out.println();
	switch (type) {
	case OneYuan:
	    System.out.println("壹元人民币");
	    break;
	case FiveYuan:
	    System.out.println("伍元人民币");
	    break;
	case TenYuan:
	    System.out.println("拾元人民币");
	    break;
	case TwentyYuan:
	    System.out.println("贰拾元人民币");
	    break;
	case FiftyYuan:
	    System.out.println("伍拾人民币");
	    break;
	case OneHundredYuan:
	    System.out.println("壹佰元人民币");
	    break;
	default:
	    break;
	}
    }

    public static void petCreatorDemo() {

	PetCreator pc = new PetCreatorByName();
	System.out.println(pc.arrayList(10));
	System.out.println(pc.toString());
    }

    public static void sortDemo() {
	String str = "12,32,28,3,42,17,8";
	String[] sourceArray = str.split(",");
	List<Integer> ls = new ArrayList<Integer>();
	for (String item : sourceArray) {
	    ls.add(Integer.parseInt(item));
	}
	Integer[] resultArray = ls.toArray(new Integer[ls.size()]);
	Arrays.sort(resultArray);
	System.out.println(Arrays.toString(resultArray));
    }

    /*
     * 使用反射调用另一个包中的包访问权限，私有或者protected级别的方法
     */
    public static void rttiSummaryDemo() {
	IDemoInteface di = HiddenImp.makeDemoClass();
	try {
	    HiddenImp.callHiddenMethod(di, "privateFun");
	    HiddenImp.callHiddenMethod(di, "protectedFun");
	    HiddenImp.callHiddenMethod(di, "fun");
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public static void testLinkedStack() {
	LinkedStack<String> lss = new LinkedStack<String>();
	for (String s : "Phasers on stun!".split(" ")) {
	    lss.push(s);
	}
	String s;
	while ((s=lss.pop())!=null) {
	    System.out.println(s);
	}	
    }
    
    public static void getRandomList() {
	
    }
}
