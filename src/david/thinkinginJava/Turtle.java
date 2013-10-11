package david.thinkinginJava;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {

    private String name;
    private Formatter formatter;

    public Turtle(String name, Formatter formatter) {
	// TODO Auto-generated constructor stub
	this.name = name;
	this.formatter = formatter;
    }

    public void move(int x, int y) {
	formatter.format("Turtle %s => current postion x: %d, y: %d\n",
		this.name, x, y);
    }
    
}
