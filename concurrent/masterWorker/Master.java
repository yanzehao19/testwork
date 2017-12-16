package masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//任务队列
	protected Queue<Object> workQueue=new ConcurrentLinkedQueue<Object>();
	//work进程队列
	protected Map<String, Thread> threadMap=new HashMap<String,Thread>();
	//子任务处理结果集
	protected Map<String, Object> resultMap=new ConcurrentHashMap<String,Object>();
	
	//是否所有的子任务都结束了
	public boolean isComplete() {
		for(Map.Entry<String, Thread> entry:threadMap.entrySet()) {
			if(entry.getValue().getState()!=Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	
	//master的构造，需要一个worker线程和worker的进程书香
	public Master(Worker worker,int countWorker) {
		worker.setWorkQueue(workQueue);
		worker.setResultMap(resultMap);
		for(int i=0;i<countWorker;i++) {
			threadMap.put(Integer.toString(i), new Thread(worker,Integer.toString(i)));
		}
	}
	
	//提交任务，放入进程对类中
	public void submit(Object job) {
		workQueue.add(job);
		 System.out.println("任务队列size："+workQueue.size());  
	}
	//返回子任务结果集
	public Map<String, Object> getResultMap(){
		return resultMap;
	}
	
	//开始运行所有的worker进程
	public void execute() {
		for(Map.Entry<String , Thread> entry:threadMap.entrySet()) {
			entry.getValue().start();//调用子线程worker。run
			System.out.println(entry.getValue());
		}
	}
}
