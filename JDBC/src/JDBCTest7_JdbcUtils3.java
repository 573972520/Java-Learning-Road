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
			//CacheRowSet����ResultSet��Ӧ��:��һ�����߽������Ҳ���ǰ����ݱ��浽�ͻ���,Connection���Թرգ�ȱ�㣺ռ�ڴ棩
		}
	}

}
