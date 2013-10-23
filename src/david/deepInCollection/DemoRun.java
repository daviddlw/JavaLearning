package david.deepInCollection;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

public class DemoRun {
    private static int number = 1000;

    public static void removeArrayDemo() {
	int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int b[] = { 3, 5, 1 };
	List<Integer> aList = new ArrayList<Integer>();
	List<Integer> bList = new ArrayList<Integer>();
	for (int i : a) {
	    aList.add(i);
	}
	for (int i : b) {
	    bList.add(i);
	}
	aList.removeAll(bList);
	System.out.println(aList);
    }

    /*
     * 查找满足某个时间段下面的内容
     */
    public static void searchFilesDemo() {
	Calendar calendar = Calendar.getInstance();
	calendar.set(2013, 0, 1, 0, 0, 0);
	String filepath = "D:\\";
	File file = new File(filepath);
	Calendar lastmodifiedDate = Calendar.getInstance();
	List<SearchedFile> searchedResult = new ArrayList<SearchedFile>();
	for (File item : file.listFiles()) {
	    lastmodifiedDate.clear();
	    lastmodifiedDate.setTimeInMillis(item.lastModified());
	    if (lastmodifiedDate.compareTo(calendar) > 0) {
		if (!item.isHidden()) {
		    SearchedFile sf = new SearchedFile(item.getName(),
			    lastmodifiedDate);
		    searchedResult.add(sf);
		}
	    }
	}
	Collections.sort(searchedResult);
	for (SearchedFile searchItem : searchedResult) {
	    System.out.println(searchItem.toString());
	}
    }

    public static void apacheCommons() {
	StrBuilder sb = new StrBuilder();
	sb.appendln("hello");
	sb.append("world");
	System.out.println(sb.toString());
	System.out.println("----------分割线--------------");
	StringBuilder sb2 = new StringBuilder();
	sb2.append("hello");
	sb2.append("world");
	System.out.println(sb2.toString());
	System.out.println(StringUtils.leftPad("7", 2, "0"));
    }

    public static void customCountedString() {
	List<String> ls = Arrays.asList("aa", "aa", "aa", "aa", "aa");
	for (String item : ls) {
	    CustomCountedString ccs = new CustomCountedString(item);
	    System.out.println(ccs.toString());
	}
	System.out.println(ls.get(0).equals(ls.get(1)));
    }

    public static void stringHashCode() {
	String hashString = "do you like no sql";
	String hashString2 = "do you like no sql";
	System.out.println(hashString + "=>" + hashString.hashCode());
	System.out.println(hashString2 + "=>" + hashString2.hashCode());
    }

    public static void simpleHashMapCustom() {
	SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<Integer, String>();
	hashMap.put(1, "david");
	hashMap.put(2, "mongodb");
	hashMap.put(3, "redis");
	hashMap.put(4, "cancarrrdes");
	hashMap.put(5, "hellworld");
	System.out.println(hashMap.toString());
	String removeElement = hashMap.remove(3);
	System.out.println("after remove " + removeElement);
	System.out.println(hashMap.toString());
	hashMap.clear();
	System.out.println("after clear " + hashMap.toString());
    }

    public static void simpleHashMapDemo() {

	long start = System.currentTimeMillis();
	SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<String, String>();
	simpleHashMap.putAll(new MapGenerator().generateRandomMapData(number));
	System.out.println(simpleHashMap.toString());
	System.out.println("耗时："
		+ String.valueOf(System.currentTimeMillis() - start) + "毫秒");
	System.out.println("hash地址冲突数" + simpleHashMap.getHashConflictCount()
		+ "\n" + simpleHashMap.getHashConflictExceptions());
	System.out.println("已经存在的map" + simpleHashMap.getExistMaps());
    }

    public static void slowMapDemo() {
	long start = System.currentTimeMillis();
	SlowMap<String, String> slowMap = new SlowMap<String, String>();
	slowMap.putAll(new MapGenerator().generateRandomMapData(number));
	System.out.println(slowMap.toString());
	System.out.println("耗时："
		+ String.valueOf(System.currentTimeMillis() - start) + "毫秒");
    }

    public static void mapGenerator() {
	MapGenerator mg = new MapGenerator();
	System.out.println(mg.generateRandomMapData(10));
	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    }

    public static void linkedHashMap() {
	LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(
		new CountedMapData(9));
	System.out.println(lhm.toString());
	// 最近虽少使用LRU
	lhm = new LinkedHashMap<Integer, String>(16, 0.75f, true);
	lhm.putAll(new CountedMapData(9));
	System.out.println(lhm.toString());
	for (int i = 0; i < 6; i++) {
	    lhm.get(i);
	}
	System.out.println(lhm.toString());
    }

