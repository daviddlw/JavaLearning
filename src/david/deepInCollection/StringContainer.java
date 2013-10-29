package david.deepInCollection;

public class StringContainer implements Comparable {

    private String id;
    private String name;

    public StringContainer(String id, String name) {
	// TODO Auto-generated constructor stub
	this.id = id;
	this.name = name;
    }

    @Override
    public int compareTo(Object o) {
	if (!(o instanceof StringContainer))
	    return -1;

	StringContainer tempObj = (StringContainer) o;
	return id.compareTo(tempObj.id);
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format("{id:%s,name:%s}", id, name);
    }

}
