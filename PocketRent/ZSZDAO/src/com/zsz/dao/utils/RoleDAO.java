package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.RoleDTO;

public class RoleDAO {
	public long addnew(String roleName)//新增角色
	{
		try {
			return JDBCUtils.executeInsert("Insert into t_roles(Name,IsDeleted) values(?,0)", roleName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void update(long roleId,String roleName)//编辑
	{
		try {
			JDBCUtils.executeNonQuery("update t_roles set Id=? , Name=?", roleId,roleName);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void markDeleted(long roleId)//软删除角色
	{
		
	}
	public RoleDTO getById(long id)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_roles where Id=? and IsDeleted=0",id);
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
	public RoleDTO[] getAll()
	{
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_roles");
			while(rs.next())
			{
				list.add(toDTO(rs));
			}
			return list.toArray(new RoleDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	
/*	public void addRoleIds(long adminUserId, long[] roleIds)//给用户adminuserId增加权限roleIds
	{
		
	}
	
	public void updateRoleIds(long adminUserId, long[] roleIds)//更新权限，先删再加
	{
		
	}
	
	public RoleDTO[] getByAdminUserId(long adminUserId)//获取用户的角色
	{
		
	}

	*/
	private static RoleDTO toDTO(ResultSet rs) throws SQLException
	{
		RoleDTO dto = new RoleDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}

}
