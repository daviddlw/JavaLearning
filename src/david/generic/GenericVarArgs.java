package david.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericVarArgs {
    
    public static <T> void makeList(T... args) {
	List<T> ls = new ArrayList<T>();
	for (T arg : args) {
	    ls.add(arg);
	}
	
	System.out.println(ls.toString());
    }
}
