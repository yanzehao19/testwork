package masterWorker;

import java.util.Map;
import java.util.Set;

public class Client {
	  public static void main(String[] args) {
		  Master master =new Master(new SubWorker(), 5);//指定5个
		  for(int i=0;i<100;i++) {
			  master.submit(i);
		  }
		  master.execute();
		  int re=0;
		  Map<String, Object> resultMap=master.getResultMap();
		  while(resultMap.size()>0||!master.isComplete()) {
			  //不需要等待所有的worker执行完就可以计算结果
			  Set<String> keys=resultMap.keySet();
			  String key =null;
			  for(String k:keys) {
				  key=k;
				  Integer i=null;
				  if(key!=null) {
					  i=(Integer)resultMap.get(key);
				  }
				  if(i!=null) {
					  re+=i;//最终计算结果
				  }
				  if(key!=null) {
					  resultMap.remove(key);
				  }
				  //break;
			  }
			 
			 
		  }
		  System.out.println(re);//打印最后计算结果
	  }
}
