package david.generic;

public class Manipulator {
    public static void testManipulator() {
	HasF hf = new HasF();
	ManipulatorClass<HasF> mc = new ManipulatorClass<HasF>(hf);
	mc.ManipulatorExecute();
    }
}

class HasF {
    public void f() {
	System.out.println("You execute the method f();");
    }
}

class ManipulatorClass<T extends HasF> {
    private T obj;

    public ManipulatorClass() {
	// TODO Auto-generated constructor stub
    }

    public ManipulatorClass(T obj) {
	this.obj = obj;
    }
    
    public void ManipulatorExecute() {
	obj.f();
    }
}