package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClassDAO {

	public ClassInfo toModel(ResultSet rs) throws SQLException
	{
		ClassInfo info = new ClassInfo();
		info.setId(rs.getInt("Id"));
		info.setName(rs.getString("Name"));
		info.setRoomNum(rs.getString("RoomNum"));
		info.setTeacherId(rs.getInt("TeacherId"));
		return info;
	}
	
	public List<ClassInfo> getAll()
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from t_classes");
			List<ClassInfo> list = new LinkedList<ClassInfo>();
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
