package threadPool;

import java.util.List;
import java.util.Vector;



public class ThreadPool {
	private static ThreadPool instance=null;  
    //空闲的线程队列  
    private List<PThread> idleThreads;  
    //已有的线程数  
    private int count;  
    private boolean isShutDown=false;  
      
    private ThreadPool()  
    {  
        this.idleThreads=new Vector(5);//类似于Arraylist  
        count=0;  
    }  
    public int getCreatedThread()  
    {  
        return count;  
    }  
      
    //取得线程实例  
    public synchronized static ThreadPool getInstance()  
    {  
        if(instance==null)  
            instance=new ThreadPool();  
            return instance;  
  
    }  
    //将线程放入线程池  
    public synchronized void putThread(PThread putThread)  
    {  
        if(!isShutDown)  
        {  
            idleThreads.add(putThread);  
        }else  
        {  
            putThread.shutDown();  
        }  
    }  
      
    //停止池中的所有线程  
    public synchronized void shotdown()  
    {  
        isShutDown=true;  
        for(int threadIndex=0;threadIndex<idleThreads.size();threadIndex++)  
        {  
            PThread idelThread=(PThread)idleThreads.get(threadIndex);  
            idelThread.shutDown();  
        }  
    }  
    //执行任务  
    public synchronized void start()  
    {  
        PThread thread=null;  
        //如果有空闲线程，直接使用  
        if(idleThreads.size()>0)  
        {  
            int lastIndex=idleThreads.size()-1;  
            thread=(PThread)idleThreads.get(lastIndex);  
            idleThreads.remove(lastIndex);  
            //立即执行这个任务  
            thread.setTarget(thread);  
        }else  
        {  
            //没有空闲线程，自己创建  
            count++;  
            thread=new PThread( target,count,this);  
            //启动这个线程  
            thread.start();  
        }  
              
    }  
			
}
