package yzh.Synchronized;

public class Singleton {
	private static Singleton instance;
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(instance ==null){
			System.out.println(instance);
			instance=new Singleton();
		}
		return instance;
	}
}
