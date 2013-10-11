package david.generic;

import java.util.*;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class<?>[] types = new Class[] { Latte.class, Mocha.class,
	    Cappuccino.class, Americano.class, Breve.class };

    private Random rand = new Random();
    private int size = 0;

    public CoffeeGenerator() {
	// TODO Auto-generated constructor stub
    }

    public CoffeeGenerator(int size) {
	this.size = size;
    }

    @Override
    public Coffee next() {
	Coffee coffee = null;
	try {
	    coffee = (Coffee) types[rand.nextInt(types.length)].newInstance();

	    return coffee;
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	return coffee;
    }

    class CoffeeIterator implements Iterator<Coffee> {
	int count = size;

	@Override
	public boolean hasNext() {
	    // TODO Auto-generated method stub
	    return count > 0;
	}

	@Override
	public Coffee next() {
	    // TODO Auto-generated method stub
	    count--;
	    return CoffeeGenerator.this.next();
	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub
	    System.err.println("暂不支持字方法");
	}
    }

    @Override
    public Iterator<Coffee> iterator() {
	// TODO Auto-generated method stub
	return new CoffeeIterator();
    }
}
