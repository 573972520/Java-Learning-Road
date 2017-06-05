package com.rupeng.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils
{
	private final static String dbdriver = "com.mysql.jdbc.Driver";
	private final static String dburl = "jdbc:mysql://localhost:3306/javaweb1?seUnicode=true&characterEncoding=UTF8";
	private final static String dbusername = "root";
	private final static String dbpassword = "root";
	static
	{
		try
		{
			Class.forName(dbdriver);
		} catch (ClassNotFoundException e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection createConnection() throws SQLException
	{
		return DriverManager.getConnection(dburl, dbusername, dbpassword);
	}

	public static void close(Connection conn)
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (SQLException e)
			{

			}
		}
	}

	public static void close(Statement stmt)
	{
		if (stmt != null)
		{
			try
			{
				stmt.close();
			} catch (SQLException e)
			{

			}
		}
	}

	public static void close(ResultSet rs)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			} catch (SQLException e)
			{

			}
		}
	}

	public static int executeUpdate(String sql, Object... parameters)
			throws SQLException
	{
		Connection conn = null;
		try
		{
			conn = createConnection();
			return executeUpdate(conn, sql, parameters);
		} finally
		{
			close(conn);
		}
	}

	public static int executeUpdate(Connection conn, String sql,
			Object... parameters) throws SQLException
	{
		PreparedStatement ps = null;
		try
		{
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++)
			{
				ps.setObject(i + 1, parameters[i]);
			}
			return ps.executeUpdate();
		} finally
		{
			close(ps);
		}
	}

	public static ResultSet executeQuery(String sql, Object... parameters)
			throws SQLException
	{
		Connection conn = null;
		try
		{
			conn = createConnection();
			return executeQuery(conn, sql, parameters);
		} catch (SQLException ex)
		{
			close(conn);
			throw ex;
		}
	}

	public static ResultSet executeQuery(Connection conn, String sql,
			Object... parameters) throws SQLException
	{
		PreparedStatement ps = null;
		try
		{
			ResultSet rs = null;
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++)
			{
				ps.setObject(i + 1, parameters[i]);
			}
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException ex)
		{
			close(ps);
			throw ex;
		}
	}

	public static void closeAll(ResultSet rs)
	{
		if (rs == null)
		{
			return;
		}
		try
		{
			close(rs.getStatement().getConnection());
			close(rs.getStatement());
			close(rs);
		} catch (SQLException e)
		{

		}
	}
	
	public static void rollback(Connection conn)
	{
		try
		{
			conn.rollback();
		} catch (SQLException e)
		{
			//
		}
	}
}
