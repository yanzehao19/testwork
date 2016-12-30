package yzh.dataByte;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {

	public static void main(String[] args) throws Exception {
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.x"));
		Alien zorcon = new Alien();
		out.writeObject(zorcon);
	}

}
