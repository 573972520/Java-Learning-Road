package com.zsz.service;

import java.util.Date;


import com.zsz.dao.utils.HouseAppointmentDAO;
import com.zsz.dto.HouseAppointmentDTO;

public class HouseAppointmentService {
		
	HouseAppointmentDAO dao = new HouseAppointmentDAO();

	//新增一个预约：userId用户id（可以为null）；name姓名、phoneNum手机号、houseId房间id、visiteDate预约看房时间
	public long addnew(Long userId, String name, String phoneNum, long houseId, Date visitDate)
	{
		return dao.addnew(userId, name, phoneNum, houseId, visitDate);
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
		return dao.follow(adminUserId, houseAppointmentId);
		
	}

	//根据id获取预约
	public HouseAppointmentDTO getById(long id)
	{
		return dao.getById(id);
	}
	//得到cityId这个城市中状态为status的预约订单数
	public long getTotalCount(long cityId, String status)
	{
		
		return dao.getTotalCount(cityId, status);
	}
	
	//分页获取数据
	//currentIndex从1开始
	public HouseAppointmentDTO[] getPagedData(long cityId, String status, int pageSize, long currentIndex)//limit后面两个数不能用计算表达式，只能用固定的值，因此只能通过参数传递，计算在java中完成。
	{
		return dao.getPagedData(cityId, status, pageSize, currentIndex);		
	}
	
	
}
