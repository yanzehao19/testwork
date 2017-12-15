package future;

public class RealData implements Data{
	protected final String result;
	public RealData(String para) {
		StringBuffer sb=new StringBuffer();
		//模拟一个很慢的构造过程
		for(int i=0;i<50;i++) {
			sb.append(para);
			try {
				Thread.sleep(100);//替代一个很慢的操作过程
			}catch(Exception e) {
				
			}
		}
		result=sb.toString();
	}
	public String getResult()	{
		return result;
	}
}
