package david.deepInCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CollectionMethods {

    public static void slistDemo() {
	List<String> strLs = Arrays.asList("daviddai", "helloword", "redis",
		"mongodb", "cassadra");
	List<Integer> intLs = Arrays.asList(1, 2, 3, 4, 6, 7, 8);

	SList<String> stringSList = null;
	for (int i = 0; i < strLs.size(); i++) {
	    stringSList = new SList<String>(stringSList, strLs.get(i));
	}

	System.out.println(stringSList.toString());
    }

    public static void iteratorDemo() {
	List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3,
		4, 5));
	List<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(6, 7,
		8, 9, 0));
	System.out.println("arrayList=>" + arrayList.toString());
	System.out.println("linkedList=>" + linkedList.toString());

	List<Integer> combineList = new ArrayList<Integer>();
	ListIterator<Integer> listIterator = arrayList.listIterator();
	ListIterator<Integer> linkedListIterator = linkedList
		.listIterator(linkedList.size());

	while (listIterator.hasNext() || linkedListIterator.hasPrevious()) {

	    if (listIterator.hasNext()) {
		combineList.add(listIterator.next());
	    }

	    if (linkedListIterator.hasPrevious()) {
		combineList.add(linkedListIterator.previous());
	    }
	}

	System.out.println(combineList.toString());
    }

    /*
     * 集合类常用功能方法
     */
    public static void collectionMethods() {
	Collection<String> ls = new ArrayList<String>(Arrays.asList("daviddai",
		"mongodb", "hadoop", "mapreduce", "apache"));
	System.out.println("original =>" + ls.toString());
	ls.add("newAdd");
	System.out.println("add =>" + ls.toString());
	ls.addAll(Arrays.asList("redis", "cassandra"));
	System.out.println("addAll =>" + ls.toString());

	Iterator<String> iterator = ls.iterator();
	while (iterator.hasNext()) {
	    System.out.print(iterator.next() + " ");
	}
	System.out.println();

	System.out.println("index 2 to 4 =>"
		+ ((List<String>) ls).subList(2, 4));
	System.out.println("Contains mongodb?  => " + ls.contains("mongodb"));
	System.out.println("Contains helloworld?  => "
		+ ls.contains("helloworld"));
	System.out.println("Constains collection {redis, cassandra}  => "
		+ ls.containsAll(Arrays.asList("redis", "cassandra")));
	Collection<String> emptyLs = new ArrayList<String>();
	ls.clear();
	System.out.println("after clear =>" + ls.toString());
	System.out.println("is empty =>" + ls.isEmpty());
	System.out.println("is equals to emptyLs => " + ls.equals(emptyLs));
	ls.addAll(Arrays.asList("highperformance", "structs", "spring",
		"ibatis"));
	System.out.println(ls.toString());
	ls.remove("highperformance");
	ls.remove("none");
	System.out.println("after remove => " + ls.toString());
	ls.removeAll(Arrays.asList("structs", "spring"));
	System.out.println("after removeAll => " + ls.toString());
	System.out.println("size=>" + ls.size());
	System.out.println("after toArray() => "
		+ Arrays.toString(ls.toArray()));
    }
}
