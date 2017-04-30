import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest5_拼接SQL实现登陆 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入用户名");
		String username = sc.nextLine();
		System.out.print("请输入密码");
		String password = sc.nextLine();
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
			/*
			String sql = "select count(*) c from t_users where Username = '"+username+"' and Password = '"+password+"'";
			System.out.println(sql); 
			ps = conn.prepareStatement(sql);
			*/
			String sql = "select count(*) c from t_users where Username = ? and Password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			System.out.println(sql);
			resultSet = ps.executeQuery();
			resultSet.next();
			int c = resultSet.getInt("c");
			System.out.println(c);
			if(c <= 0)
			{
				System.out.println("no");
			}
			else
			{
				System.out.println("yes");
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
