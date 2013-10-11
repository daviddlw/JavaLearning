package david.javalearning;

public class CustomThread extends Thread
{
	private static int _threadId = 0;

	public CustomThread()
	{
		super(String.format("Id: %s", ++_threadId));
		// TODO Auto-generated constructor stub
	}
	
	public String toString()
	{
		return super.getName();
	}
	
	public void run()
	{
		System.out.println(this);
	}

}
