package yzh.Generic;

public class ClassGeneric<T> {
	private T value;

	public ClassGeneric(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public static void main(String[] args) {
		ClassGeneric<String> pair = new ClassGeneric<String>("Hello");
		String str = pair.getValue();
		System.out.println(str);
		pair.setValue("World");
		str = pair.getValue();
		System.out.println(str);

		ClassGeneric<Integer> in = new ClassGeneric<Integer>(1);
		Integer inte = in.getValue();
		System.out.println(inte);
	}

}
