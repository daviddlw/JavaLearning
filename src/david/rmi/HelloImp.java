package david.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImp extends UnicastRemoteObject implements IHello {

	public HelloImp() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello World";
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return String.format("ÄãºÃ£º%s", name);
	}

	@Override
	public int add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int minus(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a - b;
	}

}