package com.zsz.dao.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import com.zsz.dto.HouseAppointmentDTO;
import com.zsz.dto.HouseDTO;

public class HouseAppointmentDAO {
		

	//新增一个预约：userId用户id（可以为null）；name姓名、phoneNum手机号、houseId房间id、visiteDate预约看房时间
	public long addnew(Long userId, String name, String phoneNum, long houseId, Date visitDate)
	{
		Number number;
		try {
			number = JDBCUtils.executeInsert("Insert into t_houseappointments(UserId,Name,PhoneNum,VisitDate,HouseId,CreateDateTime,Status) values(?,?,?,?,?,now(),'新建')",userId,name,phoneNum,visitDate,houseId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return  number.longValue();
	}


	/**
	 * 抢单(锁实现抢单)  数据库锁会降低数据库的性能 只适用与较小并发量的提交
	 * 其他解决并发问题的方法
	 * 1、两阶段提交
	 * 2、排队
	 * @param adminUserId
	 * @param houseAppointmentId
	 * @return 
	 */
	public boolean follow(long adminUserId, long houseAppointmentId) //使用select ***for update加行锁，这样防止两个人同时抢一个单，要放到事务中，处理不好容易死锁。
	{
		/*
		//select for update
		//其他人就不能对这几条数据进行处理，只有我处理完成之后其他人才能处理
		try
		{
			Number number = (Number)JDBCUtils.querySingle("select count(*) from t_houseappointments where Status = '新建' and Id =?", 
					houseAppointmentId);
			if(number.intValue() <= 0)  //订单被抢走了
			{
				return false;
			}
			//把订单更新成：在跟进，并且把跟进人设置为自己
			JDBCUtils.executeNonQuery("Update t_houseappointments set Status='在跟进', FollowAdminUserId=?", houseAppointmentId);
			return true;
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		*/
		
		
		//数据库锁：Lock
		
		//select ... for update 和 update语句要在同一个事务中。 一般的事务要在同一连接中
		Connection conn = null;
		try
		{
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false); //启动事务
			
			Number number = (Number)JDBCUtils.querySingle(conn,"select count(*) from t_houseappointments where Id =? and Status = '新建' for update", 
					houseAppointmentId);
			if(number.intValue() <= 0)  //订单被抢走了
			{
				conn.rollback(); //一定要rollback不能忘   这条语句是为了解锁for update
				return false;
			}
			JDBCUtils.executeNonQuery(conn,"Update t_houseappointments set Status='在跟进', FollowAdminUserId=?", adminUserId);
			conn.commit();
			return true;
		}
		catch(SQLException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
			}
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeQuietly(conn);
		}
		
	}

	//根据id获取预约
	public HouseAppointmentDTO getById(long id)
	{
		/*
		select app.*,u.Name followUserName,reg.Name regionName,com.Name communityName from t_houseappointments app
		left join T_AdminUsers u on app.FollowAdminUserId = u.Id
		left join T_Houses h on app.HouseId = h.Id
		left join T_Regions reg on h.RegionId = reg.Id
		left join T_Communities com on h.CommunityId = com.Id
		*/
		StringBuilder sb = new StringBuilder();
		sb.append("select app.*,u.Name followUserName,reg.Name regionName,com.Name communityName from t_houseappointments app\n");
		sb.append("left join T_AdminUsers u on app.FollowAdminUserId = u.Id\n");
		sb.append("left join T_Houses h on app.HouseId = h.Id\n");
		sb.append("left join T_Regions reg on h.RegionId = reg.Id\n");
		sb.append("left join T_Communities com on h.CommunityId = com.Id\n");
		sb.append("where app.Id = ?");
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery(sb.toString(), id);
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
		
		/*select count(*) from t_houseappointments app
		left join T_houses h on app.HouseId=h.Id
		left join T_Regions reg on h.RegionId=reg.Id
		left join T_Cities city on reg.CityId=city.Id
		where CityId=3 and Status='跟进中'
		*/
		
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) from t_houseappointments app\n");
		sb.append("left join T_houses h on app.HouseId=h.Id\n");
		sb.append("left join T_Regions reg on h.RegionId=reg.Id\n");
		sb.append("left join T_Cities city on reg.CityId=city.Id\n");
		sb.append("where CityId=? and Status=?\n");
		sb.append("\n");
		
		Number number;
		try {
			number = (Number)JDBCUtils.querySingle(sb.toString(), cityId,status);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return number.longValue();
	}
	
	//分页获取数据
	//currentIndex从1开始
	public HouseAppointmentDTO[] getPagedData(long cityId, String status, int pageSize, long currentIndex)//limit后面两个数不能用计算表达式，只能用固定的值，因此只能通过参数传递，计算在java中完成。
	{
		StringBuilder sb = new StringBuilder();
		sb.append("select app.*,u.Name followUserName,reg.Name regionName,com.Name communityName from t_houseappointments app\n");
		sb.append("left join T_AdminUsers u on app.FollowAdminUserId = u.Id\n");
		sb.append("left join T_Houses h on app.HouseId = h.Id\n");
		sb.append("left join T_Regions reg on h.RegionId = reg.Id\n");
		sb.append("left join T_Communities com on h.CommunityId = com.Id\n");
		sb.append("where reg.CityId = ? and app.Status = ?\n");
		sb.append("limit ?,?"); //limit 10,10 ————  从第10条数据开始 ，获取10条数据
		//sb.append("limit (?-1)*?,?"); //错误！   limit后面两个数不能用计算表达式，只能用固定的值，因此只能通过参数传递，计算在java中完成。
		
		List<HouseAppointmentDTO> list = new ArrayList<HouseAppointmentDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery(sb.toString(), cityId,status,(currentIndex-1)*pageSize,pageSize);
			while(rs.next())
			{
				list.add(toDTO(rs));
			}
			return list.toArray(new HouseAppointmentDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	private static HouseAppointmentDTO toDTO(ResultSet rs) throws SQLException
	{
		HouseAppointmentDTO dto = new HouseAppointmentDTO();
		dto.setCommunityName(rs.getString("CommunityName"));
		dto.setId(rs.getLong("Id"));
		dto.setUserId((long)rs.getObject("UserId")); //这个值可以为null，所以使用Object类型，再将其转成long类型
		dto.setName(rs.getString("Name"));
		dto.setPhoneNum(rs.getString("PhoneNum"));
		dto.setVisitDate(rs.getDate("VisitDate"));
		dto.setHouseId(rs.getLong("HouseId"));
		dto.setCreateDateTime(rs.getDate("CreateDateTime"));
		dto.setStatus(rs.getString("Status"));
		dto.setFollowAdminUserId((long)rs.getObject("FollowAdminUserId"));//这个值可以为null，所以使用Object类型，再将其转成long类型
		dto.setFollowDateTime(rs.getDate("FollowDateTime"));
		dto.setRegionName(rs.getString("RegionName"));
		dto.setFollowAdminUserName(rs.getString("FollowUserName"));
		return dto;
	}
}
