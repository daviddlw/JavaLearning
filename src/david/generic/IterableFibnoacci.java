package david.generic;

import java.util.Iterator;

public class IterableFibnoacci implements Iterable<Integer> {

    private int count = 0;

    public IterableFibnoacci(int count) {
	this.count = count;
    }

    @Override
    public Iterator<Integer> iterator() {
	return new Iterator<Integer>() {

	    @Override
	    public boolean hasNext() {
		// TODO Auto-generated method stub
		return count > 0;
	    }

	    @Override
	    public Integer next() {
		// TODO Auto-generated method stub
		count--;
		return IterableFibnoacci.this.next();
	    }

	    @Override
	    public void remove() {
		// TODO Auto-generated method stub
		try {
		    throw new Exception("当前方法还不能支持");
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	};
    }

    protected Integer next() {
	// TODO Auto-generated method stub
	if (count < 2)
	    return 1;
	else
	    return (new IterableFibnoacci(count - 1)).next()
		    + (new IterableFibnoacci(count - 2)).next();
    }
}
