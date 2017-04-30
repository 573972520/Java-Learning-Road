import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest7_JdbcUtils2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		ResultSet rs = null;
		try
		{
			conn = JdbcUtils.createConnection();
			rs = JdbcUtils.executeQuery(conn,"select * from T_Persons");
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
			/*
			JdbcUtils.closeQuietly(rs);
			//rs.getStatement();//拿到创建ResultSet的Statement
			try {
				JdbcUtils.closeQuietly(rs.getStatement());
			} catch (SQLException e) {
				// do nothing
			}
			*/
			JdbcUtils.closeResultSetAndStament(rs);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
