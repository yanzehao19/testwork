package yzh.Generic;

class Gen<T> {
	private T ob;

	public Gen(T ob) {
		this.ob = ob;
	}

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public void showType() {
		System.out.println("T的实际类型是" + ob.getClass().getName());
	}
}

public class GenDemo {

	public static void main(String[] args) {
		Gen<Integer> intOb = new Gen<Integer>(88);
		intOb.showType();
		int i = intOb.getOb();
		System.out.println("value" + i);
		System.out.println("-------");
		Gen<String> strOb = new Gen<String>("Hello Gen!");
		strOb.showType();
		String s = strOb.getOb();
		System.out.println("value" + s);
	}

}
