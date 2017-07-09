package com.zsz.dao.utils;

import java.sql.SQLException;
import java.util.Date;

public class AdminLogDAO {
	
	//插入一条日志：adminUserId为操作用户id，message为消息
	public void addnew(long adminUserId,String message)
	{
		try {
			JDBCUtils.executeInsert("Insert into t_adminlogs(AdminUserId,CreateDateTime,Message) values(?,new(),?) ",adminUserId,message);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}