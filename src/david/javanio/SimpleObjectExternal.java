package david.javanio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class SimpleObjectExternal implements Externalizable {

    private int id;
    private String name;
    private SimpleType type;

    public SimpleObjectExternal() {
	// TODO Auto-generated constructor stub
    }

    public SimpleObjectExternal(int id, String name) {
	// TODO Auto-generated constructor stub
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
	// TODO Auto-generated method stub
	out.writeInt(id);
	out.writeObject(name);
	out.writeObject(new SimpleType(id + "_" + name + "_type"));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
	    ClassNotFoundException {
	// TODO Auto-generated method stub
	id = in.readInt();
	name = (String) in.readObject();
	type = (SimpleType) in.readObject();
    }
}
