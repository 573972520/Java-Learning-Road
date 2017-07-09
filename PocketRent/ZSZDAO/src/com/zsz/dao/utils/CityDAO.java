package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.CityDTO;

public class CityDAO {
	//根据id获取城市DTO
	public CityDTO getById(long id)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_cities where id=? and IsDeleted=0",id);
			if(rs.next())
			{
				return toDTO(rs);
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}

	//获取所有城市
	public CityDTO[] getAll()
	{
		List<CityDTO> list = new ArrayList<CityDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_cities where IsDeleted=0");
			while(rs.next())
			{
				list.add(toDTO(rs));
			}
			return list.toArray(new CityDTO[(list.size())]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	
	private static CityDTO toDTO(ResultSet rs) throws SQLException
	{
		CityDTO dto = new CityDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}

}
