package david.thinkinginJava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 接口
 */
interface IDoAction {
    public void sayHello(String sb);
}

/*
 * 实现类
 */
class DoActionImp implements IDoAction {

    private static int count = 0;

    @Override
    public void sayHello(String sb) {
	// TODO Auto-generated method stub
	System.out.println("Say hello to " + sb);
	count++;
	System.out.println("调用次数:" + count);

    }
}

/*
 * 代理类-常用范围AOP,面向切面
 */
class LogHandler implements InvocationHandler {

    private IDoAction handler;

    public LogHandler() {
	// TODO Auto-generated constructor stub
    }

    public LogHandler(IDoAction handler) {
	this.handler = handler;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
	    throws Throwable {
	// TODO Auto-generated method stub
	LogBefore();
	Object result = null;
	for (int i = 0; i < 3; i++) {
	    result = method.invoke(handler, args);
	}

	LogAfter();
	return result;
    }

    private void LogBefore() {
	System.out.println("Log Begin");
    }

    private void LogAfter() {
	System.out.println("Log After");
    }
}

/*
 * 动态代理实例
 */
public class DynamicProxyTestDemo {
    public static void dynamicProxyTestDemo() {
	IDoAction dai = new DoActionImp();
	LogHandler logHandler = new LogHandler(dai);
	IDoAction objImp = (IDoAction) Proxy.newProxyInstance(dai.getClass()
		.getClassLoader(), dai.getClass().getInterfaces(), logHandler);
	objImp.sayHello("HelloWorld");
    }
}
