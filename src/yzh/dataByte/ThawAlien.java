package yzh.dataByte;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ThawAlien {

	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.x"));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass().toString());
	}

}
