package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAO {

	public ArticleInfo getById(int id)
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from T_Articles where Id=?", id);
			if(rs.next())
			{
				ArticleInfo info = new ArticleInfo();
				info.setId(rs.getInt("Id"));
				info.setTitle(rs.getString("Title"));
				info.setContent(rs.getString("Content"));
				return info;
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
}
