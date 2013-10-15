package david.thinkinginJava;

import java.util.ArrayList;
import java.util.List;

public class PetCreatorByName extends PetCreator {

	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	private static String[] typesStrings = new String[] { Cat.class.getName(),
			Dog.class.getName(), Fish.class.getName() };

	static {
		loader();
	}

	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String typeName : typesStrings) {
				types.add((Class<? extends Pet>) Class.forName(typeName));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}

}
