
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
	public static void closeQuietly(AutoCloseable auto) //这里的AutoCloseable不仅可以使用在SQL中，也可以使用于I/O中
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
