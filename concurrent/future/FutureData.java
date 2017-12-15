package future;


/**
 * 实现了一个快速返回的realdata的包装，但并非真实的返回结果
 * @author lenovo
 *
 */
public class FutureData  implements Data{
	protected RealData realData=null;//futureData是realData的一个包装。
	protected boolean isReady=false;
	public synchronized void setRealData(RealData realData) {
		if(isReady) {
			return ;
		}
		this.realData=realData;
		isReady=true;
		notifyAll();//当调用future包装类的set方法时，线程realdata被唤醒，同个getgetresult（）方法
		
	}
	
	@Override
	public synchronized String getResult()	{//会等待realdata构造完成
		while(!isReady) {
			try {
				wait();//一直等待，直到realdata被注入
			}catch(Exception e) {
				
			}
		}
		return realData.result;//realdata的真实实现
	}
}
