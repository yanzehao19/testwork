package reflection;

import java.lang.reflect.Array;

public class TestReflectModifyArray {

	public static void main(String[] args) {
		/*
		 * int[]temp={1,2,3,4,5};
		 * Class<?>demo=temp.getClass().getComponentType(); System.out.println(
		 * "数组类型： " + demo.getName()); System.out.println("数组长度  " +
		 * Array.getLength(temp)); System.out.println("数组的第一个元素: " +
		 * Array.get(temp, 0)); Array.set(temp, 0, 100); System.out.println(
		 * "修改之后数组第一个元素为： " + Array.get(temp, 0));
		 */
		int[] temp = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] newTemp = (int[]) arrayInc(temp, 15);
		print(newTemp);
		String[] atr = { "a", "b", "c" };
		String[] str1 = (String[]) arrayInc(atr, 8);
		print(str1);

	}

	// 修改数组大小
	public static Object arrayInc(Object obj, int len) {
		Class<?> arr = obj.getClass().getComponentType();
		Object newArr = Array.newInstance(arr, len);
		int co = Array.getLength(obj);
		System.arraycopy(obj, 0, newArr, 0, co);
		return newArr;
	}

	// 打印
	public static void print(Object obj) {
		Class<?> class1 = obj.getClass();
		if (!class1.isArray()) {
			return;
		}
		System.out.println("数组长度为： " + Array.getLength(obj));
		for (int i = 0; i < Array.getLength(obj); i++) {
			System.out.print(Array.get(obj, i) + " ");
		}
		System.out.println();
	}

}
