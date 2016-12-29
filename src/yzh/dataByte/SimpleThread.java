package yzh.dataByte;

public class SimpleThread extends Thread {
	private int countDown = 5;
	private int threadNumber;
	private static int threadCount = 0;

	public SimpleThread() {
		threadNumber = ++threadCount;
		System.out.println("Making" + threadNumber);
	}

	public void run() {
		while (true) {
			System.out.println("Thread" + threadNumber + "(" + countDown + ")");
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			SimpleThread simpleThread = new SimpleThread();
			simpleThread.start();
		}

		System.out.println("All Threads Started");
	}
}
