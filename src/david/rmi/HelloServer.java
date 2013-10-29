package david.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

	public static void main(String[] args) {
		try {
			IHello helloworld = new HelloImp();
			
			LocateRegistry.createRegistry(RMIUtil.port); // ���������ϵ�Զ�̶���ע���ʵ��ָ���˿�

			Naming.bind(RMIUtil.url, helloworld);
			System.out.println("Զ��IHello����󶨳ɹ���");

		} catch (RemoteException ex) {
			System.out.println("����Զ�̶������쳣");
			ex.printStackTrace();
			// TODO: handle exception
		} catch (AlreadyBoundException ex) {
			System.out.println("�����ظ��󶨶����쳣");
			// TODO: handle exception
		} catch (MalformedURLException ex) {
			// TODO Auto-generated catch block
			System.out.println("����URL�Ƿ��쳣");
			ex.printStackTrace();
		}		
	}
}