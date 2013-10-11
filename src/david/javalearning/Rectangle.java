package david.javalearning;

public class Rectangle extends Graphics
{
	private int _width = 0;
	private int _height = 0;

	public Rectangle()
	{
		this._width = 0;
		this._height = 0;
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int height)
	{
		this._width = width;
		this._height = height;
	}

	public double getSquare()
	{
		_square = _width * _height;
		return _square;
	}
	
	public void getColor()
	{
		System.out.println("Square Color");
	}
}
