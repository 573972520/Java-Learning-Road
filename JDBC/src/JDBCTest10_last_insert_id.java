import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest10_last_insert_id {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Connection conn = null;
		try
		{
			//放在同一个连接中
			conn = JdbcUtils.createConnection();
			
			/*
			JdbcUtils.executeUpdate("insert into T_Persons2(Name,Age) values(?,?)", "cc",2);
			//上面的代码和下面的代码会有并发问题 ,两个用户同时进行上面代码的操作，使下面的maxid出现错误
			rs = JdbcUtils.executeQuery("select max(id) maxid from T_Persons2");
			*/
			
			JdbcUtils.executeUpdate(conn,"insert into T_Persons2(Name,Age) values(?,?)", "cc",2);
			//last_insert_id() 获得当前连接中最后一次生产的自动递增字段的值
			rs = JdbcUtils.executeQuery(conn, "select last_insert_id() maxid");
			rs.next();
			long id = rs.getLong("maxid");
			System.out.println(id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}

}
