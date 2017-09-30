package bubblesort;

public class BubbleSort {

	public static void bubbleSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			// 记录某趟是否发生交换，若为false表示数组已处于有序状态
			boolean isSorted = false;
			for (int j = 0; j < data.length - 1 - i; j++) {
				if (data[j] > data[j + 1]) {
					swap(data, j, j + 1);
					isSorted = true;
					print(data);
				}
			}
			if (isSorted) {
				// 若数组已处于有序状态，结束循环
				break;
			}
		}
	}

	public static void bubbleSort1(int[] data) {
		boolean flag = true;
		for (int i = 0; i < data.length - 1 && flag; i++) {
			flag = false;
			for (int j = data.length - 2; j >= i; j--) {
				if (data[j] > data[j + 1]) {
					swap(data, j, j + 1);
					flag = true;
					print(data);
				}
			}
		}
	}

	public static void swap(int[] data, int i, int j) {
		if (i == j)
			return;
		data[i] = data[i] + data[j];
		data[j] = data[i] - data[j];
		data[i] = data[i] - data[j];
	}

	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++)
			System.out.print(data[i] + "\t");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7, 10 };
		print(data);
		bubbleSort1(data);
		System.out.println("排序后的数组：");
		print(data);
	}

}
