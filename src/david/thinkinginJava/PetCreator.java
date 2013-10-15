package david.thinkinginJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class PetCreator {

	public abstract List<Class<? extends Pet>> types();

	public Map<String, Integer> fishMap = new HashMap<String, Integer>();
	public Map<String, Integer> dogMap = new HashMap<String, Integer>();
	public Map<String, Integer> catMap = new HashMap<String, Integer>();
	private static final String FISH_TYPE = Fish.class.getSimpleName();
	private static final String DOG_TYPE = Dog.class.getSimpleName();
	private static final String CAT_TYPE = Cat.class.getSimpleName();

	public PetCreator() {
		// TODO Auto-generated constructor stub
		fishMap.put(FISH_TYPE, 0);
		dogMap.put(DOG_TYPE, 0);
		catMap.put(CAT_TYPE, 0);
	}

	private Random rand = new Random();

	public Pet randomPet() {
		int index = rand.nextInt(types().size());
		Pet instance = null;
		try {
			instance = types().get(index).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return instance;
	}

	public Pet[] createArray(int size) {
		Pet[] pets = new Pet[size];
		for (int i = 0; i < pets.length; i++) {
			pets[i] = randomPet();
			if (pets[i] instanceof Fish) {
				fishMap.put(FISH_TYPE, fishMap.get(FISH_TYPE).intValue() + 1);
			}
			if (pets[i] instanceof Cat) {
				dogMap.put(DOG_TYPE, dogMap.get(DOG_TYPE).intValue() + 1);
			}
			if (pets[i] instanceof Dog) {
				catMap.put(CAT_TYPE, catMap.get(CAT_TYPE).intValue() + 1);
			}
		}
		return pets;
	}

	public List<Pet> arrayList(int size) {
		List<Pet> ls = new ArrayList<Pet>();
		Collections.addAll(ls, createArray(size));
		return ls;
	}

	public String toString() {
		String result = String.format("%s=>%d ¸ö, %s=>%d ¸ö, %s=>%d ¸ö",
				FISH_TYPE, fishMap.get(FISH_TYPE).intValue(), DOG_TYPE, dogMap
						.get(DOG_TYPE).intValue(), CAT_TYPE,
				catMap.get(CAT_TYPE).intValue());
		
		return result;
	}
}
