package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.Port.Info;

public class UserDAO {
	
	/**
	 * 根据用户名获取用户对象
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public static UserInfo toModel(ResultSet rs) throws SQLException
	{
		UserInfo info = new UserInfo();
		info.setId(rs.getInt("Id"));
		info.setName(rs.getString("UserName"));
		info.setPassword(rs.getString("Password"));
		return info;
	}
	
	public static UserInfo getByUserName(String username)
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from T_Users where UserName=?", username);
			if(rs.next())
			{
				return toModel(rs);
			}
			else
			{
				return null;
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}
	
	/**
	 * 新增一个用户名
	 * @param userName
	 * @param password
	 */
	public static void addNew(String userName,String password)
	{
		try
		{
			JdbcUtils.executeUpdate("Insert into t_users(UserName,Password) values(?,?)", userName,password);
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
}
