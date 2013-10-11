package david.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import david.thinkinginJava.Pet;

public class CoffeeCheck {
	
	@SuppressWarnings({ "unchecked", "unused" })
	private static void coffeeAdd(List coffeeLs) {
		coffeeLs.add(new Latte());
		System.out.println(coffeeLs.toString());
	}
	
	public static void coffeeCheck() {
		List<Mocha> mochaLs = new ArrayList<Mocha>();
		coffeeAdd(mochaLs);
				
		try {
			List<Mocha> mochaCheckLs = Collections.checkedList(new ArrayList<Mocha>(), Mocha.class);
			coffeeAdd(mochaCheckLs);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
		List<Coffee> coffeeLs = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
		coffeeLs.add(new Latte());
		coffeeLs.add(new Mocha());
		coffeeLs.add(new Cappuccino());
		System.out.println(coffeeLs.toString());
	}
}
