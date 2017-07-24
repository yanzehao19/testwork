package yzh.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadTest {
	private static int thread_num = 500;
	private static int client_num = 5000;

	public static void main(String[] args, String no) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(thread_num);
		for (int index = 0; index < client_num; index++) {
			final int No = index;
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						semaphore.acquire();
						System.out.println("Thread:" + No);
						semaphore.release();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			executorService.execute(runnable);
		}
		executorService.shutdown();
	}
}
