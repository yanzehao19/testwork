package threadPool;

public class DefinePool implements Runnable,Comparable<DefinePool>{
	protected String name;
	
	/*
	 * 构造方法
	 */
	public DefinePool() {
		
	}
	public DefinePool(String name) {
		this.name=name;
	}
	
	/*
	 * 模拟任务
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("模拟任务！！！！！！name："+name);  
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 比较任务优先级
	 */
	@Override
	public int compareTo(DefinePool o) {
		//前提：线程名称标记优先级
		int me =Integer.parseInt(this.name.split("_")[1]);
		//System.out.println(me);
		int other=Integer.parseInt(o.name.split("_")[1]);
		if(me>other)return 1;
		if(me<other)return -1;
		else return 0;
	}
	
}
