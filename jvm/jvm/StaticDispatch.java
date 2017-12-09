package jvm;
/*
 * @Described：静态分配
 * 
 */
public class StaticDispatch {
	static abstract class Human{};
	static class Man extends Human{};
	static class Woman extends Human{};
	
	public void say(Human human) {
		  System.out.println("hi,you are a good human!");
	}
	public void say(Man huMan) {
		System.out.println("hi,gentleman!");
	}
	public void say(Woman human) {
		 System.out.println("hi,yong lady!");
	}
	public static void main(String[] args) {
		Human man=new Man();
		Human woman=new Woman();
		 StaticDispatch dispatch = new StaticDispatch();
		 dispatch.say(man);
		 dispatch.say(woman);
	}

}
