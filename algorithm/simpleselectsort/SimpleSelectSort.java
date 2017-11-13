package simpleselectsort;

public class SimpleSelectSort {

	public static void simpleSelectSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int minIndex = i;// 记录最小值的索引
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[minIndex]) {
					minIndex = j;// 若后面的元素值小于最小值,将j赋值给minIndex
				}
			}
			if (minIndex != i) {
				swap(data, i, minIndex);
				print(data);
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
		simpleSelectSort(data);
		System.out.println("排序后的数组：");
		print(data);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("BusiCode", "3002");
		jsonObject.put("BusiCode", "3001");

		System.out.println(jsonObject.toString());

	}

}
