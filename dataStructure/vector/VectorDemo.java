package vector;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>(3, 2);
		System.out.println(v.size());
		v.addElement(new Integer(1));

	}

}
