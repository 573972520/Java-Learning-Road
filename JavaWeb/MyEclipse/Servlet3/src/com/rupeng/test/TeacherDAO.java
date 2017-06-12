package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * 对教师的增删改查进行封装
 * @author Volcano
 *
 */
public class TeacherDAO {
	//方法的参数一般不要超过5个
	//private void addnew(String name,String phoneNum) //不好的写法
	
	
	/**
	 * 新增数据
	 * @param teacher
	 */
	private void addnew(TeacherInfo teacher)
	{
		try {
			JdbcUtils.executeUpdate("Insert into T_Teachers(Name,PhoneNum,BirthDay) values(?,?,?)", 
									teacher.getName(),teacher.getPhoneNum(),teacher.getBirthDay());
			
		} catch (SQLException e) {
			throw new RuntimeException();
			//封装成RuntimeException主要为了调用者的方便
		}
		
	}
	
	/**
	 * 更新数据（要求ID字段是确定的，不被修改）
	 * @param teacher
	 */
	public void update(TeacherInfo teacher)
	{
		try {
			JdbcUtils.executeUpdate("update T_Teachers set Name=?,PhoneNum=?,BirthDay=? where Id=?", 
					teacher.getName(),teacher.getPhoneNum(),teacher.getBirthDay(),teacher.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	
	/**
	 * 删除主键为ID的老师
	 * @param id
	 */
	public void delete(int id)
	{
		try {
			JdbcUtils.executeUpdate("delete from T_Teachers where Id=?", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
	/**
	 * 将ID对应的数据库信息查出来，然后汇总成TeacherInfo这么一个对象，最后通过这个对象返回数据
	 * 
	 * 查找主键为参数ID值的老师
	 * @param id
	 * @return 老师对象
	 */
	public  TeacherInfo getById (int id)
	{
		ResultSet rs = null;
		try {
			rs = JdbcUtils.executeQuery("select * from T_Teachers where Id=?", id);
			if(rs.next())
			{
				TeacherInfo info = new TeacherInfo();
				info.setId(rs.getInt("Id"));
				info.setName(rs.getString("Name"));
				info.setBirthDay(rs.getDate("BirthDay"));
				info.setPhoneNum(rs.getString("PhoneNum"));
				return info;
			}
			else
			{
				return null; //一条数据都没有，也就是没有找到id=id的数据
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		finally{
			JdbcUtils.closeAll(rs);
		}
	}
	

	/**
	 * 读取当前行的数据，然后形成一个对象返回
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private TeacherInfo toModel(ResultSet rs) throws SQLException
	{
		/*TeacherInfo info = new TeacherInfo();
		info.setId(rs.getInt("Id"));
		info.setName(rs.getString("Name"));
		info.setBirthDay(rs.getDate("BirthDay"));
		info.setPhoneNum(rs.getString("PhoneNum"));
		return info;*/
		
		return toModel(rs);
	}
	
	/**
	 * 获得所有老师对象
	 * @return
	 */
	public List<TeacherInfo> getAll()
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from T_Teachers");
			List<TeacherInfo> list = new LinkedList<TeacherInfo>();
			while(rs.next())
			{
				/*TeacherInfo info = new TeacherInfo();
				info.setId(rs.getInt("Id"));
				info.setName(rs.getString("Name"));
				info.setBirthDay(rs.getDate("BirthDay"));
				info.setPhoneNum(rs.getString("PhoneNum"));*/
				list.add(toModel(rs));
			}
			return list;
		}
		catch(SQLException e)
		{
			throw new RuntimeException();
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}
	
}
