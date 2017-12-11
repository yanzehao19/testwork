package threadOperation;

public class ThreadJoin extends Thread {
	
	public static void main(String[] args) {
		ThreadJoin t=new ThreadJoin();
		try {
			t.start();
			Thread.sleep(1000);
			 System.out.println("main join start");
			 t.join(1000);
			 System.out.println("main join end");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		synchronized (this) {
			//当ThreadJoin类的run用synchronized锁住时, t.join方法将得不到锁资源而等待更长的时间.
			// 当main函数中调用t.join();时, 
			//由于 t.run()方法对t线程做了同步处理,
			//即得到了锁资源, 而此时t.join()方法调用时只能等待t.run()方法执行完成之后,
			//释放了锁资源之后. t.join函数才可以继续等待. 即main实际等待了 9000 + 1000纳秒.
			System.out.println("join start");
			try {
				Thread.sleep(9000);
				for(int i=0;i<5;i++) {
					  System.out.println("sub thread:" + i);
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("join end");
		}
	}

}
