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
	//���������ļ�
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
			//static�в����׳�checkException(��RuntimeException)
			throw new RuntimeException("����config.properties����",e);
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
			Class.forName(drivername);//����jdbc������ֻҪ����һ�Σ����Բ��ŵ�createConnection��
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("����Mysql jdbc����ʧ��",e);
		}
		
	}
	
	/**
	 * �ر�ResultSet�Լ����������Statement
	 * @param rs
	 */
	public static void closeResultSetAndStament(ResultSet rs)
	{
		JdbcUtils.closeQuietly(rs);
		//rs.getStatement();//�õ�����ResultSet��Statement
		try {
			JdbcUtils.closeQuietly(rs.getStatement());
		} catch (SQLException e) {
			// do nothing
		}
	}
	
	/**
	 * ��ResultSet�����Ӧ��Statement�Լ�Connection���ر�
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
	
	//PreparedStatement�Ǽ̳���Statement��
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
	
	public static void closeQuietly(AutoCloseable auto) //�����AutoCloseable��������ʹ����SQL�У�Ҳ����ʹ����I/O�У�JDK1��8֮�����
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
	
	//����ֱ���׳�SQLException�쳣����Ϊ�����ڲ�֪����ô������쳣�����׳�����Ҫ�������š�
	public static Connection createConnection() throws SQLException
	{
		return DriverManager.getConnection(dburl,dbusername,dbpassword);
	}
	
	/**
	 * ִ��sql�������
	 * @param conn 
	 * @param sql  sql���
	 * @param parameters ׼��ִ��sql���
	 * @return Ӱ���˶�����
	 * @throws SQLException
	 */
	public static int executeUpdate(Connection conn,
			String sql,Object...parameters) throws SQLException
	{
		PreparedStatement ps = null;
		try
		{
			ps = conn.prepareStatement(sql);
			for(int i=0;i<parameters.length;i++) //forѭ���Ǹ�sql����е�ռλ����ֵ
			{
				ps.setObject(i+1,parameters[i]);
			}
			return ps.executeUpdate();
		}
		/*��֪����ô�����쳣��ֱ��throws
		catch(SQLException e)
		{
			System.out.println("ִ�г���");//���ֻ�ǰ��쳣��ӡ���������㴦��
			//���"���쳣"��Ӧ�ú���ĸ��ߵ�����"����"
		}
		*/
		finally
		{
			closeQuietly(ps);
			//Connection�����˲���Ҫ���йرգ���Ϊ���ܻ�������
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
	 * ִ�в�ѯ���
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
			//����Ҫ�ر�PreparedStatement����Ϊ�����PreparedStatement�رգ���ôResultSet�Ϳ����ò�����
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
