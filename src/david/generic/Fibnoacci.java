package david.generic;

public class Fibnoacci implements Generator<Integer> {

    private static int counter = 0;

    @Override
    public Integer next() {
	// TODO Auto-generated method stub	
	return fib(counter++);
    }

    private int fib(int count) {
	if (count < 2)
	    return 1;
	else
	    return fib(count - 2) + fib(count - 1);
    }

}
