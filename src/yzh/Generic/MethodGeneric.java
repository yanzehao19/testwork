package yzh.Generic;

public class MethodGeneric {

	public static void main(String[] args) {
		String str=get("Hello","World");
		System.out.println(str);
	}
	public static <T,U> T get(T t,U u){
		if(u!=null)
			return t;
		else
			return null;
	}
}
