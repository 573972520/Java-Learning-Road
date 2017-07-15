package com.zsz.service;


import com.zsz.dao.utils.AttachmentDAO;
import com.zsz.dto.AttachmentDTO;

public class AttachmentService {
	
	AttachmentDAO dao = new AttachmentDAO();
	
	//获取所有的设施
	public AttachmentDTO[] getAll()
	{
		return dao.getAll();
	}

	//获取房子houseId有用的设施
	public AttachmentDTO[] getAttachments(long houseId)
	{
		return dao.getAttachments(houseId);
	}
	
	
}
