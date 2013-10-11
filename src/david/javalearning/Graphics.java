package david.javalearning;
import java.awt.Color;

public abstract class Graphics
{
	protected Color _color;
	protected double _square;

	public double getSquare()
	{
		return this._square;
	};

	public Graphics()
	{
		this._color = Color.blue;
		this._square = 0;
	}
	
	public Graphics(Color color)
	{
		this._color = color;
		this._square = 0;
	}
	
	public void getColor()
	{
		System.out.println(this._color);
	}
}
