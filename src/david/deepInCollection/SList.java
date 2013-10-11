package david.deepInCollection;

import java.util.ArrayList;
import java.util.List;

public class SList<T> {
    private List<T> ls;
    private SList<T> next;

    public SList(SList<T> item, T t) {
	if (ls == null) {
	    ls = new ArrayList<T>();
	}
	// TODO Auto-generated constructor stub
	if (t != null) {
	    this.next = item;
	    ls.add(t);
	} else {
	    next = null;
	}
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return ls.toString();
    }

    public SListIterator iterator() {
	return new SListIterator();
    }

    private class SListIterator {

	private int index;

	@SuppressWarnings("unused")
	public boolean hasNext() {
	    // TODO Auto-generated method stub
	    return index < ls.size();
	}

	@SuppressWarnings("unused")
	public T next() {
	    // TODO Auto-generated method stub
	    return ls.get(index++);
	}

	@SuppressWarnings("unused")
	public void remove() {
	    // TODO Auto-generated method stub
	    ls.remove(index);
	}
    }
}
