package david.javalearning;

public class CustomThreadRunnable implements Runnable
{

	public CustomThreadRunnable()
	{
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return Thread.currentThread().getName();
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println(this);
	}

}
