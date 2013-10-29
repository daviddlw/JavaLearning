package david.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote {

	public String sayHello() throws RemoteException;

	public String sayHello(String name) throws RemoteException;
	
	public int add(int a, int b) throws RemoteException;
	
	public int minus(int a, int b) throws RemoteException;
	
}