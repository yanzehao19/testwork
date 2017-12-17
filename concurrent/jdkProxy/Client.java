package jdkProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;



//客户端，生成代理实例，并调用了request（）方法
public class Client {

	public static void main(String[] args) {
		Subject rs=new RealSubject();//这里指定被代理类
		InvocationHandler ds=new DynamicSubject(rs);
		Class<?>cls =rs.getClass();
		//以下是一次性生成代理
		Subject subject=(Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
		//这里可以通过运行结果证明subject是Proxy的一个实例，这个实例实现了subject接口
		 System.out.println(subject instanceof Proxy);  
		 //这里可以看出subject的class类是$proxy0,这个$proxy0类继承了proxy，实现了subject
		 System.out.println("subject的Class类是："+subject.getClass().toString());  
         
	        System.out.print("subject中的属性有：");  
	        
	        Field [] field=subject.getClass().getDeclaredFields();
	        for(Field f:field){  
	            System.out.print(f.getName()+", ");  
	        }   
	        System.out.print("\n"+"subject中的方法有：");  
	          
	        Method[] method=subject.getClass().getDeclaredMethods();  
	        
	        for(Method m:method){  
	            System.out.print(m.getName()+", ");  
	        }   
	        
	        System.out.println("\n"+"subject的父类是："+subject.getClass().getSuperclass());  
	          
	        System.out.print("\n"+"subject实现的接口是：");  
	          
	        Class<?>[] interfaces=subject.getClass().getInterfaces();  
	          
	        for(Class<?> i:interfaces){  
	            System.out.print(i.getName()+", ");  
	        }  
	  
	        System.out.println("\n\n"+"运行结果为：");  
	        subject.request();  
	}
	
	
	public  Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) throws IllegalArgumentException{
		if(h!=null)
			 throw new NullPointerException();  
		Class cl=getProxyClas(loader,interfaces);
		try {
			 Class[] constructorParams = { InvocationHandler.class }; 
			Constructor cons=cl.getConstructor(constructorParams);
			return (Object)cons.newInstance(new Object[] {h});
		}catch (NoSuchMethodException e) {  
	        throw new InternalError(e.toString());  
	    } catch (IllegalAccessException e) {  
	        throw new InternalError(e.toString());  
	    } catch (InstantiationException e) {  
	        throw new InternalError(e.toString());  
	    } catch (InvocationTargetException e) {  
	        throw new InternalError(e.toString());  
	    }   
		
	}
	
	private Class getProxyClas(ClassLoader loader, Class<?>[] interfaces) {
		// TODO Auto-generated method stub
		return null;
	}

	class Proxy{
		InvocationHandler h=null;
		protected Proxy(InvocationHandler h) {
			this.h=h;
		}
	}

	protected final class $Proxy0 extends Proxy implements Subject{
		private static Method m1;
		private static Method m0;
		private static Method m3;
		private static Method m2;
		
		static {
			try {
				  m1 = Class.forName("java.lang.Object").getMethod("equals",  
		                    new Class[] { Class.forName("java.lang.Object") });  
		  
		            m0 = Class.forName("java.lang.Object").getMethod("hashCode",  
		                    new Class[0]);  
		  
		            m3 = Class.forName("***.RealSubject").getMethod("request",  
		                    new Class[0]);  
		  
		            m2 = Class.forName("java.lang.Object").getMethod("toString",  
		                    new Class[0]);  
			}catch (NoSuchMethodException nosuchmethodexception) {  
	            throw new NoSuchMethodError(nosuchmethodexception.getMessage());  
	        } catch (ClassNotFoundException classnotfoundexception) {  
	            throw new NoClassDefFoundError(classnotfoundexception.getMessage());  
	        }   
		}
		public $Proxy0(InvocationHandler invocationHandler) {
			super(invocationHandler);
		}
		@Override
		 public final boolean equals(Object obj) {  
	        try {  
	            return ((Boolean) super.h.invoke(this, m1, new Object[] { obj })) .booleanValue();  
	        } catch (Throwable throwable) {  
	            throw new UndeclaredThrowableException(throwable);  
	        }  
	    }   
		@Override  
	    public final int hashCode() {  
	        try {  
	            return ((Integer) super.h.invoke(this, m0, null)).intValue();  
	        } catch (Throwable throwable) {  
	            throw new UndeclaredThrowableException(throwable);  
	        }  
	    }  
		
		public final void request() {  
	        try {  
	            super.h.invoke(this, m3, null);  
	            return;  
	        } catch (Error e) {  
	        } catch (Throwable throwable) {  
	            throw new UndeclaredThrowableException(throwable);  
	        }  
	    }
		
		 @Override  
		    public final String toString() {  
		        try {  
		            return (String) super.h.invoke(this, m2, null);  
		        } catch (Throwable throwable) {  
		            throw new UndeclaredThrowableException(throwable);  
		        }  
		    }   
		
		 
	}
	
}
