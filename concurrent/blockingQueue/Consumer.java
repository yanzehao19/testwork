package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	protected BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
