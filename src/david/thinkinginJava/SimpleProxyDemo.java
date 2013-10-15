package david.thinkinginJava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 代理类相当于C#里面的委托
 */
interface IAction {
	public void doSomething();

	public void doSomethingElse(String args);
}

class NormalAction implements IAction {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Do somethings!");
	}

	@Override
	public void doSomethingElse(String args) {
		// TODO Auto-generated method stub
		System.out.println("Do somethings else " + args);
	}

}

/*
 * 采用装饰者模式
 */
class SimpleProxy implements IAction {
	private IAction proxy;

	public SimpleProxy() {
		// TODO Auto-generated constructor stub
	}

	public SimpleProxy(IAction proxy) {
		this.proxy = proxy;
	}

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("Proxy do somethings.");
		proxy.doSomething();
	}

	@Override
	public void doSomethingElse(String args) {
		// TODO Auto-generated method stub
		System.out.println("Proxy do somethings else");
		proxy.doSomethingElse(args);
	}
}

class DynamicProxyHandler implements InvocationHandler {
	private Object proxys;

	public DynamicProxyHandler() {
		// TODO Auto-generated constructor stub
	}

	public DynamicProxyHandler(Object proxy) {
		this.proxys = proxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Proxy => " + proxy.getClass() + " Method => "
				+ method + " args => " + args);
		if (args != null) {
			for (Object arg : args) {
				System.out.println(" " + arg);
			}			
		}
		
		return method.invoke(proxys, args);
	}
}

class SimpleDynamicProxy{
	private static void dynamicActionDemo(IAction action) {
		action.doSomething();
		action.doSomethingElse("david.dai");
	}
	
	public static void dynamicSimpleProxyDemo() {
		NormalAction na = new NormalAction();
		dynamicActionDemo(na);
		IAction proxy = (IAction)Proxy.newProxyInstance(IAction.class.getClassLoader(), new Class<?>[]{IAction.class}, new DynamicProxyHandler(na));
		dynamicActionDemo(proxy);
	}
}

/*
 * 代理类模型
 */
public class SimpleProxyDemo {
	private static void actionDemo(IAction action) {
		action.doSomething();
		action.doSomethingElse("david.dai");
	}

	public static void simpleProxyDemo() {
		System.out.println("Normal do somethings");
		actionDemo(new NormalAction());
		System.out.println("----------------------------");
		actionDemo(new SimpleProxy(new NormalAction()));
	}
}
