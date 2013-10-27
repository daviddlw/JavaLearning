package david.meeting;

public class UseCaseDemo {

    public static int result = 0;

    public void add(int n) {
	result += n;
    }

    public void substract(int n) {
	result = n - 1;
    }

    public void mutiply(int n) {

    }

    public void divide(int a, int b) {
	try {
	    result = a / b;
	} catch (ArithmeticException e) {
	    // TODO: handle exception
	    throw e;
	}
    }

    public void clear() {
	result = 0;
    }

    public int result() {
	return result;
    }

    public void square() {
	while (true) {

	}
    }
}
