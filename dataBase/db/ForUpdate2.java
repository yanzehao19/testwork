package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

public class ForUpdate2 implements Runnable {
	private CountDownLatch countDown;

	public ForUpdate2(CountDownLatch countDown) {
		this.countDown = countDown;
	}

	@Override
	public void run() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "123");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			Thread.sleep(2000);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("select * from LostUpdate where id =1 for update");
			ps.executeQuery();
			/*
			 * PreparedStatement ps
			 * =conn.prepareStatement("update LostUpdate set count =1 where id =1");
			 * ps.executeUpdate();
			 */

			conn.commit();
			System.out.println("test 2 finish");
			countDown.countDown();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
