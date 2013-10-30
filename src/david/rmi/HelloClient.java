package david.rmi;

import java.rmi.Naming;

public class HelloClient {
	public static void main(String[] args) {
		try {
			IHello helloworld = (IHello) Naming.lookup(RMIUtil.url);
			System.out.println(helloworld.sayHello());
			System.out.println(helloworld.sayHello("daviddai"));
			System.out.println(helloworld.add(1, 2));
			System.out.println(helloworld.minus(7, 8));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}
}