package david.javalearning;

public class Human
{
	
	protected double _height = 0;
	
	public Human()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Human(double height)
	{
		this._height = height;
	}
	
	public double getHeight()
	{
		return this._height;
	}
	
	public void growHeight(double height)
	{
		this._height = this._height+height;
	}
}
