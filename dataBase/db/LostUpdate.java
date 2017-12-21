package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;


public class LostUpdate implements Runnable {
	private CountDownLatch countDownLatch;
	public LostUpdate(CountDownLatch countDownLatch) {
		this.countDownLatch=countDownLatch;
	}
	
	@Override
	public void run() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8","root","123");
		}catch(Exception e) {
			e.printStackTrace();
			return ;
		}
		
		try {
			connection.setAutoCommit(false);
			//不加锁
			PreparedStatement ps=connection.prepareStatement("select * from LostUpdate where id =1");
			//加锁
			//PreparedStatement ps=connection.prepareStatement("select * from LostUpdate where id =1 for update");
			ResultSet rs=ps.executeQuery();
			int count =0;
			while(rs.next()) {
				count=rs.getInt("count");
			}
			
			count++;
			ps=connection.prepareStatement("update LostUpdate set count=? where id =1");
			ps.setInt(1, count);
			ps.executeUpdate();
			connection.commit();
		}catch(Exception e) {
			try {
				connection.rollback();
			}catch(SQLException el) {
				el.printStackTrace();
			}
			e.printStackTrace();
		}
		//表示一次任务完成
		countDownLatch.countDown();
	}
}
