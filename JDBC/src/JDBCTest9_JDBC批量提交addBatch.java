import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest9_JDBC批量提交addBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Connection conn = null;
		PreparedStatement ps = null;
		long startms = System.currentTimeMillis();
		try
		{
			conn = JdbcUtils.createConnection();
			ps = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values(?,?,?)");
			for(int i=0;i<1000;i++)
			{
				ps.clearParameters();//Statement重复使用，吧上次设置的查询参数的值都清空
				ps.setString(1, "Tom"+i);
				ps.setInt(2, i);
				ps.setBoolean(3, true);
				ps.executeUpdate();
			}
			long endms = System.currentTimeMillis();
			System.out.println("耗时为："+(endms-startms)); //耗时为：50168
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
		*/
		Connection conn = null;
		PreparedStatement ps = null;
		long startms = System.currentTimeMillis();
		try
		{
			conn = JdbcUtils.createConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values(?,?,?)");
			for(int i=0;i<1000;i++)
			{
				ps.clearParameters();//Statement重复使用，把上次设置的查询参数的值都清空
				ps.setString(1, "Tom"+i);
				ps.setInt(2, i);
				ps.setBoolean(3, true);
				//ps.executeUpdate();//每一次都通知服务器插一条记录————性能差
				ps.addBatch(); //将提交数据的命令装到箱子里
				if(i%1000 == 0) //每装满1000个命令，提交一次
				{
					ps.executeBatch(); 
				}
			}
			//把剩余的，没有满1000个命令的提交一次
			ps.executeBatch(); //把箱子里的命令一次提交给mysql
			conn.commit();
			long endms = System.currentTimeMillis();
			System.out.println("耗时为："+(endms-startms)); //耗时为：1285
		}
		catch(SQLException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("回滚失败");
			}
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
