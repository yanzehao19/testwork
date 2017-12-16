package threadPool;

public class PThread extends Thread	{
	//线程池
	private ThreadPool pool;
	//任务
	private Runnable target;
	private boolean isShutDown=false;
	private boolean isIdel=false;
	
	//构造函数
	
	public PThread(Runnable target,String name,ThreadPool pool) {
		super(name);
		this.pool=pool;
		this.target=target;
	}
	public Runnable getTarget() {
		return target;
	}
	public boolean isIdle() {
		return isIdel;
	}
	@Override
	public void run() {
		//只要不关闭，就一直不结束该线程
		while(!isShutDown) {
			isIdel=false;
			if(target!=null) {
				//运行任务
				target.run();
			}
			//任务结束，到闲置状态
			isIdel=true;
			try {
				//任务结束后，不关闭该线程，而放入线程池中闲置备用
				pool.putThread(this);
				synchronized (this) {
					//线程空闲，等待任务到来
					wait();
				}
			}catch(Exception e) {
				
			}
			isIdel=false;
		}
	}
	
	public synchronized void setTarget(Runnable newTarget) {
		target=newTarget;
		//设置任务之后，通知run方法，执行该任务
		notifyAll();
	}
	
	//关闭线程
	public synchronized void shutDown() {
		isShutDown=true;
		notifyAll();
	}
}
