package mergesort;

public final class Array {
	private Array() {
	}

	// 创建一个具有指定的组件类型和维度的新数组。
	public static Object newInstance(Class<?> componentType, int length) throws NegativeArraySizeException {
		return newArray(componentType, length);
	}

	private static native Object newArray(Class componentType, int length) throws NegativeArraySizeException;
}