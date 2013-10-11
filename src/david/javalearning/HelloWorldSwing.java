package david.javalearning;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloWorldSwing {

    public HelloWorldSwing() {
	
    }
    
    public static void createAndShowGUI() {
	JFrame jFrame = new JFrame("Hello World");
	jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	
	java.awt.Container cp = jFrame.getContentPane();
	cp.setLayout(new FlowLayout());
	
	JButton jButtonClick = new JButton("Click Me");
	JButton jButtonShit = new JButton("Shit");
	
	cp.add(jButtonClick);
	cp.add(jButtonShit);
	
	jFrame.pack();
	jFrame.setVisible(true);
    }
}
