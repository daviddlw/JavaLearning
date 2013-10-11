package david.javalearning;

public class Round extends Graphics
{
	private double _radius = 0;
	private final static double PIE = Math.PI;

	public Round()
	{
		this._radius = 0;
	}
	
	public Round(double radius)
	{
		this._radius = radius;
	}

	public double getSquare()
	{
		_square = PIE * Math.pow(_radius, 2);		
		return _square;
	}
	
	public void getColor()
	{
		System.out.println("Round Color");
	}
}
