package future;

public class Main {
	public static void main(String[] args) {
		Client client =new Client();
		//这里会立即返回结果，应为得到的是futuredata而非realdata
		Data data =client.request("name");
		System.out.println("请求完毕");
		System.out.println(data.toString());
		
		//System.out.println("真实数据："+data.getResult());
		try {
			//代表对其他业务的处理  
			//在处理过程中，RealData被传剑，充分利用了等待时间  
			//Thread.sleep(2000);  
			 System.out.println("我也在被处理哦");  
		}catch(Exception e) {
			
		}
		System.out.println("真实数据："+data.getResult());
	}
}
