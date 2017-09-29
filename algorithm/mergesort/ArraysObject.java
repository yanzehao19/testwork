package mergesort;

import java.lang.reflect.Array;

public class ArraysObject {
	private static final int INSERTIONSORT_THRESHOLD = 7;

	private ArraysObject() {
	}

	public static void sort(Object[] a) {
		// java.lang.object.clone(),理解深表复制和浅表复制
		Object[] aux = (Object[]) a.clone();
		mergeSort(aux, a, 0, a.length, 0);
	}

	public static void sort(Object[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		Object[] aux = copyOfRange(a, fromIndex, toIndex);
		mergeSort(aux, a, fromIndex, toIndex, -fromIndex);
	}

	/**
	 * src is the source array that starts at index 0 dest is the (possibly
	 * larger)array destination with a possible offset low is the index in dest
	 * to start sorting high is the end index in dest to end sorting off is the
	 * offset to generate corresponding low,high in src
	 */
	private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
		int length = high - low;
		// insertion sort on smallest arrays
		if (length < INSERTIONSORT_THRESHOLD) {
			for (int i = low; i < high; i++)
				for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
					swap(dest, j, j - 1);
			return;
		}
		// recursively sort halves of dest into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		/**
		 * >>>:无符号右移运算符 expression1>>>expression2:expresssion1的各个位向右移expression2
		 * 指定的位数，右移后左边空出的位数用0来填充，移出右边的位被丢弃 例如：-14>>>2;结果为1073761820
		 */

		int mid = (low + high) >>> 1;
		mergeSort(dest, src, low, mid, -off);
		mergeSort(dest, src, mid, high, -off);

		// if list is already sorted,just copy form src to dest,this is an
		// optimization that results in faster sorts for nearly ordered lists

		if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
			System.arraycopy(src, low, dest, destLow, length);
			return;
		}

		// merge sorted halves (now in src) into dest
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}

	}

	/**
	 * check that fromindex and toindex are in range,and throw an appropriate
	 * exception if they aren't
	 */
	private static void rangeCheck(int arrayLen, int fromIndex, int toIndex) {
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex + ")>toIndex(" + toIndex + ")");
		if (fromIndex < 0)
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		if (toIndex > arrayLen)
			throw new ArrayIndexOutOfBoundsException(toIndex);
	}

	public static <T> T[] copyOfRange(T[] original, int from, int to) {
		return copyOfRange(original, from, to, (Class<T[]>) original.getClass());
	}

	public static <T, U> T[] copyOfRange(U[] original, int from, int to, Class<? extends T[]> newType) {
		int newLength = to - from;
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		T[] copy = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[newLength]
				: (T[]) Array.newInstance(newType.getComponentType(), newLength);
		System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
		return copy;

	}

	/**
	 * swaps x[a] with x[b]
	 */
	private static void swap(Object[] x, int a, int b) {
		Object t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

}
