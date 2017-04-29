import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest2_JDBC执行Insert语句 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载了JDBC驱动
			System.out.println("加载JDBC驱动成功");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql的JDBC驱动加载失败"+e.getMessage());
			return; //如果加载了，那么程序就没有必要再往执行了，所以使用return，不让程序再往下执行··
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncoding=UTF-8","root","root");
			//System.out.println(conn.getClass());
			//prepareStatement:准备执行,返回PreparedStatement对象
			stmt = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values('carl',20,0)");
			//System.out.println(stmt.getClass());
			int i = stmt.executeUpdate();//执行
			System.out.println("执行成功，影响了"+i+"条数据");
		} catch (SQLException e) {
			System.out.println("连接mysql失败:"+e.getMessage());
		}
	}

}
