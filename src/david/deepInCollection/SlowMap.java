package david.deepInCollection;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

	public V put(K key, V value) {
		V oldValue = get(key);

		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else {
			values.set(keys.indexOf(key), value);
		}

		return oldValue;
	}

	public V get(Object key) {
		if (!keys.contains(key))
			return null;

		int index = keys.indexOf(key);
		return values.get(index);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		Iterator<K> kIterator = keys.listIterator();
		Iterator<V> vIterator = values.listIterator();
		while (kIterator.hasNext()) {
			set.add(new MapEntry<K, V>(kIterator.next(), vIterator.next()));
		}

		return set;
	}
}

class MapEntry<K, V> implements Map.Entry<K, V> {

	private K key;
	private V value;

	public MapEntry(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V result = value;
		this.value = value;
		return result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key + "=" + value;
	}

//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return ((key == null) ? 0 : key.hashCode())
//				^ ((value == null) ? 0 : value.hashCode());
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof MapEntry))
//			return false;
//
//		MapEntry mEntry = (MapEntry) obj;
//		return (key == null ? mEntry.getKey() == null : mEntry.getKey().equals(
//				key))
//				&& (value == null ? mEntry.getValue() == null : mEntry
//						.getValue().equals(value));
//	}

}
