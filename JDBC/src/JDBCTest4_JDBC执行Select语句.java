import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest4_JDBC执行Select语句 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("加载驱动失败"+e.getMessage());
			return;
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncode=UTF-8","root","root");
			ps = conn.prepareStatement("select * from T_Persons");
			resultSet = ps.executeQuery();
			while(resultSet.next())
			{
				/* 自己写的
				String s = resultSet.getString("name");
				int age = resultSet.getInt("Age");	
				int gender = resultSet.getInt("gender");
				if(gender == 1)
				{
					System.out.println(" ");
					System.out.print(s+"  "+age+"  "+"man");
				}
				else if(gender == 0)
				{
					System.out.println(" ");
					System.out.print(s+"  "+age+"  "+"woman");
				}
				else
				{
					
				}
				*/
				
				// 老师写的
				String s = resultSet.getString("name");
				int age = resultSet.getInt("Age");	
				boolean gender = resultSet.getBoolean("gender");
				System.out.println("姓名："+s+"  "+"年龄："+age+"  "+"性别："+(gender?"man":"woman"));
			}
		} catch (SQLException e) {
			System.err.println("数据库操作失败"+e.getMessage());
		}
		finally
		{
			JdbcUtils.closeQuietly(resultSet);
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
