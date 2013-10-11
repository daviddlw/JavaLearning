package david.thinkinginJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {
    private static final String[] testArray = new String[] { "ShowWhite",
	    "StarCraftII", "WarCraft", "HelloWorld", "ReadyGo" };

    public static void generateCollection(CollectionType type) {
	switch (type) {
	case ArrayList:
	    List<String> als = new ArrayList<String>();	  
	    System.out.println("ArrayList => " + printList(testArray, als));
	    break;
	case LinkedList:
	    List<String> lls = new LinkedList<String>();
	    System.out.println("LinkedList => " + printList(testArray, lls));
	    break;
	case HashSet:
	    Set<String> hSet = new HashSet<String>();
	    System.out.println("HashSet => " + printList(testArray, hSet));
	    break;
	case LinkedHashSet:
	    Set<String> lhSet = new LinkedHashSet<String>();
	    System.out.println("LinkedHashSet => "
		    + printList(testArray, lhSet));
	    break;
	case TreeSet:
	    Set<String> tSet = new TreeSet<String>();
	    System.out.println("TreeSet => " + printList(testArray, tSet));
	    break;
	default:
	    break;
	}
    }

    /*
     * 输出List<T>结果
     */
    private static String printList(String[] arr, List<String> ls) {
	for (String item : arr) {
	    ls.add(item);
	}
	return ls.toString();
    }

    /*
     * 输出Set<T>结果
     */
    private static String printList(String[] arr, Set<String> ls) {
	for (String item : arr) {
	    ls.add(item);
	}
	return ls.toString();
    }
}
