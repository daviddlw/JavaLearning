package david.thinkinginJava;

public class OptionTrailingArguments {

	public void showArrayItems(int index, Object[] array) {
		System.out.print("Index: " + index + "=>");
		for (Object item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
		System.out.println("--------------------------");
	}
	
}
