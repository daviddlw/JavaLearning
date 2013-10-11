package david.javalearning;

import java.util.Comparator;

import david.thinkinginJava.CompType;

public class CompTypeComparator implements Comparator<CompType>
{
	public CompTypeComparator()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(CompType o1, CompType o2)
	{
		return (o1.j < o2.j ? -1 : (o1.j == o2.j ? 0 : 1));
	}
}
