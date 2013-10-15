package david.deepInCollection;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private int capacity = 10000;
    private List<Exception> exceptions = new LinkedList<Exception>();
    private List<HashMap<K, V>> existHashMaps = new LinkedList<HashMap<K, V>>();
    private int count;

    @SuppressWarnings("unchecked")
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[capacity];

    public int getHashConflictCount() {
	return count;
    }

    public String getHashConflictExceptions() {
	return exceptions.toString();
    }

    public String getExistMaps() {
	return existHashMaps.toString();
    }

    public V put(K key, V value) {
	V oldValue = null;
	int index = Math.abs(key.hashCode()) % capacity;
	if (buckets[index] == null) {
	    buckets[index] = new LinkedList<MapEntry<K, V>>();
	} else {
	    count++;
	    exceptions.add(new Exception(String.format("{%s=%s}hash地址冲突", key,
		    value)));
	}
	LinkedList<MapEntry<K, V>> bucket = buckets[index];
	MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
	boolean hasFound = false;
	ListIterator<MapEntry<K, V>> li = bucket.listIterator();
	while (li.hasNext()) {
	    MapEntry<K, V> ipair = li.next();
	    if (ipair.getKey().equals(key)) {
		HashMap<K, V> tempMap = new HashMap<K, V>();
		existHashMaps.add(tempMap);
		oldValue = ipair.getValue();
		li.set(pair);
		hasFound = true;
		break;
	    }
	}
	if (!hasFound) {
	    buckets[index].add(pair);
	}

	return oldValue;
    }

    public V get(Object key) {

	int index = Math.abs(key.hashCode()) % capacity;
	if (buckets[index] == null)
	    return null;
	for (MapEntry<K, V> mapEntry : buckets[index]) {
	    if (mapEntry.getKey().equals(key)) {
		return mapEntry.getValue();
	    }
	}
	return null;
    }

    /*
     * 返回旧的被删除的元素
     */
    public V remove(Object key) {
	V oldValue = null;
	int index = Math.abs(key.hashCode()) % capacity;
	if (buckets[index] == null)
	    return null;
	for (int i = 0; i < buckets[index].size(); i++) {
	    if (buckets[index].get(i).getKey().equals(key)) {
		oldValue = buckets[index].get(i).getValue();
		buckets[index].remove(i);
	    }
	}
	return oldValue;
    }

    /*
     * 清理方法
     */
    public void clear() {
	for (int i = 0; i < buckets.length; i++) {
	    if (buckets[i] == null)
		continue;
	    for (int j = 0; j < buckets[i].size(); j++) {
		buckets[i].remove(j);
	    }
	}
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
	// TODO Auto-generated method stub
	Set<Map.Entry<K, V>> hashset = new HashSet<Map.Entry<K, V>>();
	for (LinkedList<MapEntry<K, V>> bucket : buckets) {
	    if (bucket == null)
		continue;
	    for (MapEntry<K, V> mapEntry : bucket) {
		hashset.add(mapEntry);
	    }
	}

	return hashset;
    }

}
