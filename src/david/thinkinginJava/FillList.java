package david.thinkinginJava;

import java.util.ArrayList;
import java.util.List;

class CountedInteger {
	private static int counter;
	private final int id = counter++;

	public String toString() {
		return Integer.toString(id);
	}
}

public class FillList<T> {
	
	private Class<T> type;
	public FillList(Class<T> type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}
	
	public List<T> create(int count) {
		List<T> ls = new ArrayList<T>();
		try {
			for (int i = 0; i < count; i++) {
				ls.add(type.newInstance());
			}
		} catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
		}
		return ls;
	}
	
	public static void filledListDemo() {
		
		FillList<CountedInteger> fl = new FillList<CountedInteger>(CountedInteger.class);		
		System.out.println(fl.create(15));
	}
}
