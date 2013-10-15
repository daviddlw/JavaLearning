package david.generic;

public class Fruit {
    protected String name;

    public Fruit(String name) {
	// TODO Auto-generated constructor stub
	this.name = name;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return name.toString();
    }
}

class Apple extends Fruit{
    public Apple(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}

class Orange extends Fruit{
    
    public Orange(String name) {
	super(name);
	// TODO Auto-generated constructor stub
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
