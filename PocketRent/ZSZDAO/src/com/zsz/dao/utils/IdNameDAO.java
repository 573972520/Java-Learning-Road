package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.IdNameDTO;

public class IdNameDAO {
	
	public long addIdName(String typeName,String name)
	{
		try {
			return JDBCUtils.executeInsert("Insert into t_idname(TypeName,Name,IsDeleted) values(?,?,0)", typeName,name);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static IdNameDTO toDTO(ResultSet rs) throws SQLException
	{
		IdNameDTO dto = new IdNameDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setTypeName(rs.getString("TypeName"));
		return dto;
	}
	
	public IdNameDTO getById(long id,String typeName)
	{
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_idnames where TypeName=? and IsDeleted=0",typeName);
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
	
	//获取类别下的IdName(比如所有的民族)
	public IdNameDTO[] getAll(String typeName)
	{
		List<IdNameDTO> list = new ArrayList<IdNameDTO>();
		ResultSet rs = null;
		try
		{
			rs = JDBCUtils.executeQuery("select * from t_idnames where IsDeleted=0");
			while(rs.next())
			{
				IdNameDTO dto = toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new IdNameDTO[list.size()]);
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
}
