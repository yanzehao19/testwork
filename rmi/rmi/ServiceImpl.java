package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
//UnicastRemoteObject用于导出的远程对象和获得与该远程对象通信的存根。
public class ServiceImpl extends UnicastRemoteObject implements IService {
	private String name;
	public ServiceImpl(String name) throws RemoteException{
		this.name=name;
	}
	@Override
	public String service(String content){
		return "server>>"+content;
	}
}
