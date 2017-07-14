package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsz.dto.AttachmentDTO;
import com.zsz.dto.SettingDTO;

public class AttachmentDAO {
	
	//获取所有的设施
	public AttachmentDTO[] getAll()
	{
		List<AttachmentDTO> list = new ArrayList<AttachmentDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_attachments where IsDeleted=0");
			while(rs.next())
			{
				AttachmentDTO dto = toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new AttachmentDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}

	//获取房子houseId有用的设施
	public AttachmentDTO[] getAttachments(long houseId)
	{
		List<AttachmentDTO> list = new ArrayList<AttachmentDTO>();
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery("select * from t_attachments where Id in(select AttachmentId from t_houseattachment where HouseId = ?)" , houseId);
			while(rs.next())
			{
				AttachmentDTO dto = toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new AttachmentDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally
		{
			JDBCUtils.closeAll(rs);
		}
	}
	
	
	private static AttachmentDTO toDTO(ResultSet rs) throws SQLException
	{
		AttachmentDTO dto = new AttachmentDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setIconName(rs.getString("IconName"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}
}
