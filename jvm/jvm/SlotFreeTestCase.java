package jvm;

/**
 * @Described：Slot局部变量表 没有破坏GCRoot情况演示
 * 
 * @VM params :-XX:+PrintGCDetails -verbose:gc
 * 
 * @author lenovo
 *
 */
public class SlotFreeTestCase {

	public static void main(String[] args) {
		//case1 
		byte[] testCase =new byte[10*1024*1024];
		System.gc();
		/*//case 2
		{
			byte[] testCase =new byte[10*1024*1024];
		}
		System.gc();*/
		
		/*//case 3
		{
			byte[] testCase =new byte[10*1024*1024];
		}
		int a = 0;
		System.gc();*/
		
		/*//case 5
		byte[] testCase =new byte[10*1024*1024];
		testCase=null;
		System.gc();*/
	}

}
