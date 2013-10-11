package david.javalearning;

public class Square extends Graphics
{
	private double _width = 0;
	private String _information = "";

	public Square(double width)
	{
		this._width = width;
	}

	public Square()
	{
		this._width = 0;
	}

	public double getSquare()
	{
		_square = Math.pow(_width, 2);
		return _square;
	}

	public void getColor()
	{
		System.out.println("Square Color " + this._color.toString());
	}

	public void getInfo()
	{
		System.out.println(this._information == "" ? "Empty String"
				: this._information.toString());
	}

	public void setInfo(String information)
	{
		this._information = information;
	}
}
