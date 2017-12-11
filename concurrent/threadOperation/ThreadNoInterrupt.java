package threadOperation;

public class ThreadNoInterrupt extends Thread {
	public boolean stop = false;

	public static void main(String[] args) throws InterruptedException {
		ThreadNoInterrupt t1 = new ThreadNoInterrupt();
		System.out.println("app is starting");
		t1.start();
		Thread.sleep(3000);
		System.out.println("Interrupting t1....");
		t1.interrupt();
		Thread.sleep(3000);
		System.out.println("app is end");
		t1.stop = true;
		System.exit(0);
	}

	public void run() {
		while (!this.stop) {
			System.out.println("t1 is runing.....");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000) && (!stop)) {
			}
			;

		}
		System.out.println("t1 is end");
	}

}
