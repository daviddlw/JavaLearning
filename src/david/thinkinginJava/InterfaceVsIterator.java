package david.thinkinginJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterfaceVsIterator {

    public static void display(Iterator<Pet> it) {
	while (it.hasNext()) {
	    Pet pet = it.next();
	    System.out.println(pet.id() + " : " + pet.name());
	}
    }

    public static void display(Collection<Pet> collection) {

	for (Pet pet : collection) {
	    System.out.println(pet.id() + " ：" + pet.name());
	}
    }

    public static void interfaceVsIteratorDemo() {
	List<Pet> petsLs = new ArrayList<Pet>(Arrays.asList(new Pet[] {
		new Pet(), new Pet(), new Pet(), new Pet(), new Pet() }));

	Set<Pet> petsSet = new HashSet<Pet>(Arrays.asList(new Pet[] {
		new Pet(), new Pet(), new Pet(), new Pet(), new Pet() }));

	Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();
	String[] names = new String[] { "daviddai", "lavezhang", "karlzhao",
		"sherryzhu", "sharpingwang" };

	for (String item : names) {
	    petMap.put(item, new Pet());
	}
	
	System.out.println("Iterator方式展现数据：\n");
	display(petsLs.iterator());
	System.out.println("-----------");
	display(petsSet.iterator());
	System.out.println("Collection循环方式展示数据：\n");
	display(petsLs);
	System.out.println("-----------");
	display(petsSet);
	System.out.println("Map部分展示：\n");
	System.out.println(petMap);
	System.out.println("Keys:");
	System.out.println(petMap.keySet());
	System.out.println("Values:");
	display(petMap.values());
	System.out.println("-----------");
	display(petMap.values().iterator());
	
    }
}
