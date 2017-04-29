import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCTest1_加载了JDBC驱动和连接数据库 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载了JDBC驱动
			System.out.println("加载JDBC驱动成功");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql的JDBC驱动加载失败"+e.getMessage());
			return; //如果加载了，那么程序就没有必要再往执行了，所以使用return，不让程序再往下执行··
		}
		
		try {
			DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncoding=UTF-8","root","root");
			System.out.println("连接mysql成功");
		} catch (SQLException e) {
			System.out.println("连接mysql失败"+e.getMessage());
		}
		
	}

}
