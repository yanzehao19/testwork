package quicksort;

public class QuickSort {
	/**
	 * 
	 * 查找出中轴（默认为最低位low）的在numbers数组排序后所在的位置
	 * @param numbers 待查找数组
	 * @param low 开始位置
	 * @param high 结束位置
	 * @return 中轴所在位置
	 * 
	 */
	public static int getMiddle(int[] numbers,int low,int high) {
		int temp=numbers[low];//数组第一个作为中轴
		while(low<high) {
			while(low<high&&numbers[high]>temp) {
				high--;
			}
			numbers[low]=numbers[high];//比中轴小的记录移到到低端
			while(low<high&&numbers[low]<temp) {
				low++;
			}
			numbers[high]=numbers[low];//比中轴大的记录移动高端
			
		}
		numbers[low]=temp;//中轴记录到尾
		return low;//返回中轴位置
	}
	
	/**
	 * @param numbers 待排序数组
	 * @param low 开始位置
	 * @param high 结束位置
	 */
	public static void quickSort(int[] numbers,int low ,int high) {
		if(low <high) {
			int middle=getMiddle(numbers, low, high);//将numbers数组进行一份唯二
			quickSort(numbers, low, middle-1);//对滴字段表进行递归排序
			quickSort(numbers, middle+1, high);//对高字段表进行递归排序
		}
	}
	/*
	 * 快速排序
	 * @param numbers 待排序数组
	 * 
	 */
	public static void quick(int[] numbers) {
		if(numbers.length>0){//查看数组是否为空
			
			quickSort(numbers, 0, numbers.length-1);
		}
			
	}
	
}
