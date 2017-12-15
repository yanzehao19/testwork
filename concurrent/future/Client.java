package future;

public class Client {
	public Data request(final String queryString) {
		final FutureData future=new FutureData();
		new Thread() {//realdata构建很慢，放到一个单独的线程中进行
			public void run()	{
				RealData realData=new RealData(queryString);
				future.setRealData(realData);//调用future的set方法，直接return并唤醒realdata线程进行数据构造
			}
		}.start();
		return future;//立即被返回
	}
}
