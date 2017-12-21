package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

public class LostUpdateOcc implements Runnable {
	 private CountDownLatch countDown;
	    public LostUpdateOcc(CountDownLatch countDown){
	        this.countDown = countDown;
	    }
	    
	    @Override
	    public void run() {
	    	 Connection conn=null;
	         try {
	             Class.forName("com.mysql.jdbc.Driver");
	             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8",
	                     "root", "123");
	         } catch (Exception e) {
	             e.printStackTrace();
	             return;
	         }
	         
	         try {            
	             int try_times=100;
	             int count;
	             int version;    
	             PreparedStatement ps;
	             ResultSet rs;
	             
	             //把循环条件放在里面if里
	             while(try_times>0){
	                 //开始事务
	                 try_times--;
	                 conn.setAutoCommit(false);
	                 
	                 //读操作
	                 ps=conn.prepareStatement("select * from LostUpdate where id =1");
	                 rs=ps.executeQuery();
	                 
	                 //判断事务执行的条件，首先是能执行，其次是需要执行
	                 if(rs.next()){
	                     count= rs.getInt("count");
	                     version= rs.getInt("version");
	                     
	                     count++;
	                     
	                     //更新操作，用cas原子操作来更新
	                     ps =conn.prepareStatement("update LostUpdate set count=?, version=version+1 where id =1 and version=?");
	                     ps.setInt(1, count);
	                     ps.setInt(2, version);
	                     int result = ps.executeUpdate();
	                     
	                     //每次执行完更新操作，检测一次冲突
	                     //成功，则继续事务
	                     //失败，回滚，睡100ms，避开竞争。结束这次循环，开启新事务。
	                     if(result==0) {    
	                         conn.rollback();
	                         Thread.sleep(100);
	                         continue;
	                     }
	                     
	                     //事务一路顺风，没遇到冲突，事务提交，跳出while
	                     conn.commit();
	                     break;
	                 }
	                 //作为while条件不成立时的处理，比如该行数据被删除。
	                 else{
	                     conn.rollback();
	                     break;
	                 }                                                            
	             }
	             if(try_times<=0) throw new Exception("冲突重试的此时过多，事务失败");
	             System.out.println(try_times);
	         } catch (SQLException e) {
	             try {
	                 conn.rollback();
	             } catch (SQLException e1) {
	                 e1.printStackTrace();
	             }
	             e.printStackTrace();
	         }catch (Exception e) {
	             System.out.println(e.getMessage());
	         }
	         
	         //表示一次任务完成
	         countDown.countDown();
	         
	    }
}
