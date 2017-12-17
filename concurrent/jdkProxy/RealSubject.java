package jdkProxy;
//真实角色：实现了subject的request（）方法
public class RealSubject implements Subject {
	public  void request() {
		 System.out.println("From real subject.");  
	}
}
