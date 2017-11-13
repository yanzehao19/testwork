package yzh.Synchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class MySafeThread implements Runnable {

	private static AtomicInteger count = new AtomicInteger(0);
	private int threadCount = 0;
	private static int num = 1;

	public synchronized static void calc() {
		while ((count.get()) < 1000) {
			count.incrementAndGet();
			System.out.println("正在运行时线程" + Thread.currentThread().getName() + ":" + count);
		}
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MySafeThread.calc();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Thread mySafeThread = new Thread(new MySafeThread());
			mySafeThread.start();
		}
	}

}
