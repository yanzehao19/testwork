package yzh.Generic;

import java.sql.Date;


public interface InterfaceGeneric<T,U> {
	void show(T t, U u);
}
class ShowTest<T,U> implements InterfaceGeneric<T, U>{
	@Override
	public void show(T str,U date){
		System.out.println(str);
		System.out.println(date);
		System.out.println("END");
	}
	public static void main(String[]args) throws ClassNotFoundException{
		ShowTest<String, Date> showTest=new ShowTest<String,Date>();
		showTest.show("Hello", new Date(2016-05-12));
	}
}
