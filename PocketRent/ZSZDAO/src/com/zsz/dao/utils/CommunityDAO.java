package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.CommunityDTO;

public class CommunityDAO {
	//获取区域regionId下的所有小区
	public CommunityDTO[] getByRegionId(long regionId)
	{
		List<CommunityDTO> list = new ArrayList<CommunityDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_communities where RegionId=?", regionId);
			while(rs.next())
			{
				list.add(toDTO(rs));
			}
			return list.toArray(new CommunityDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
		
	}
	
	private static CommunityDTO toDTO(ResultSet rs) throws SQLException
	{
		CommunityDTO dto = new CommunityDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setRegionId(rs.getLong("RegionId"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		dto.setLocaton(rs.getString("Location"));
		dto.setTraffic(rs.getString("Traffic"));
		dto.setBuiltYear((Integer)rs.getObject("BuiltYear"));
		return dto;
	}

}
