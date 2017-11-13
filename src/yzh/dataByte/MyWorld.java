package yzh.dataByte;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

class House implements Serializable {

}

class Animal implements Serializable {
	String name;
	House preferredHouse;

	Animal(String nm, House h) {
		name = nm;
		preferredHouse = h;
	}

	public String toString() {
		return name + "[" + super.toString() + "]," + preferredHouse + "\n";
	}
}

public class MyWorld {
	public static void main(String[] args) {
		House house = new House();
		Vector animals = new Vector();
		animals.addElement(new Animal("Bosco the dog", house));
		animals.addElement(new Animal("Ralph the hamster", house));
		animals.addElement(new Animal("Fronk the cat", house));
		System.out.println("animal:" + animals);
		try {
			ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
			ObjectOutputStream o1 = new ObjectOutputStream(buf1);
			o1.writeObject(animals);
			o1.writeObject(animals);
			ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
			ObjectOutputStream o2 = new ObjectOutputStream(buf2);
			o2.writeObject(animals);
			ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
			ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
			Vector animals1 = (Vector) in1.readObject();
			Vector animals2 = (Vector) in1.readObject();
			Vector animals3 = (Vector) in2.readObject();
			System.out.println("animals1" + animals1);
			System.out.println("animals2" + animals2);
			System.out.println("animals3" + animals3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
