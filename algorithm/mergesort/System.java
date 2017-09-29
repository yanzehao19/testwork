package mergesort;

public final class System {
	// System 类不能被实例化。
	private System() {
	}

	// 在 System 类提供的设施中，有标准输入、标准输出和错误输出流；对外部定义的属性
	// 和环境变量的访问；加载文件和库的方法；还有快速复制数组的一部分的实用方法。
	/**
	 * src and dest都必须是同类型或者可以进行转换类型的数组．
	 * 
	 * @param src
	 *            the source array.
	 * @param srcPos
	 *            starting position in the source array.
	 * @param dest
	 *            the destination array.
	 * @param destPos
	 *            starting position in the destination data.
	 * @param length
	 *            the number of array elements to be copied.
	 */
	public static native void arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
}