package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.AdminUserDTO;
import com.zsz.dto.PermissionDTO;

public class AdminUserDAO {
	//加入一个用户，name用户姓名，phoneNum手机号，password密码，email，cityId城市id（null表示总部）
	public long addAdminUser(String name,String phoneNum, String password, String email, Long cityId)
	{
		try {
			return JDBCUtils.executeInsert("Insert into t_adminusers(Name,PhoneNum,Password,Email,CityId,IsDeleted)", name,phoneNum,password,email,cityId);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	//获取cityId这个城市下的管理员
	public AdminUserDTO[] getAll(long cityId)
	{
		List<AdminUserDTO> list = new ArrayList<AdminUserDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_adminusers where IsDeleted=0 and CityId=?",cityId);
			while(rs.next())
			{
				AdminUserDTO dto = toDTO(rs);
			}
			return list.toArray(new AdminUserDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	//获取所有管理员
	public AdminUserDTO[] getAll()
	{
		List<AdminUserDTO> list = new ArrayList<AdminUserDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_adminusers where IsDeleted=0");
			while(rs.next())
			{
				AdminUserDTO dto = toDTO(rs);
			}
			return list.toArray(new AdminUserDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	//根据id获取DTO
	public AdminUserDTO getById(long id)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_adminusers where Id=? and IsDeleted=0", id);
			if(rs.next())
			{
				return toDTO(rs);
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	//根据手机号获取DTO
	public AdminUserDTO getByPhoneNum(String phoneNum)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_adminusers where PhoneNum=? and IsDeleted=0", phoneNum);
			if(rs.next())
			{
				return toDTO(rs);
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	//检查用户名密码是否正确
	public boolean checkLogin(String phoneNum,String password)
	{
		
	}
	//软删除
	public void markDeleted(long adminUserId)
	{
		
	}
	//判断adminUserId这个用户是否有permissionName这个权限项（举个例子）
	public boolean hasPermission(long adminUserId, String permissionName)
	{
		
	}
	
	private static AdminUserDTO toDTO(ResultSet rs) throws SQLException
	{
		AdminUserDTO dto = new AdminUserDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setPhoneNum(rs.getString("PhoneNum"));
		dto.setPasswordHash(rs.getString("PasswordHash"));
		dto.setEmail(rs.getString("Email"));
		dto.setCityId(rs.getLong("CityId"));
		dto.setLoginErrorTimes(rs.getInt("LoginErrorTimes"));
		dto.setLastloginErrorDateTime(rs.getDate("LastloginErrorDateTime"));
		dto.setCreateDateTime(rs.getDate("CreateDateTime"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}
}
