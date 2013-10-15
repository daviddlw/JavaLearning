package david.util;

import java.lang.reflect.Method;

public class HiddenImp {
	public static IDemoInteface makeDemoClass() {
		return new DemoImp();
	}
	
	public static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method m = a.getClass().getDeclaredMethod(methodName);
		m.setAccessible(true);
		m.invoke(a);
	}
}

class DemoImp implements IDemoInteface{
	
	private void privateFun(){
		System.out.println("Private fun method has been executed!");
	}
	
	protected void protectedFun(){
		System.out.println("Protected fun method has been executed!");
	}
	
	@Override
	public void fun() {
		// TODO Auto-generated method stub
		System.out.println("Public fun method has been executed!");
	}	
}
