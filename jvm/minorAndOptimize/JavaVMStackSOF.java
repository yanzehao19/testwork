package minorAndOptimize;
/**
 * 演示Java虚拟机栈出现溢出的现象
 * @author lenovo
 *
 */
public class JavaVMStackSOF {
	private int stackLength=1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable{
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try{
			oom.stackLeak();
		}catch(Throwable e){
			System.out.println("StackLength:"+oom.stackLength);
			throw e;
		}
	}
}
