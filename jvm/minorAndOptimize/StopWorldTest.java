package minorAndOptimize;

import java.util.HashMap;

public class StopWorldTest {
	/**
	 * MyThread则不停地消耗堆内存资源，从而引发GC的运行。并且设置了一个临界值，当内存消耗大于900M时，清空内存，防止堆内存溢出。
	 * @author lenovo
	 *
	 */
	public static class MyThread extends Thread{
		HashMap map=new HashMap();
		public void run(){
			try{
				while(true){
					if(map.size()*512/1024/1024>=900){
						map.clear();
						System.out.println("clean map");
					}
					byte []	 b1;
					for(int i=0;i<100;i++){
						b1=new byte[1024];
						map.put(System.nanoTime(), b1);
					}
					Thread.sleep(1);
				}
			}catch(Exception e){
				
			}
		}
	}
	
	/**
	 * PrintThread线程是每0.1秒在控制台上进行一次时间戳的输出
	 * @author lenovo
	 *
	 */
	public static class PrintThread extends Thread{
		public static final long starttime=System.currentTimeMillis();
		public void run(){
			try{
				while(true){
					long t=System.currentTimeMillis()-starttime;
					System.out.println(t/1000+"."+t%1000);
					Thread.sleep(100);
				}
			}catch(Exception e){
				
			}
		}
	}
	
	public static void main(String args[]){
		MyThread t=new MyThread();
		PrintThread p=new PrintThread();
		t.start();
		p.start();
	}
}
