package david.generic;

public class ActionImp implements IFly, IRun {

    public ActionImp() {
	// TODO Auto-generated constructor stub
    }
    
    @Override
    public void run() {
	// TODO Auto-generated method stub
	System.out.println("I can run...");
    }

    @Override
    public void fly() {
	// TODO Auto-generated method stub
	System.out.println("I can fly...");
    }    
}
