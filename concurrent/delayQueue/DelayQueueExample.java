package delayQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class DelayQueueExample {

	public static void main(String[] args) throws Exception {
		DelayQueue queue = new DelayQueue();
		Delayed element1 = new DelayedElement();
		queue.put(element1);
		Delayed element2 = queue.take();

		// LinkedBlockingQueue

		BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
		BlockingQueue<String> bounded = new LinkedBlockingQueue<String>(1024);
		bounded.put("value");
		String value = bounded.take();

		// PriorityBlockingQueue

		BlockingQueue queue2 = new PriorityBlockingQueue();
		// String implements java.lang.Comparable
		queue2.put("value");
		String value1 = (String) queue2.take();

	}

}
