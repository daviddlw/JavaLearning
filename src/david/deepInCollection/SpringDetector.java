package david.deepInCollection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * ²âÊÔhashcode
 */
class GroundDog {
    protected int number;

    public GroundDog(int number) {
	// TODO Auto-generated constructor stub
	this.number = number;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return String.format("GroundDog# %d(%s)", number, super.hashCode());
    }

    @Override
    public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
    }
}

class OverrideGroundDog extends GroundDog {

    public OverrideGroundDog(int number) {
	super(number);
	// TODO Auto-generated constructor stub
    }

    @Override
    public int hashCode() {
	// TODO Auto-generated method stub
	return number;
    }

    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	if (obj instanceof GroundDog) {
	    return ((GroundDog) obj).number == number;
	} else {
	    return false;
	}
    }

}

class Prediction {
    private Random rand = new Random(5);
    boolean weatherFlag = rand.nextDouble() > 0.5;

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	if (weatherFlag) {
	    return "Six more weeks of winter";
	} else {
	    return "Early spring";
	}
    }
}

public class SpringDetector {
    public static <T extends GroundDog> void detectSpring(Class<T> type)
	    throws Exception {
	Constructor<T> constructor = type.getConstructor(int.class);
	Map<GroundDog, Prediction> map = new HashMap<GroundDog, Prediction>();
	for (int i = 0; i < 10; i++) {
	    map.put(constructor.newInstance(i), new Prediction());
	}
	System.out.println(map.toString());
	GroundDog groundDog = constructor.newInstance(3);
	System.out.println("Search for " + groundDog.toString());
	if (map.containsKey(groundDog)) {
	    System.out.println("We has found the object => " + map.get(groundDog));
	} else {
	    System.out.println("no elements");
	}
    }
}
