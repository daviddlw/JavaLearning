package david.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionUtils {
    
    public static <K, V> Map<K, V> hashMap() {
	return new HashMap<K, V>();
    }
    
    public static <T> List<T> linkedList() {
	return new LinkedList<T>();
    }
    
    public static <T> List<T> arrayList() {
	return new ArrayList<T>();	
    }
    
    public static <T> Set<T> hashSet() {
	return new HashSet<T>();
    }
    
    public static <T> Queue<T> queue() {
	return new LinkedList<T>();	
    }
    
    public static <T> Set<T> intersect(Set<T> s1, Set<T> s2) {
	Set<T> hs = new HashSet<T>(s1);
	hs.retainAll(s2);
	return hs;
    }
    
    public static <T> Set<T> unionAll(Set<T> s1, Set<T> s2) {
	Set<T> hs = new HashSet<T>(s1);
	hs.addAll(s2);
	return hs;
    }
    
    public static <T> Set<T> different(Set<T> s1, Set<T> s2) {
	Set<T> hs = new HashSet<T>(s1);
	hs.removeAll(s2);
	return hs;	
    }
    
    public static <T> Set<T> complement(Set<T> s1, Set<T> s2) {	
	return different(unionAll(s1, s2), intersect(s1, s2));
    }
    
    /*
     * 转换Object[]数组为List<T>列表
     */
    public static <T> List<T> transformList(Object[] objArr) {
	@SuppressWarnings("unchecked")
	List<T> ls = (List<T>) Arrays.asList(objArr);
	return new ArrayList<T>(ls);
    }
}
