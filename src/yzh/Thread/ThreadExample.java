package yzh.Thread;

public class ThreadExample {

	public static void main(String[] args) {
		System.out.print(Thread.currentThread().getName());
		for(int i =0 ;i<10;i++) {
			new Thread(""+i) {
				public void run() {
					System.out.println("Thread"+getName()+"running");
				}
			}.start();
		}
	}

}
