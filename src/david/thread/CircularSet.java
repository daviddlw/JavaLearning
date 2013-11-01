package david.thread;

public class CircularSet {
	private int[] array;
	private int length;
	private int index = 0;

	public CircularSet(int size) {
		// TODO Auto-generated constructor stub
		length = size;
		array = new int[size];
		// ≥ı ºªØ
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
	}

	public void add(int num) {
		array[index] = num;
		index = ++index % length;
	}

	public boolean contains(int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num)
				return true;
		}
		return false;
	}
}

class SerialNumberGenerator extends IntGenerator {
	private static volatile int currentValue = 0;
	@Override
	public int next() {
		// TODO Auto-generated method stub
		return currentValue++;
	}

}
