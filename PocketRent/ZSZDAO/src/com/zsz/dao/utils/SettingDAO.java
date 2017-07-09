package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.SettingDTO;

public class SettingDAO {
	public void setValue(String name, String value)//设置配置项name的值为value
	{
		String oldValue = getValue(name,null);
		try
		{
			if(oldValue == null)
			{
				JDBCUtils.executeNonQuery("insert into t_setting(Name,Value) values(?,?)", name,value);
			}
			else
			{
				JDBCUtils.executeNonQuery("update t_setting set Value? where Name=?", name,value);
			}
		}
		catch(SQLException ex)
		{
			throw new RuntimeException(ex);
		}
		
	}
	
	private String getValue(String name) {
		return getValue(name,null);
	}
	
	public String getValue(String name , String defaultValue)//获取配置项name的值
	{
		try {
			String value = (String) JDBCUtils.querySingle("select Value from t_settings where Name=?", name);
			if(value == null)
			{
				return defaultValue;
			}
			else
			{
				return value;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public SettingDTO[] getAll()
	{
		List<SettingDTO> list = new ArrayList<SettingDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_settings");
			while(rs.next())
			{
				SettingDTO dto =toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new SettingDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
		
	}
	
	private static SettingDTO toDTO(ResultSet rs) throws SQLException
	{
		SettingDTO dto = new SettingDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setValue(rs.getString("Value"));
		return dto;
	}

}
