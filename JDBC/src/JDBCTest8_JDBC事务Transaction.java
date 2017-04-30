import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest8_JDBC事务Transaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			//要在同一个连接中
			conn = JdbcUtils.createConnection();
			conn.setAutoCommit(false); // 默认提交改为false
			JdbcUtils.executeUpdate(conn,"Update T_Accounts set Amount=Amount-1000 where Number='0001'");
			//模拟扣1000元之后发生了异常，导致加1000没有成功
			String s = null;
			System.out.print(s.length());
			JdbcUtils.executeUpdate(conn,"Update T_Accounts set Amount=Amount+1000 where Number='0002'");
			conn.commit();//提交事务
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conn.rollback(); //回滚事务 —— 兄弟们，刚才的修改都不算数，回退回去
			} catch (SQLException e1) {
				System.out.println("回滚失败");
			}
		}
		finally
		{
			JdbcUtils.closeQuietly(conn);
		}
	}

}
