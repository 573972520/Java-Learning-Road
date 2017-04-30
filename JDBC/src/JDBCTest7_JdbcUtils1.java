import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest7_JdbcUtils1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		try {
			JdbcUtils.executeUpdate("Insert into T_Persons(Name,Age,Gender) values(?,?,?)",
					"360",45,false);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		
		long startms = System.currentTimeMillis();
		Connection conn = null;
		try {
			conn = JdbcUtils.createConnection();
			for(int i =0;i<100;i++)
			{
				JdbcUtils.executeUpdate(conn,"Insert into T_Persons(Name,Age,Gender) values(?,?,?)",
						"360",45,false);
			}
			long endms = System.currentTimeMillis();
			System.out.println("执行耗时"+(endms-startms)); //10条SQL耗时：1083    100条SQL耗时3991
		} catch (SQLException e) {
			System.err.println(e);
		}
		finally
		{
			JdbcUtils.closeQuietly(conn);
		}
		*/
		
		long startms = System.currentTimeMillis();
		try {
			for(int i =0;i<100;i++)
			{
				JdbcUtils.executeUpdate("Insert into T_Persons(Name,Age,Gender) values(?,?,?)",
						"360",45,false);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		long endms = System.currentTimeMillis();
		System.out.println("执行耗时"+(endms-startms)); //10条SQL耗时：1448   100条SQL耗时6426  这个耗时多是因为程序执行时，一直在重复执行与SQL服务器"连接——断开连接"这一过程
		
	}

}
