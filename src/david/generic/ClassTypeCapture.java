package david.generic;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    private Class<T> type;
    private Map<String, Class<T>> classMap;

    public ClassTypeCapture() {
	// TODO Auto-generated constructor stub
    }

    public ClassTypeCapture(Class<T> type) {
	this.type = type;
    }

    public boolean isInstance(Object obj) {
	return type.isInstance(obj);
    }

    public void addType(String type, Class<T> kind) {
	classMap = new HashMap<String, Class<T>>();
	classMap.put(type, kind);
    }

    public T createNew(String key) {
	T obj = null;
	try {
	    if (classMap.isEmpty() || classMap.get(key) == null) {
		System.err.println("Map没有对应的key值");
		return obj;
	    }
	    obj = (T) (classMap.get(key).newInstance());
	} catch (Exception e) {
	    System.err.println("当前类未定义");
	    // TODO: handle exception
	}
	return obj;
    }
}

class Building {
}

class House extends Building {
}
