package yzh.Synchronized;

public class testSynchronizedDebug extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "hello world");
		Singleton sg = Singleton.getInstance();
		System.out.println(sg);
	}

	public static void main(String[] args) {
		testSynchronizedDebug t1 = new testSynchronizedDebug();
		testSynchronizedDebug t2 = new testSynchronizedDebug();
		t1.start();
		t2.start();
	}
}
