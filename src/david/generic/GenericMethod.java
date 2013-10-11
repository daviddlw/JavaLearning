package david.generic;

import java.util.EnumSet;
import java.util.Map;

import david.util.CollectionUtils;

public class GenericMethod {

    public static <T> void showGenericMethodInfo(T t) {
	System.out.println(t.getClass().getName());
    }

    public static <T> void showGenericMethodInfo(T t1, T t2, T t3) {
	String information = String.format("t1=> %s | t2=> %s | t3=> %s", t1
		.getClass().getName(), t2.getClass().getName(), t3.getClass()
		.getName());
	System.out.println(information);
    }

    public static <T> void showGenericMethodInfo(T t1, T t2, String t3) {
	String information = String.format("t1=> %s | t2=> %s | t3=> %s", t1
		.getClass().getName(), t2.getClass().getName(), t3.getClass()
		.getName());
	System.out.println("Contains string parameters=>" + information);
    }

    public static void showGenericMethodInfoWithParams(Map<Integer, String> map) {
	System.out.println(map.getClass().getName());

    }

    /*
     * ªÒ»°sum÷µ
     */
    public static double sum(Integer... integers) {
	double total = 0;
	for (int i = 0; i < integers.length; i++) {
	    total += integers[i];
	}
	return total;
    }

    public static void collectionUtilDemo() {
	EnumSet<WaterColor> hs = EnumSet.range(WaterColor.ZINC,
		WaterColor.SAP_GREEN);
	EnumSet<WaterColor> hs2 = EnumSet.range(WaterColor.PERMANENT_GREEN,
		WaterColor.IVORY_BLACK);

	System.out.println(CollectionUtils.intersect(hs, hs2));
	System.out.println(CollectionUtils.unionAll(hs, hs2));
	System.out.println(CollectionUtils.different(hs, hs2));
	System.out.println(CollectionUtils.complement(hs, hs2));
    }
}
