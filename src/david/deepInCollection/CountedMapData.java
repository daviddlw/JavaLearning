package david.deepInCollection;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CountedMapData extends AbstractMap<Integer, String> {
    private int size;
    private static char[] characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	    .toCharArray();

    public CountedMapData(int size) {
	// TODO Auto-generated constructor stub
	this.size = size < 0 ? 0 : size;
    }

    private static class Entry implements Map.Entry<Integer, String> {
	private int index;

	protected Entry(int index) {
	    // TODO Auto-generated constructor stub
	    this.index = index;
	}

	@Override
	public Integer getKey() {
	    // TODO Auto-generated method stub
	    return index;
	}

	@Override
	public String getValue() {
	    // TODO Auto-generated method stub
	    return characters[index % characters.length]
		    + Integer.toString(index / characters.length);
	}

	@Override
	public String setValue(String value) {
	    // TODO Auto-generated method stub
	    throw new UnsupportedOperationException();
	}

    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
	// TODO Auto-generated method stub
	Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<Map.Entry<Integer, String>>();
	for (int i = 0; i < size; i++) {
	    entries.add(new Entry(i));
	    System.out.println();
	}

	return entries;
    }
}
