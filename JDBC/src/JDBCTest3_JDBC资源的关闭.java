import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest3_JDBC资源的关闭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载了JDBC驱动
			System.out.println("加载JDBC驱动成功");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql的JDBC驱动加载失败"+e.getMessage());
			return; //如果加载了，那么程序就没有必要再往执行了，所以使用return，不让程序再往下执行··
		}
		
		Connection conn = null; //连接数据库之后，一定记得需要关闭，所以放在外面
		PreparedStatement stmt = null; //准备执行语句之后，一定记得需要关闭，所以放在外面
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncoding=UTF-8","root","root");
			//prepareStatement:准备执行,返回PreparedStatement对象
			stmt = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values('carl',20,0)");
			int i = stmt.executeUpdate();//执行
			System.out.println("执行成功，影响了"+i+"条数据");
		} catch (SQLException e) {
			System.out.println("操作数据失败"+e.getMessage());
		}
		finally
		{
			/*
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// do nothing 
				}
			}
			
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// do nothing 
				}
			}
			*/
			JdbcUtils.closeQuietly(stmt);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
