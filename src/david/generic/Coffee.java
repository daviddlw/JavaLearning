package david.generic;

import java.awt.List;

public class Coffee {
    private static int counter = 1;
    private final int id = counter++;

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return this.getClass().getSimpleName() + "_" + id;
    }
}

class Latte extends Coffee {
}

class Mocha extends Coffee {
}

class Cappuccino extends Coffee {
}

class Americano extends Coffee {
}

class Breve extends Coffee {
}
