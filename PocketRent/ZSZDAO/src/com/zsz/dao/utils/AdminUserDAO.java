package com.zsz.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.zsz.dto.AdminUserDTO;
import com.zsz.dto.PermissionDTO;
import com.zsz.tools.CommonUtils;

public class AdminUserDAO {
	
	public static void main(String[] args) {
		
		//JUnit 简化单元测试案例的编写，简化断言，简化单元测试案例运行的这么一个框架
		
		/*
		boolean b1 = new AdminUserDAO().hasPermission(1, "AdminUser.Query");
		System.out.println(b1);
		
		boolean b2 = new AdminUserDAO().hasPermission(1, "AdminUser.aaa");
		System.out.println(b2);
		*/
		
		//Test Case : 测试案例 ———— 考虑所有具有典型性的可能的输入输出都考虑到，测试到， 检查输出的合法性
		//单元测试 Unit Test
		//回归测试 :检测是否由于修改A导致其他地方出问题
		boolean b1 = new AdminUserDAO().hasPermission(1, "AdminUser.Query");
		if(b1) //断言 Assert
		{
			System.out.println("OK");
		}
		else
		{
			System.err.println("ERROR");
		}
		
		boolean b2 = new AdminUserDAO().hasPermission(1, "AdminUser.aaa");
		if(b2)
		{
			System.err.println("ERROR");
		}
		else
		{
			System.out.println("OK");
		}
	}
	
	/*
	public final static String calcMD5(String s)
	{
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try
		{
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++)
			{
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public final static String calcMD5(InputStream inStream)
	{
		MessageDigest digest = null;
		byte buffer[] = new byte[1024];
		int len;
		try
		{
			digest = MessageDigest.getInstance("MD5");
			while ((len = inStream.read(buffer, 0, 1024)) != -1)
			{
				digest.update(buffer, 0, len);
			}
		} catch (NoSuchAlgorithmException | IOException e)
		{
			throw new RuntimeException(e);
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}
	
	*/
	
	//加入一个用户，name用户姓名，phoneNum手机号，password密码，email，cityId城市id（null表示总部）
	public long addAdminUser(String name,String phoneNum, String password, String email, Long cityId)
	{
		//用户传进来的密码是明文，所以需要计算散列值
		String passwordHash = CommonUtils.calcMD5(password);
		StringBuilder sb = new StringBuilder();
		sb.append("Insert into t_adminusers(Name,PhoneNum,PasswordHash,Email,CityId,LoginErrorTimes,LastLoginErrorDateTime,IsDeleted,CreateDateTime)\n");
		sb.append("values(?,?,?,?,?,0,null,0,now())");
		try {
			return JDBCUtils.executeInsert(sb.toString(), name,phoneNum,passwordHash,email,cityId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	//修改用户的信息
	public void updateAdminUser(long id,String name, String password, String email, Long cityId)
	{
		//用户传进来的密码是明文，所以需要计算散列值
		String passwordHash = CommonUtils.calcMD5(password);
		StringBuilder sb = new StringBuilder();
		sb.append("update t_adminusers set Name=?,PasswordHash=?,Email=?,CityId=?\n");
		sb.append("where Id=?");
		try {
			JDBCUtils.executeNonQuery(sb.toString(), name,password,email,cityId,id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//获取cityId这个城市下的管理员
	public AdminUserDTO[] getAll(long cityId)
	{
		List<AdminUserDTO> list = new ArrayList<AdminUserDTO>();
		//SQL注入漏洞（不会有这BUG）
		StringBuilder sb = new StringBuilder();
		sb.append("select u.*,c.Name cityName from t_adminusers u\n");
		sb.append("left join t_cities c on u.CityId=c.Id where u.IsDeleted=0 and u.CityId=?\n");
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery(sb.toString(),cityId);
			while(rs.next())
			{
				AdminUserDTO dto = toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new AdminUserDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
		StringBuilder sb = new StringBuilder();
		sb.append("select u.*,c.Name cityName from t_adminusers u\n");
		sb.append("left join t_cities c on u.CityId=c.Id where u.IsDeleted=0\n");
		ResultSet rs = null;
		try {
			rs = JDBCUtils.executeQuery(sb.toString());
			while(rs.next())
			{
				AdminUserDTO dto = toDTO(rs);
				list.add(dto);
			}
			return list.toArray(new AdminUserDTO[list.size()]);
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
			rs = JDBCUtils.executeQuery("select u.*,c.Name cityName from t_adminusers u left join t_cities c on u.cityId=c.Id where u.Id=? and u.IsDeleted=0", id);
			//SQL 语句中的 cityName 是c.Name别名
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
			rs = JDBCUtils.executeQuery("select u.*,c.Name cityName from t_adminusers u left join t_cities c on u.cityId=c.Id where u.PhoneNum=? and u.IsDeleted=0", phoneNum);
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
		AdminUserDTO user = getByPhoneNum(phoneNum);
		if(user == null) // 手机号错误
		{
			return false;
		}
		String passwordHash = CommonUtils.calcMD5(password);
		if(user.getPasswordHash().equals(passwordHash))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//软删除
	public void markDeleted(long adminUserId)
	{
		try {
			JDBCUtils.executeNonQuery("Update t_adminusers set IsDeleted=1 where Id=?", adminUserId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//判断adminUserId这个用户是否有permissionName这个权限项（举个例子）
	/**
	 * 判断用户是否有某个权限 比如：hasPermission(3,"AdminUser.AddNew")
	 * @param adminUserId
	 * @param permissionName
	 * @return
	 */
	public boolean hasPermission(long adminUserId, String permissionName)
	{
		//先获得用户拥有的角色，再获得这些角色拥有的权限 ，然后判断permissionName这个权限是否在这些权限范围内
		/*
		select Count(*) from t_permissions where Id in 
		(
			select PermissionId from t_rolepermissions where RoleId in
			(			
				select RoleId from t_adminuserroles where AdminUserId = 1
			)
		)
		and Name = 'AdminUser.Query'
		*/
		
		StringBuilder sb = new StringBuilder();
		sb.append("select Count(*) from t_permissions where Id in\n");
		sb.append("(\n");
		sb.append("	select PermissionId from t_rolepermissions where RoleId in\n");
		sb.append("	(\n");
		sb.append("		select RoleId from t_adminuserroles where AdminUserId = ?\n");
		sb.append("	)\n");
		sb.append(")\n");
		sb.append("and Name = ?\n");
		
		//因为无论Integer还是Long、Double都继承自Number,这样避免了返回值是Integer还是Long的问题
		try {
			Number number = (Number)JDBCUtils.querySingle(sb.toString(), adminUserId,permissionName);
			return number.intValue() > 0; //如果查询的条数不是0，则说明有这个权限
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static AdminUserDTO toDTO(ResultSet rs) throws SQLException
	{
		AdminUserDTO dto = new AdminUserDTO();
		dto.setId(rs.getLong("Id"));
		dto.setName(rs.getString("Name"));
		dto.setPhoneNum(rs.getString("PhoneNum"));
		dto.setPasswordHash(rs.getString("PasswordHash"));
		dto.setEmail(rs.getString("Email"));
		dto.setCityId((Long)rs.getObject("CityId"));
		dto.setCityName(rs.getString("cityName"));
		dto.setLoginErrorTimes(rs.getInt("LoginErrorTimes"));
		dto.setLastloginErrorDateTime(rs.getDate("LastloginErrorDateTime"));
		dto.setCreateDateTime(rs.getDate("CreateDateTime"));
		dto.setDeleted(rs.getBoolean("IsDeleted"));
		return dto;
	}
}
