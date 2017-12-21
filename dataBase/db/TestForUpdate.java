package db;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestForUpdate {

	public static void main(String[] args) throws InterruptedException {
		 final int THREAD_COUNT=10;
		 ExecutorService threadPool=Executors.newFixedThreadPool(THREAD_COUNT);
	        CountDownLatch count=new CountDownLatch(2);
	
	        threadPool.execute(new ForUpdate1(count));
	        threadPool.execute(new ForUpdate2(count));
	        threadPool.shutdown();
	        count.await();
	        System.out.println("finish");
	}

}
