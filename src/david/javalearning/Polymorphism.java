package david.javalearning;

public class Polymorphism
{
	public static void TransferNumbers()
	{
		double doubleNum = 123.123;
		int intNum = (int)doubleNum;
		System.out.println(intNum);		
	}
	
	public static void TransferFloatToDouble()
	{
		float num = 123.123f;
		double doubleNum = (double)num;
		System.out.println(doubleNum);
	}
	
	public static void PolymorphismSample()
	{
		Graphics rectGraphics = new Rectangle(10, 20);
		 rectGraphics.getColor();
		 System.out.println(rectGraphics.getSquare());
		
		 Graphics roundGraphics = new Round(4);
		 roundGraphics.getColor();
		 System.out.printf("%.2f\n", roundGraphics.getSquare());
		
		 Graphics squareGraphics = new Square(5);
		 squareGraphics.getColor();
		 System.out.println(squareGraphics.getSquare());
		
		 boolean flag = (squareGraphics instanceof Round);
		 System.out.println(flag);

		 Square squareOne = new Square();
		 squareOne.getInfo();
		 Square squareTwo = squareOne;
		 squareOne.setInfo("change to david name~");
		 squareOne.getInfo();
		 squareTwo.getInfo();

		 Polymorphism.TransferNumbers();
		 Polymorphism.TransferFloatToDouble();
	}
}
