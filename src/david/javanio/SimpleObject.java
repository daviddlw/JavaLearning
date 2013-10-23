package david.javanio;

import java.io.Serializable;
import java.util.Calendar;

public class SimpleObject implements Serializable {
    /**
     * 包含内部自定义类引用的简单对象
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private SimpleType type = new SimpleType("");
    private Calendar birth;

    public SimpleObject() {
	// TODO Auto-generated constructor stub
    }

    public SimpleObject(int id, String name) {
	this.id = id;
	this.name = name;
	this.type = new SimpleType(id + "_" + name + "_type");
	this.birth = Calendar.getInstance();
	this.birth.set(1988, 1, 10, 0, 0, 0);
    }

    public int id() {
	return id;
    }

    public String name() {
	return name;
    }

    public SimpleType simpleType() {
	return type;
    }    

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "id: " + id + " => name: " + name + " type: " + type
		+ " birth: " + birth.getTime().toString();
    }
}
