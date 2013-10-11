package david.deepInCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;

public class DemoRun {
	
	public static void linkedHashMap() {
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(new CountedMapData(9));
		System.out.println(lhm.toString());
		for (int i = 0; i < 6; i++) {
			lhm.get(3);
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
		qb.testQueue(new ConcurrentLinkedDeque<String>(), new NumberGen());
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
