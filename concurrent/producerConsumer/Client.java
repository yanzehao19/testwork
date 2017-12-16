package producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		//建立缓冲区
		BlockingQueue<PCData> queue=new LinkedBlockingQueue<PCData>(10);
		//建立3个生产者
		Producer p1=new Producer(queue);
		Producer p2=new Producer(queue);
		Producer p3=new Producer(queue);
		//建立3个消费者
		Consumer c1=new Consumer(queue);
		Consumer c2=new Consumer(queue);
		Consumer c3=new Consumer(queue);
		
		//创建线程池
		ExecutorService threadPool=Executors.newCachedThreadPool();
		threadPool.execute(p1);
		threadPool.execute(p2);
		threadPool.execute(p3);
		
		threadPool.execute(c1);//启动消费者线程
		threadPool.execute(c2);
		threadPool.execute(c3);
		
		Thread.sleep(10*1000);
		//停止生产
		p1.stop();
		p2.stop();
		p3.stop();
		//消费者处理完缓冲区中所有数据，程序执行完毕
		
		Thread.sleep(3000);
		threadPool.shutdown();
		
	}

}
