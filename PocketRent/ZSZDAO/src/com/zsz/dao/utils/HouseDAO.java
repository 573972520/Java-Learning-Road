package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.HouseDTO;
import com.zsz.dto.HousePicDTO;
import com.zsz.dto.IdNameDTO;

public class HouseDAO {

	public HouseDTO getById(long id)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_houseappointments where Id=?", id);
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
/*
	//获取typeId这种房源类别下cityId这个城市中房源的总数量
	public long getTotalCount(long cityId, long typeId)
	{
		
	}
	//分页获取typeId这种房源类别下cityId这个城市中房源
	public HouseDTO[] getPagedData(long cityId, long typeId, int pageSize, long currentIndex)

	//新增房源，返回房源id
	public long addnew(HouseDTO house) 事务

	//更新房源，房源的附件先删除再新增
	public void update(HouseDTO house)

	//软删除
	public void markDeleted(long id)
	{
		
	}*/
	//得到房源的图片
	public HousePicDTO[] getPics(long houseId)
	{
		List<HousePicDTO> list = new ArrayList<HousePicDTO>();
		ResultSet rs = null;
		try
		{
			rs = JDBCUtils.executeQuery("select * from t_houses where IsDeleted=0 and Id=?",houseId);
			while(rs.next())
			{
				HousePicDTO dto = toDTOPic(rs);
				list.add(dto);
			}
			return list.toArray(new HousePicDTO[list.size()]);
		}
		catch(SQLException ex)
		{
			throw new RuntimeException();
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
/*	//添加房源图片
	public long addnewHousePic(HousePicDTO housePic)
	{
		
	}

	//软删除房源图片
	public void deleteHousePic(long housePicId)

	//搜索，返回值包含：总条数和HouseDTO[] 两个属性
	public HouseSearchResult Search(HouseSearchOptions options)

	*/
	private static HouseDTO toDTO(ResultSet rs) throws SQLException
	{
		HouseDTO dto = new HouseDTO();
		dto.setId(rs.getLong("Id"));
		dto.setRegionId(rs.getLong("RegionId"));
		dto.setCommunityId(rs.getLong("CommunityId"));
		dto.setRoomTypeId(rs.getLong("RoomTypeId"));
		dto.setAddress(rs.getString("Address"));
		dto.setMonthRent(rs.getInt("MonthRent"));
		dto.setStatusId(rs.getLong("StatusId"));
		dto.setArea(rs.getDouble("Area"));
		dto.setDecorateStatusId(rs.getLong("DecorateStatusId"));
		dto.setTotalFloorCount(rs.getInt("TotalFloorCount"));
		dto.setFloorIndex(rs.getInt("FloorIndex"));
		dto.setTypeId(rs.getLong("TypeId"));
		dto.setDirection(rs.getString("Direction"));
		dto.setLookableDateTime(rs.getDate("LookableDateTime"));
		dto.setCheckInDateTime(rs.getDate("CheckInDateTime"));
		dto.setOwnerName(rs.getString("OwnerName"));
		dto.setOwnerPhoneNum(rs.getString("OwnerPhoneNum"));
		dto.setCreateDateTime(rs.getDate("CreateDateTime"));
		dto.setDescription(rs.getString("Description"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}
	
	private static HousePicDTO toDTOPic(ResultSet rs) throws SQLException
	{
		HousePicDTO dto = new HousePicDTO();
		dto.setId(rs.getLong("Id"));
		dto.setHouseId(rs.getLong("HouseId"));
		dto.setUrl(rs.getString("Url"));
		dto.setThumbUrl(rs.getString("ThumbUrl"));
		dto.setWidth(rs.getInt("Width"));
		dto.setHeight(rs.getInt("Height"));
		dto.setCreateDateTime(rs.getDate("CreateDateTime"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}
}
