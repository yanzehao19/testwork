package blocingDeque;

import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDeque {

	public static void main(String[] args) throws Exception {
		LinkedBlockingDeque<String> deque =new LinkedBlockingDeque<String>();
		deque.addFirst("1");
		deque.addLast("2");
		
		String two=deque.takeLast();
		String one =deque.takeFirst();
		System.out.println(two  + ",  " +one);
	}

}
