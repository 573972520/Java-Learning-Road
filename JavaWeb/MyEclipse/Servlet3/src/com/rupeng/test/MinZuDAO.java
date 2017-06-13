package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MinZuDAO {
	

	public MinZuInfo toModel(ResultSet rs) throws SQLException
	{
		MinZuInfo info = new MinZuInfo();
		info.setId(rs.getInt("Id"));
		info.setName(rs.getString("Name"));
		return info;
	}
	
	public List<MinZuInfo> getAll()
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from t_minzus");
			List<MinZuInfo> list = new LinkedList<MinZuInfo>();
			while(rs.next())
			{
				list.add(toModel(rs));
			}
			return list;
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
