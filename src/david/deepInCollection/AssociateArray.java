package david.deepInCollection;

public class AssociateArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociateArray(int length) {
	// TODO Auto-generated constructor stub
	pairs = new Object[length][2];
    }

    public void put(K key, V value) {
	if (index < pairs.length) {
	    if (containsKey(key)) {
		pairs[getIndex(key)][1] = value;
	    } else {
		pairs[index++] = new Object[] { key, value };
	    }

	} else {
	    throw new ArrayIndexOutOfBoundsException();
	}
    }

    public boolean containsKey(K key) {
	boolean isExist = false;
	for (int i = 0; i < pairs.length; i++) {
	    if (pairs[i][0] != null && pairs[i][0].equals(key))
		isExist = true;
	}
	return isExist;
    }

    @SuppressWarnings("unchecked")
    public Integer getIndex(K key) {
	for (int i = 0; i < pairs.length; i++) {
	    if (key.equals(pairs[i][0]))
		return i;
	}

	return -1;
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
	for (int i = 0; i < pairs.length; i++) {
	    if (key.equals(pairs[i][0]))
		return (V) pairs[i][1];
	}

	return null;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < pairs.length; i++) {
	    if (pairs[i][0] != null) {
		sb.append(pairs[i][0]);
		sb.append(":");
		sb.append(pairs[i][1]);
		sb.append("\n");
	    }
	}
	return sb.toString();
    }
}
