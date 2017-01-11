package yzh.Generic;

import java.sql.Date;

public class Test<T, U> implements InterfaceGeneric<T, U> {
	@Override
	public void show(T str, U date) {
		System.out.println(str);
		System.out.println(date);
	}

	public static void main(String[] args) {
		ShowTest<String, Date> showTest = new ShowTest<String, Date>();
		showTest.show("Hello", new Date(2016 - 05 - 12));
	}
}
