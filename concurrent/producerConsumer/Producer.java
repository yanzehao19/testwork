package producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 负责创建数据对象pcd并提交到内存缓冲区中
 * @author lenovo
 *
 */
public class Producer implements Runnable {
	private volatile boolean isRunning =true;
	private BlockingQueue<PCData> queue;
	private static AtomicInteger count=new AtomicInteger();//总数，原子操作。
	private static final int SLEEPTIME=1000;
	
	public Producer(BlockingQueue<PCData> queue) {
		this.queue=queue;
	}
	@Override
	public void run() {
		PCData data=null;
		Random r=new Random();
		System.out.println("生产者当前线程"+Thread.currentThread().getId());
		
		try {
			while(isRunning) {
				Thread.sleep(r.nextInt(SLEEPTIME));
				data=new PCData(count.incrementAndGet());//构造任务数据
				
				System.out.println(count.incrementAndGet());
				System.out.println(data+"已进入缓存区");
				if(!queue.offer(data,2,TimeUnit.SECONDS))	{
					//提交数据到缓冲区
					System.out.println(data+"存入失败");
				}
			}
		}catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	public void stop() {
		isRunning=false;
	}
}
