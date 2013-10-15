package david.thinkinginJava;

import java.awt.Robot;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

interface IOperation {
    String description();

    void command();
}

interface IRobot {
    String name();

    String model();

    List<IOperation> operations();
}

class DavidRobot implements IRobot {

    private String name;
    private static int count = 0;

    public DavidRobot(String name) {
	// TODO Auto-generated constructor stub
	this.name = name;
    }

    @Override
    public String name() {
	// TODO Auto-generated method stub
	return name;
    }

    @Override
    public String model() {
	// TODO Auto-generated method stub
	return name + "_model";
    }

    @Override
    public List<IOperation> operations() {
	// TODO Auto-generated method stub
	List<IOperation> ls = Arrays.asList(new IOperation[] {
		new IOperation() {

		    @Override
		    public String description() {
			// TODO Auto-generated method stub
			return String.format("Robot %s can play a game", name);
		    }

		    @Override
		    public void command() {
			count++;
			// TODO Auto-generated method stub
			System.out.println(String.format("Robot %s is playing a game", name));
		    }
		}, new IOperation() {
		    
		    @Override
		    public String description() {
			// TODO Auto-generated method stub
			return String.format("Robot %s can swim", name);
		    }

		    @Override
		    public void command() {
			
			// TODO Auto-generated method stub
			System.out.println(String.format("Robot %s is swiming", name));
		    }
		} });

	return ls;
    }
}

public class RobotDemo {
    /*
     * 显示具体机器人信息
     */
    private static void showRobotInfos(IRobot robot) {
	if (robot instanceof DavidRobot) {
	    System.out.println("Robot name => " + robot.name());
	    System.out.println("Robot model => " + robot.model());
	    System.out.println("Robot operations =>\n");
	    for (IOperation operation : robot.operations()) {
		System.out.println(operation.description());
		operation.command();
	    }
	} else {
	    System.out.println("This is a null objective");
	}
    }

    public static void robotDemo() {
	showRobotInfos(new DavidRobot("david.dai"));
    }
}
