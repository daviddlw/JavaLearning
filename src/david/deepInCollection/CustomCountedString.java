package david.deepInCollection;

import java.util.ArrayList;
import java.util.List;

public class CustomCountedString {
    private static List<String> innerList = new ArrayList<String>();
    private int id = 0;
    private String s;

    public CustomCountedString(String sourceStr) {
	// TODO Auto-generated constructor stub
	s = sourceStr;
	innerList.add(s);
	for (String item : innerList) {
	    if (item.equals(s)) {
		id++;
	    }
	}
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format("String is %s, id is %d, hashcode() => %d", s, id,
		hashCode());
    }

    @Override
    public int hashCode() {
	// TODO Auto-generated method stub
	int result = 18;
	result = 37 * result + s.hashCode();
	result = 37 * result + id;
	// result = 37 * result;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	if (obj instanceof CustomCountedString)
	    return false;

	CustomCountedString countedString = (CustomCountedString) obj;
	return (s.equals(countedString.s)) && (id == countedString.id);
    }

}
