package com.zsz.service;

import java.sql.SQLException;
import java.util.Date;

import com.zsz.dao.utils.AdminLogDAO;

public class AdminLogService {
	
	private AdminLogDAO dao = new AdminLogDAO();
	
	//插入一条日志：adminUserId为操作用户id，message为消息
	public void addnew(long adminUserId,String message)
	{
		dao.addnew(adminUserId, message);
	}
}