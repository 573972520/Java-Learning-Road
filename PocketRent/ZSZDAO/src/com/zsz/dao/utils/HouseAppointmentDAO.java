package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.rowset.JdbcRowSet;

import com.zsz.dto.HouseAppointmentDTO;
import com.zsz.dto.HouseDTO;

public class HouseAppointmentDAO {
		
	
	//新增一个预约：userId用户id（可以为null）；name姓名、phoneNum手机号、houseId房间id、visiteDate预约看房时间
	public long addnew(Long userId, String name, String phoneNum, long houseId, Date visitDate)
	{
		try {
			return JDBCUtils.executeInsert("Insert into t_houseappointments(UserId,Name,PhoneNum,HouseId,VisitDate，CreateDateTime) values(?,?,?,?,now())",userId,name,phoneNum,houseId,visitDate);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//抢单
	public boolean follow(long adminUserId, long houseAppointmentId) //使用select ***for update加行锁，这样防止两个人同时抢一个单，要放到事务中，处理不好容易死锁。
	{
		
	}

	//根据id获取预约
	public HouseAppointmentDTO getById(long id)
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
	//得到cityId这个城市中状态为status的预约订单数
	public long getTotalCount(long cityId, String status)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select count(?) from t_houseappointments where Id in(select Id from t_cities where IsDeleted=0 and Id=?)", status,cityId);
			if(rs.next())
			{
				return rs;
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
	//分页获取数据
	public HouseAppointmentDTO[] getPagedData(long cityId, String status, int pageSize, long currentIndex)//limit后面两个数不能用计算表达式，只能用固定的值，因此只能通过参数传递，计算在java中完成。
	{
		
	}
	
	private static HouseAppointmentDTO toDTO(ResultSet rs) throws SQLException
	{
		HouseAppointmentDTO dto = new HouseAppointmentDTO();
		dto.setId(rs.getLong("Id"));
		dto.setUserId(rs.getLong("UserId"));
		dto.setName(rs.getString("Name"));
		dto.setPhoneNum(rs.getString("PhoneNum"));
		dto.setVisitDate(rs.getDate("VisitDate"));
		dto.setHouseId(rs.getLong("HouseId"));
		dto.setCreateDateTime(rs.getDate("CreateDateTime"));
		dto.setStatus(rs.getString("Status"));
		dto.setFollowAdminUserId(rs.getLong("FollowAdminUserId"));
		dto.setFollowDateTime(rs.getDate("FollowDateTime"));
		return dto;
	}
}
