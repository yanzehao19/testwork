package quicksort;

public class ArrayTest {

	public static void main(String[] args) {
		int[] a = { 15, 93, 15, 41, 6, 15, 22, 7, 15, 20 };
		ArraysPrimitive.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
	}

}
