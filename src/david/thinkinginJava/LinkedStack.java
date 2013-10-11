package david.thinkinginJava;

public class LinkedStack<T> {
    /*
     * ÄÚ²¿¶ÑÕ»Àà
     */
    private static class Node<U> {
	U item;
	Node<U> next;

	private Node() {
	    // TODO Auto-generated constructor stub
	    item = null;
	    next = null;
	}

	private Node(U item, Node<U> next) {
	    this.item = item;
	    this.next = next;
	}

	boolean end() {
	    return item == null && next == null;
	}
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
	top = new Node<T>(item, top);
    }

    public T pop() {
	T result = top.item;
	if (!top.end()) {
	    top = top.next;
	}
	return result;
    }
}
