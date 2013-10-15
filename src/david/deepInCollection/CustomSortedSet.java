package david.deepInCollection;

import java.util.Collection;
import java.util.LinkedList;

public class CustomSortedSet<T> {
    private int size = 0;
    private LinkedList<T> linkedLs = new LinkedList<T>();

    public void addAll(Collection<T> collections) {

	for (T t : collections) {
	    add(t);
	}
    }

    /*
     * ��������ջ������(��ʱջ���汣�����Ѿ��ź���ıȵ�ǰԪ�ش�ļ���)
     */
    public void add(T item) {
	// ��������ظ���Ԫ��
	if (linkedLs.isEmpty()) {
	    linkedLs.push(item);
	} else {
	    LinkedList<T> tempLs = new LinkedList<T>();
	    while (!linkedLs.isEmpty()) {
		T top = linkedLs.peek();
		boolean flag = false;
		if (item.getClass() == Integer.class) {
		    flag = ((Integer) top).compareTo((Integer) item) > 0;
		} else {
		    flag = top.toString().compareTo(item.toString()) > 0;
		}
		if (flag) {
		    tempLs.push(linkedLs.poll());
		} else {
		    linkedLs.push(item);
		    while (!tempLs.isEmpty()) {
			linkedLs.push(tempLs.poll());
		    }
		    break;
		}
	    }
	    if (linkedLs.isEmpty()) {
		linkedLs.push(item);
		while (!tempLs.isEmpty()) {
		    linkedLs.push(tempLs.poll());
		}
	    }
	}
	size++;
    }

    public boolean remove(T item) {
	return linkedLs.remove(item);
    }

    public int size() {
	return size;
    }

    @Override
    public String toString() {
	LinkedList<T> ls = new LinkedList<T>();
	while (!linkedLs.isEmpty()) {
	    ls.push(linkedLs.poll());
	}
	return ls.toString();
    }
}