    public static void sumCharactersCount() {
	List<String> ls = new ArrayList<String>(new CollectionData<String>(
		new RandomGen(1).getString(), 52));
	Collections.sort(ls);
	AssociateArray<String, Integer> associateArray = new AssociateArray<String, Integer>(
		52);
	for (String item : ls) {
	    if (!associateArray.containsKey(item)) {
		associateArray.put(item, 1);
	    } else {
		associateArray.put(item, associateArray.get(item) + 1);
	    }
	}
	System.out.println(ls.toString());
	System.out.println("-----------分割线---------------");
	System.out.println(associateArray.toString());		
    }

    public static void associateArrayDemo() {
	// AssociateArray<Integer, String> assArr = new AssociateArray<Integer,
	// String>(
	// 5);
	// Map<Integer, String> assArr = new HashMap<Integer, String>();
	// Map<Integer, String> assArr = new LinkedHashMap<Integer, String>();
	Map<Integer, String> assArr = new TreeMap<Integer, String>();
	assArr.put(5, "daviddai");
	assArr.put(4, "mongodb");
	assArr.put(3, "bigtable");
	assArr.put(2, "hadoop");
	assArr.put(1, "redis");
	System.out.println(assArr.toString());
	System.out.println("get 3 => " + assArr.get(3));
    }

    public static void customPriorityQueue() {
	CustomPriorityQueue<Integer> intLs = new CustomPriorityQueue<Integer>();
	intLs.addAll(Arrays.asList(8, 100, 9, 35, 5, 15, 3, 78, 1));
	CustomPriorityQueue<String> strLs = new CustomPriorityQueue<String>();
	strLs.addAll(Arrays.asList("mongodb", "daviddai", "bigtable", "hadoop",
		"redis", "hbase"));
	System.out.println(intLs.toString());
	System.out.println(strLs.toString());
    }

    public static void queueBehaviorDemo() {
	QueueBehavior qb = new QueueBehavior();
	qb.testQueue(new LinkedList<String>(), new NumberGen());
	qb.testQueue(new PriorityQueue<String>(), new NumberGen());
	qb.testQueue(new ArrayBlockingQueue<String>(8), new NumberGen());
	qb.testQueue(new ConcurrentLinkedQueue<String>(), new NumberGen());
	qb.testQueue(new LinkedBlockingDeque<String>(), new NumberGen());
	qb.testQueue(new PriorityBlockingQueue<String>(), new NumberGen());
    }

    public static void customSortedSetDemo() {
	CustomSortedSet<Integer> csSet = new CustomSortedSet<Integer>();
	CustomSortedSet<String> csStringSet = new CustomSortedSet<String>();
	csSet.addAll(Arrays.asList(8, 100, 9, 35, 5, 15, 3, 78, 1));
	csStringSet.addAll(Arrays.asList("mongodb", "daviddai", "bigtable",
		"hadoop", "redis", "hbase"));
	System.out.println(csSet + "\n长度为：" + csSet.size());
	System.out.println(csStringSet + "\n长度为：" + csStringSet.size());
    }

    public static void treeSetDemo() {
	SortedSet<String> sortedSet = new TreeSet<String>(
		new CollectionData<String>(new RandomGen(1).getString(), 26));
	System.out.println(sortedSet.toString());
    }

    public static void countIntegerDemo() {
	CountIntegerList cil = new CountIntegerList(30);
	System.out.println(cil);
	System.out.println(cil.get(5));
	cil.set(5, new Integer(88));
	System.out.println();
    }

    public static void mapEntryDemo() {
	System.out.println(new CountedMapData(30));
    }

    public static void fillList() {
	FillingList fList = new FillingList();
	fList.fillList();
    }

    public static void randomGen() {
	System.out.println(new ArrayList<String>(new CollectionData<String>(
		new RandomGen(10).getString(), 10)));
	System.out.println(new ArrayList<Integer>(new CollectionData<Integer>(
		RandomGen.getInteger(), 10)));
    }

    public static void collectinoDataDemo() {

	Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(
		new GovernmentGen(), 5));
	// set.addAll(CollectionData.list(new GovernmentGen(), 5));
	System.out.println("--------普通方式---------");
	System.out.println(set.toString());
	Set<String> ls = new LinkedHashSet<String>();
	System.out.println("-------new方式--------");
	ls.addAll(new CollectionData<String>(new GovernmentGen(), 5));
	System.out.println(ls.toString());
	System.out.println("-------静态list方式--------");
	ls.addAll(CollectionData.list(new GovernmentGen(), 5));
	System.out.println(ls.toString());
    }
}
