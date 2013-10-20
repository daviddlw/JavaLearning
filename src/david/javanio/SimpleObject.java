package david.javanio;

import java.io.Serializable;

public class SimpleObject implements Serializable {
    /**
     * 包含内部自定义类引用的简单对象
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private SimpleType type;

    public SimpleObject() {
	// TODO Auto-generated constructor stub
    }

    public SimpleObject(int id, String name) {
	this.id = id;
	this.name = name;
	this.type = new SimpleType(id + "_" + name + "_type");
    }

    public int id() {
	return id;
    }

    public String name() {
	return name;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "id: " + id + " => name: " + name + " type: " + type;
    }
}
