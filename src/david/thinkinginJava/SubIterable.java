package david.thinkinginJava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class SubIterable implements Iterable<String> {

    protected String[] wordStrings = new String[] { "daviddai", "lavezhang",
	    "karlzhao", "fanfang", "sharpingwang" };

    @Override
    public Iterator<String> iterator() {
	return new Iterator<String>() {
	    private int index = 0;
	    private Queue<String> ls = new LinkedList<String>(Arrays.asList(wordStrings));
	    @Override
	    public boolean hasNext() {
		return index < wordStrings.length;
	    }

	    @Override
	    public String next() {
		return wordStrings[index++];
	    }

	    @Override
	    public void remove() {
		if(ls.isEmpty())
		    ls.poll();
	    }
	};
    }

}
