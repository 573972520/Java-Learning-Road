package com.zsz.dao.utils;

import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.mysql.fabric.xmlrpc.base.Array;
import com.zsz.dto.HouseDTO;
import com.zsz.dto.HousePicDTO;
import com.zsz.dto.IdNameDTO;

public class HouseDAO {
	
	private static final String selectMainSQL;
	static {
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(
				"select h.*, region.CityId CityId,  region.Name RegionName,community.Name  CommunityName,community.Location CommunityLocation,\n");
		sbSQL.append(
				"community.Traffic CommunityTraffic, community.BuiltYear CommunityBuiltYear, city.Name CityName,  roomType.Name RoomTypeName,\n");
		sbSQL.append("Status.Name StatusName,DecorateStatus.Name DecorateStatusName,Type.Name TypeName\n");
		sbSQL.append("from T_Houses h\n");
		sbSQL.append("left join T_Regions region on h.RegionId=region.Id\n");
		sbSQL.append("left join T_Communities community on h.CommunityId=community.Id\n");
		sbSQL.append("left join T_Cities city on region.CityId=city.Id\n");
		sbSQL.append("left join T_IdNames roomType   on h. RoomTypeId=roomType .Id\n");
		sbSQL.append("left join T_IdNames Status  on h.StatusId= Status.Id\n");
		sbSQL.append("left join T_IdNames DecorateStatus  on h.DecorateStatusId= DecorateStatus.Id\n");
		sbSQL.append("left join T_IdNames Type  on h.TypeId= Type.Id\n");

		selectMainSQL = sbSQL.toString();
	}

