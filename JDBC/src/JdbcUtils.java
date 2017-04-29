
public class JdbcUtils {
	/*
	public static void closeQuietly(PreparedStatement stmt)
	{
		if(stmt != null)
		{
			try
			{
				stmt.close();
			}
			catch(SQLException e)
			{
				// do nothing
			}
		}
			
	}
	
	public static void closeQuietly(Connection conn)
	{
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				// do nothing
			}
		}
			
	}
	*/
	public static void closeQuietly(AutoCloseable auto) //�����AutoCloseable��������ʹ����SQL�У�Ҳ����ʹ����I/O��
	{
		if(auto != null)
		{
			try 
			{
				auto.close();
			} 
			catch (Exception e) 
			{
				// do nothing
			}
		}
			
	}
	
	
}
