package david.thinkinginJava;

import java.util.Random;

public class CompType implements Comparable<CompType>
{

	public int i;
	public int j;
	private static int count = 1;
	private static Random rand = new Random(47);

	public CompType(int x, int y)
	{
		i = x;
		j = y;
	}

	@Override
	public String toString()
	{
		String result = String.format("[i = %d, j = %d]", i, j);
		if (count++ % 3 == 0)
			result += "\n";

		return result;
	}

	@Override
	public int compareTo(CompType rv)
	{
		return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
	}
}
