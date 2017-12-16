package producerConsumer;
/*
 * 从缓冲区获取pcdata对象
 * 
 */

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;


public class Consumer  implements Runnable	{
	private BlockingQueue<PCData> queue;
	private static final int SLEEPTIME=1000;
	
	public Consumer(BlockingQueue<PCData> queue) {
		this.queue=queue;
	}
	public void run() {
		System.out.println("消费者开始取数据，当前线程ID:"+Thread.currentThread().getId());
		Random r=new Random();
		try {
			while(true) {
				PCData data=queue.take();
				if(null!=data) {
					System.out.println("从缓冲区中获取数据"+data.getData());
					int re=data.getData()*data.getData();//计算平方
					System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
					
					System.out.println("本数据对象处理完毕");
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			}
		}catch(Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
