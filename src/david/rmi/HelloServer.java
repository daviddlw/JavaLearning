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
			
			LocateRegistry.createRegistry(RMIUtil.port); // 本地主机上的远程对象注册表实例指定端口

			Naming.bind(RMIUtil.url, helloworld);
			System.out.println("远程IHello对象绑定成功。");

		} catch (RemoteException ex) {
			System.out.println("创建远程对象发生异常");
			ex.printStackTrace();
			// TODO: handle exception
		} catch (AlreadyBoundException ex) {
			System.out.println("发生重复绑定对象异常");
			// TODO: handle exception
		} catch (MalformedURLException ex) {
			// TODO Auto-generated catch block
			System.out.println("发生URL非法异常");
			ex.printStackTrace();
		}		
	}
}