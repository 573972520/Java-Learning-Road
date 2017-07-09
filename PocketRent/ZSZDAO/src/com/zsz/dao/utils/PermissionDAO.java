package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import com.zsz.dto.CommunityDTO;
import com.zsz.dto.PermissionDTO;

public class PermissionDAO {
	public PermissionDTO getById(long id)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_permissions where Id=? and IsDeleted=0", id);
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
	public PermissionDTO[] getAll()
	{
		List<PermissionDTO> list = new ArrayList<PermissionDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_permissions where IsDeleted=0");
			while(rs.next())
			{
				list.add(toDTO(rs));
			}
			return list.toArray(new PermissionDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	public PermissionDTO getByName(String name)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_permissions where Name=? and IsDeleted=0", name);
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

	//获取角色的权限
	public PermissionDTO[] getByRoleId(long roleId)
	{
		List<PermissionDTO> list = new ArrayList<PermissionDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_permissions where Id in(select PermissionId from t_rolepermissions where RoleId=?)",roleId);
			while(rs.next())
			{
				list.add(toDTO(rs));
			}
			return list.toArray(new PermissionDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}

	//给角色roleId增加权限项id permIds
	public void addPermIds(long roleId, long[] permIds)
	{
		for(long permId : permIds)
		{
			try {
				JDBCUtils.executeNonQuery("Insert into t_rolepermissions(RoleId,PermissionId) values(?,?)", roleId,permId);
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	//更新角色role的权限项：先删除再添加
	public void updatePermIds(long roleId, long[] permIds)
	{
		try {
			JDBCUtils.executeNonQuery("delete from t_rolepermissions where RoleId=?", roleId);//先删除
			addPermIds(roleId, permIds); //再添加
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static PermissionDTO toDTO(ResultSet rs) throws SQLException
	{
		PermissionDTO dto = new PermissionDTO();
		dto.setId(rs.getLong("Id"));
		dto.setDescription(rs.getString("Description"));
		dto.setName(rs.getString("Name"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}

}
