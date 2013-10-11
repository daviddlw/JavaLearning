package david.deepInCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DemoRun {

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
