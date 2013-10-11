package david.javalearning;

public class Woman extends Human
{

	public Woman()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Human getBirth()
	{
		System.out.println("Give Birth");
		return (new Human());
	}
	
	public void setHeight(double height)
	{
		this._height = height;
	}
}
