package david.deepInCollection;

import java.util.AbstractList;

public class CountIntegerList extends AbstractList<Integer> {
    private int size;

    public CountIntegerList(int size) {
	this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
	// TODO Auto-generated method stub
	return Integer.valueOf(index);
    }

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return size;
    }
}
