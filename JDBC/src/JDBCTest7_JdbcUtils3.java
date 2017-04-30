import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest7_JdbcUtils3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from T_Persons");
			while(rs.next())
			{
				String name = rs.getString("Name");
				System.out.println(name);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeAll(rs);
			//CacheRowSet（和ResultSet对应）:是一个离线结果集，也就是把数据保存到客户端,Connection可以关闭（缺点：占内存）
		}
	}

}
