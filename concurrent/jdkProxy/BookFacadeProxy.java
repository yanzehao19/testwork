package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class BookFacadeProxy  implements InvocationHandler{
	private Object target;//这其实业务实现类对象，用来调用具体的业务方法
	/**
	 * 绑定业务对象并返回一个代理类
	 * 
	 */
	public Object bind(Object target) {
		this.target=target;//接受业务实现类对象参数
		//通过反射机制，创建一个代理类对象实例并返回，用户进行方法调用时使用
		//创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法时调用真正的业务方法），接口，handler实现类
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	/**
	 * 包装调用方法，进行预处理，调用后处理
	 */
	public Object invoke(Object proxy,java.lang.reflect.Method method,Object[] args) throws Throwable{
		Object result =null;
		System.out.println("预处理操作——————");  
		//调用正真的业务方法
		result=method.invoke(target, args);
		System.out.println("调用后处理——————");  
		return result;
	}
	public static void main(String[] args) {  
		BookFacadeImpl bookFacadeImpl=new BookFacadeImpl();
		BookFacadeProxy proxy=new BookFacadeProxy();
		BookFacade bookFacade =(BookFacade)proxy.bind(bookFacadeImpl);
		bookFacade.addBook();
	}
	
	
}
