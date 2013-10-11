package david.generic;

import java.util.ArrayList;
import java.util.List;

public class CarFactory<T> {
	
	private List<T> ls;
	public CarFactory() {
		// TODO Auto-generated constructor stub
		 ls = new ArrayList<T>();	
	}
	
	public void addObj(T obj) {
		ls.add(obj);
	}
	
	public List<T> getObj() {
		return ls;
	}
}
