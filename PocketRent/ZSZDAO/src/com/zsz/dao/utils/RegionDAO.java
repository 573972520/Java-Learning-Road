package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.RegionDTO;

public class RegionDAO {
	public RegionDTO getById(long id)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_regions where Id=? ",id);
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
	
	private static RegionDTO toDTO(ResultSet rs) throws SQLException
	{
		RegionDTO dto = new RegionDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setCityId(rs.getLong("CityId"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}
	
	public RegionDTO[] getAll(long cityId)//获取城市下的区域
	{
		List<RegionDTO> list = new ArrayList<RegionDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_regions where IsDeleted=0 and CityId=?",cityId);
			while(rs.next())
			{
				RegionDTO dto = toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new RegionDTO[(list.size())]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}

}
