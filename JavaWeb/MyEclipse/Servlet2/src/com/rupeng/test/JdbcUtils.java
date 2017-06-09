package com.rupeng.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
	private static final String drivername;
	private static final String dburl;
	private static final String dbusername;
	private static final String dbpassword;
	//加载配置文件
	static 
	{
		InputStream inStream =null;
		try
		{
			inStream = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
			Properties prop = new Properties();
			prop.load(inStream);
			drivername = prop.getProperty("drivername");
			dburl = prop.getProperty("dburl");
			dbusername = prop.getProperty("dbusername");
			dbpassword = prop.getProperty("dbpassword");
		} 
		catch (IOException e) 
		{
			//static中不能抛出checkException(非RuntimeException)
			throw new RuntimeException("加载config.properties出错",e);
		}
		finally
		{
			if(inStream != null)
			{
				try 
				{
					inStream.close();
				} 
				catch (IOException e) 
				{
					// do nothing
				}
			}
		}
		
		try {
			Class.forName(drivername);//加载jdbc驱动，只要加载一次，所以不放到createConnection中
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("加载Mysql jdbc驱动失败",e);
		}
		
	}
	
	/**
	 * 关闭ResultSet以及和其关联的Statement
	 * @param rs
	 */
	public static void closeResultSetAndStament(ResultSet rs)
	{
		JdbcUtils.closeQuietly(rs);
		//rs.getStatement();//拿到创建ResultSet的Statement
		try {
			JdbcUtils.closeQuietly(rs.getStatement());
		} catch (SQLException e) {
			// do nothing
		}
	}
	
	/**
	 * 把ResultSet和其对应的Statement以及Connection都关闭
	 * @param rs
	 */
	public static void closeAll(ResultSet rs)
	{
		Statement stmt = null;
		Connection conn = null;
		try {
			stmt = rs.getStatement();
			conn = stmt.getConnection();
		} catch (SQLException e) {
			// do nothing
		}
		finally
		{
			JdbcUtils.closeQuietly(rs);
			JdbcUtils.closeQuietly(stmt);
			JdbcUtils.closeQuietly(conn);
		}
	}
	
	//PreparedStatement是继承自Statement的
	//public static void closeQuietly(PreparedStatement stmt)
	public static void closeQuietly(Statement stmt)
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
	
	public static void closeQuietly(AutoCloseable auto) //这里的AutoCloseable不仅可以使用在SQL中，也可以使用于I/O中，JDK1。8之后才有
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
	
	//这里直接抛出SQLException异常是因为：对于不知道怎么处理的异常，就抛出，不要藏着掩着。
	public static Connection createConnection() throws SQLException
	{
		return DriverManager.getConnection(dburl,dbusername,dbpassword);
	}
	
	/**
	 * 执行sql更新语句
	 * @param conn 
	 * @param sql  sql语句
	 * @param parameters 准备执行sql语句
	 * @return 影响了多少行
	 * @throws SQLException
	 */
	public static int executeUpdate(Connection conn,
			String sql,Object...parameters) throws SQLException
	{
		PreparedStatement ps = null;
		try
		{
			ps = conn.prepareStatement(sql);
			for(int i=0;i<parameters.length;i++) //for循环是给sql语句中的占位符赋值
			{
				ps.setObject(i+1,parameters[i]);
			}
			return ps.executeUpdate();
		}
		/*不知道怎么处理异常，直接throws
		catch(SQLException e)
		{
			System.out.println("执行出错");//如果只是把异常打印出来，不算处理
			//这叫"吃异常"，应该合理的告诉调用者"错了"
		}
		*/
		finally
		{
			closeQuietly(ps);
			//Connection用完了不需要进行关闭，因为可能还有用呢
		}
	}
	
	public static int executeUpdate(String sql,Object...parameters) throws SQLException
	{
		Connection conn = null;
		try
		{
			conn = createConnection();
			return executeUpdate(conn,sql,parameters);
		}
		finally
		{
			closeQuietly(conn);
		}
	}
	
	
	
	/**
	 * 执行查询语句
	 * @param conn
	 * @param sql
	 * @param parameters
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(Connection conn,
			String sql,Object...parameters) throws SQLException
	{
		
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=0;i<parameters.length;i++)
			{
				ps.setObject(i+1,parameters[i]);
			}
			return ps.executeQuery();
			//不需要关闭PreparedStatement，因为如果将PreparedStatement关闭，那么ResultSet就可能用不了了
	}
	
	public static ResultSet executeQuery(String sql,Object...parameters) throws SQLException
	{
		Connection conn = createConnection();
		return executeQuery(conn,sql,parameters);
	}
	
	public static void rollback(Connection conn)
	{
		try {
			conn.rollback();
		} catch (SQLException e) {
			// do nothing
		}
	}
}