	public HouseDTO getById(long id)
	{
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(selectMainSQL);
		sbSQL.append("where h.Id=? and h.IsDeleted=0");
		
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery(sbSQL.toString(), id);
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

	//获取typeId这种房源类别下cityId这个城市中房源的总数量
	public long getTotalCount(long cityId, long typeId)
	{
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(selectMainSQL);
		sbSQL.append("select count(*) from T_Houses h\n");
		sbSQL.append("left join T_Regions region on h.RegionId=region.Id\n");
		sbSQL.append("where region.CityId=? and h.TypeId=? and h.IsDeleted=0\n");
		Number num;
		try
		{
			num = (Number)JDBCUtils.querySingle(sbSQL.toString(), cityId,typeId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return num.longValue();
	}
	
	public HouseDTO[] getAll()
	{
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(selectMainSQL);
		sbSQL.append("where h.IsDeleted=0\n");
		
		List<HouseDTO> houses = new ArrayList<>();
		ResultSet rs = null;
		try 
		{
			rs = JDBCUtils.executeQuery(sbSQL.toString());
			while(rs.next())
			{
				houses.add(toDTO(rs));
			}
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
		return houses.toArray(new HouseDTO[houses.size()]);
	}
	
	//分页获取typeId这种房源类别下cityId这个城市中房源
	public HouseDTO[] getPagedData(long cityId, long typeId, int pageSize, long currentIndex)
	{
		if(currentIndex <= 0)
		{
			throw new IllegalArgumentException("currentIndex必须 > 0");
		}
		if(pageSize <= 0)
		{
			throw new IllegalArgumentException("pageSize必须 > 0");
		}
		
		StringBuilder sbSQL = new StringBuilder();
		sbSQL.append(selectMainSQL);
		sbSQL.append("where region.CityId=? and h.TypeId=? and h.IsDeleted=0\n");
		sbSQL.append("limit ?,?\n");
		
		List<HouseDTO> houses = new ArrayList<>();
		ResultSet rs = null;
		try 
		{
			rs = JDBCUtils.executeQuery(sbSQL.toString(),cityId,typeId,(currentIndex-1)*pageSize,pageSize);
			while(rs.next())
			{
				houses.add(toDTO(rs));
			}
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
		return houses.toArray(new HouseDTO[houses.size()]);
	}

	//新增房源，返回房源id
	public long addnew(HouseDTO house) //事务
	{
		StringBuilder sb = new StringBuilder();
		sb.append(
				"insert into T_Houses(RegionId,CommunityId,RoomTypeId,Address,MonthRent,StatusId,Area,DecorateStatusId,TotalFloorCount,\n");
		sb.append(
				"FloorIndex,TypeId,Direction,LookableDateTime,CheckInDateTime,OwnerName,OwnerPhoneNum,CreateDateTime,Description,IsDeleted)\n");
		sb.append("values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,0)");

		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			long houseId = JDBCUtils.executeInsert(conn, sb.toString(), house.getRegionId(), house.getCommunityId(),
					house.getRoomTypeId(), house.getAddress(), house.getMonthRent(), house.getStatusId(),
					house.getArea(), house.getDecorateStatusId(), house.getTotalFloorCount(), house.getFloorIndex(),
					house.getTypeId(), house.getDirection(), house.getLookableDateTime(), house.getCheckInDateTime(),
					house.getOwnerName(), house.getOwnerPhoneNum(), house.getDescription());

			for (long attId : house.getAttachmentIds()) {
				JDBCUtils.executeNonQuery(conn, "insert into t_houseattachments(HouseId,AttachmentId) values(?,?)",
						houseId, attId);
			}
			conn.commit();
			return houseId;
		} catch (SQLException e) {
			JDBCUtils.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeQuietly(conn);
		}
	}
	//更新房源，房源的附件先删除再新增
	public void update(HouseDTO house)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(
				"update T_Houses set RegionId=?,CommunityId=?,RoomTypeId=?,Address=?,MonthRent=?,StatusId=?,Area=?,DecorateStatusId=?,TotalFloorCount=?,\n");
		sb.append(
				"FloorIndex=?,TypeId=?,Direction=?,LookableDateTime=?,CheckInDateTime=?,OwnerName=?,OwnerPhoneNum=?,Description=?\n");
		sb.append("where Id=?");
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);

			JDBCUtils.executeNonQuery(conn, sb.toString(), house.getRegionId(), house.getCommunityId(),
					house.getRoomTypeId(), house.getAddress(), house.getMonthRent(), house.getStatusId(),
					house.getArea(), house.getDecorateStatusId(), house.getTotalFloorCount(), house.getFloorIndex(),
					house.getTypeId(), house.getDirection(), house.getLookableDateTime(), house.getCheckInDateTime(),
					house.getOwnerName(), house.getOwnerPhoneNum(), house.getDescription(), house.getId());

			// 先删，后加
			JDBCUtils.executeNonQuery(conn, "delete from t_houseattachments where HouseId=?", house.getId());
			for (long attId : house.getAttachmentIds()) {
				JDBCUtils.executeNonQuery(conn, "insert into t_houseattachments(HouseId,AttachmentId) values(?,?)",
						house.getId(), attId);
			}

			conn.commit();
		} catch (SQLException ex) {
			JDBCUtils.rollback(conn);
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeQuietly(conn);
		}
	}
	//软删除
	public void markDeleted(long id)
	{
		try
		{
			JDBCUtils.executeNonQuery("update T_Houses set IsDeleted=1 where Id=?", id);
		}catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
		
	}
	/*//得到房源的图片
	public HousePicDTO[] getPics(long houseId)
	{
		List<HousePicDTO> list = new ArrayList<HousePicDTO>();
		ResultSet rs = null;
		try
		{
			rs = JDBCUtils.executeQuery("select * from t_HousePics where IsDeleted=0 and HouseId=?",houseId);
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
	}*/
	
	
	public HousePicDTO[] getPics(long houseId) {
		ResultSet rs = null;
		List<HousePicDTO> list = new ArrayList<>();
		try {
			rs = JDBCUtils.executeQuery("select * from T_HousePics where HouseId=? and IsDeleted=0", houseId);
			while (rs.next()) {
				HousePicDTO housePic = new HousePicDTO();
				housePic.setCreateDateTime(rs.getDate("CreateDateTime"));
				housePic.setDeleted(rs.getBoolean("IsDeleted"));
				housePic.setHeight(rs.getInt("Height"));
				housePic.setHouseId(rs.getLong("HouseId"));
				housePic.setId(rs.getLong("Id"));
				housePic.setUrl(rs.getString("Url"));
				housePic.setWidth(rs.getInt("Width"));
				housePic.setThumbUrl(rs.getString("ThumbUrl"));

				list.add(housePic);
			}
			return list.toArray(new HousePicDTO[list.size()]);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeAll(rs);
		}
	}
	//添加房源图片
	public long addnewHousePic(HousePicDTO housePic)
	{
		try
		{
			return JDBCUtils.executeInsert("Insert into T_HousePics(HouseId,Url,ThumbUrl,Width,Height,CreateDateTime,IsDeleted) values(?,?,?,?,?,now(),0)", 
					housePic.getHouseId(),housePic.getUrl(),housePic.getThumbUrl(),housePic.getWidth(),housePic.getHeight());
		}catch(SQLException ex)
		{
			throw new RuntimeException();
		}
	}

	//软删除房源图片
	public void deleteHousePic(long housePicId)
	{
		try
		{
			JDBCUtils.executeNonQuery("update T_HousePics set IsDeleted=1 where Id=?", housePicId);
		}catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

/*	//搜索，返回值包含：总条数和HouseDTO[] 两个属性
	public HouseSearchResult Search(HouseSearchOptions options)
	{
		
	}
	*/
	private static HouseDTO toDTO(ResultSet rs) throws SQLException
	{
		long id = rs.getLong("Id");
		HouseDTO house = new HouseDTO();
		house.setAddress(rs.getString("Address"));
		house.setArea(rs.getDouble("Area"));
		house.setCheckInDateTime(rs.getDate("CheckInDateTime"));
		house.setCommunityId(rs.getLong("CommunityId"));
		house.setCommunityName(rs.getString("CommunityName"));
		house.setCommunityLocation(rs.getString("CommunityLocation"));
		house.setCommunityTraffic(rs.getString("CommunityTraffic"));
		house.setCommunityBuiltYear((Integer) rs.getObject("CommunityBuiltYear"));
		house.setDecorateStatusId(rs.getLong("DecorateStatusId"));
		house.setDecorateStatusName(rs.getString("DecorateStatusName"));
		house.setDirection(rs.getString("Direction"));
		house.setFloorIndex(rs.getInt("FloorIndex"));
		house.setId(id);
		house.setLookableDateTime(rs.getDate("LookableDateTime"));
		house.setMonthRent(rs.getInt("MonthRent"));
		house.setCityId(rs.getLong("CityId"));
		house.setCityName(rs.getString("CityName"));
		house.setRegionId(rs.getLong("RegionId"));
		house.setRegionName(rs.getString("RegionName"));
		house.setRoomTypeId(rs.getLong("RoomTypeId"));
		house.setRoomTypeName(rs.getString("RoomTypeName"));
		house.setStatusId(rs.getLong("StatusId"));
		house.setStatusName(rs.getString("StatusName"));
		house.setTotalFloorCount(rs.getInt("TotalFloorCount"));
		house.setTypeId(rs.getLong("TypeId"));
		house.setTypeName(rs.getString("TypeName"));
		house.setOwnerName(rs.getString("OwnerName"));
		house.setOwnerPhoneNum(rs.getString("OwnerPhoneNum"));
		house.setDescription(rs.getString("Description"));
		house.setCreateDateTime(rs.getDate("CreateDateTime"));
		house.setDeleted(rs.getBoolean("IsDeleted"));

		List<Long> listAttachmentId = new ArrayList<>();// 泛型中不能用原始数据类型
		ResultSet rsAtt = null;
		try {
			rsAtt = JDBCUtils.executeQuery("select AttachmentId from t_houseattachments where HouseId=?", id);
			while (rsAtt.next()) {
				listAttachmentId.add(rsAtt.getLong("AttachmentId"));
			}
		} finally {
			JDBCUtils.closeAll(rsAtt);
		}
		Long[] attacheIds = listAttachmentId.toArray(new Long[listAttachmentId.size()]);

		// house.setAttachmentIds(toPrimitive(attacheIds));
		house.setAttachmentIds(ArrayUtils.toPrimitive(attacheIds));
		HousePicDTO[] pics = getPics(id);// 获得房子的图片
		if (pics.length > 0)// 获得第一张图片的缩略图
		{
			house.setFirstThumbUrl(pics[0].getThumbUrl());
		}

		// todo:house.setAttachmentIds的初始化
		// todo:house.setFirstThumbUrl(
		return house;
	}
	
	
	/*转成原始类型
	private long[] toPrimitive(Long[] arrays)
	{
		long[] longs = new long[arrays.length];
		for (int i = 0; i < arrays.length; i++) {
			longs[i] = arrays[i];
		}
		return longs;
	}
	*/

}
