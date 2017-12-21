package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

public class LostUpdateOccDiscard implements Runnable {
	private CountDownLatch countDown;

	public LostUpdateOccDiscard(CountDownLatch countDown) {
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
			conn.setAutoCommit(false);
			// 读的时候一并读出version
			PreparedStatement ps = conn.prepareStatement("select * from LostUpdate where id =1");
			ResultSet rs = ps.executeQuery();
			int count = 0;
			int version = 0;
			while (rs.next()) {
				count = rs.getInt("count");
				version = rs.getInt("version");
			}

			count++;

			// 更新操作，用cas原子操作来更新
			ps = conn.prepareStatement("update LostUpdate set count=?, version=version+1 where id =1 and version=?");
			ps.setInt(1, count);
			ps.setInt(2, version);
			int result = ps.executeUpdate();

			// 检查有无因冲突导致执行失败
			// 成功，则commit，完成任务
			if (result > 0) {
				conn.commit();
			}

			// 失败，回滚，抛异常提醒调用者出现冲突。
			else {
				conn.rollback();
				throw new Exception("更新count出现冲突");
			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 表示一次任务完成
		countDown.countDown();

	}
}
