package yzh.Generic;

class Gen2 {
	private Object ob;

	public Gen2(Object ob) {
		this.ob = ob;
	}

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}

	public void showType() {
		System.out.println("T的实际类型是：" + ob.getClass().getName());

	}
}

public class GenDemo2 {

	public static void main(String[] args) {
		Gen2 intOb = new Gen2(new Integer(88));
		intOb.showType();
		int i = (Integer) intOb.getOb();
		System.out.println("value" + i);
		System.out.println("--------");
		Gen2 strOb = new Gen2("Hello Gen!");
		strOb.showType();
		String s = (String) strOb.getOb();
		System.out.println("value" + s);
	}

}
