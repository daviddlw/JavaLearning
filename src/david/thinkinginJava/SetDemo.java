package david.thinkinginJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetDemo {
    public static void setCollectionDemo() {
	Set<Integer> set = new HashSet<Integer>();
	set.add(1);
	set.add(2);
	set.add(1);
	System.out.println(set.toString());
	Map<String, Integer> mapDic = new HashMap<String, Integer>();
	mapDic.put("david", new Man().id());
	mapDic.put("helloworld", new Man().id());
	System.out.println(mapDic.toString());
	System.out.println(mapDic.containsKey("helloworld"));
	System.out.println(mapDic.get("helloworld"));
    }
}
