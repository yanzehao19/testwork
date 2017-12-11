package threadOperation;

public class ThreadYieldOne implements Runnable {
	public String name;

	public void run() {
		for (int i = 0; i < 10; i++) {
			Thread.yield();
			/* try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}*/
			System.out.println(name + "：" + i);
		}
	}

	public static void main(String[] args) {
		ThreadYieldOne one = new ThreadYieldOne();
		ThreadYieldOne two = new ThreadYieldOne();
		one.name = "one";
		two.name = "two";
		Thread t1 = new Thread(one);
		Thread t2 = new Thread(two);
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		//t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}

}
