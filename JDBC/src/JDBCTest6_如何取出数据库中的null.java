import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest6_如何取出数据库中的null {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			while(resultSet.next())//游标（是去数据库服务器上命令“下一条”）
			{
				/*
				String s = resultSet.getString("name");
				int age = resultSet.getInt("Age");	 //因为int不能为null,所以只能返回一个默认值0
				boolean gender = resultSet.getBoolean("gender");//因为boolean不能为null,所以只能返回一个默认值0
				System.out.println("姓名："+s+"  "+"年龄："+age+"  "+"性别："+(gender?"man":"woman"));
				*/
				String name = resultSet.getString("Name");
				System.out.println("姓名是："+(name==null?"不知道":name));
				
				Integer iAge = (Integer)resultSet.getObject("Age");
				if(iAge == null)
				{
					System.out.println("年龄为：不知道");
				}
				else
				{
					int age = iAge;//隐式类型转换 (拆箱)
					System.out.println("年龄为："+iAge);
				}
				Boolean bGender = (Boolean)resultSet.getObject("Gender");
				if(bGender == null)
				{
					System.out.println("性别不知道");
				}
				else
				{
					boolean Gender = bGender;
					System.out.println(Gender?"man":"woman");
				}
				
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
