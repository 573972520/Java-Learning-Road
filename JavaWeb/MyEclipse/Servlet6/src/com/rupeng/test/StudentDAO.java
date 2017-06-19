package com.rupeng.test;

import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

	public void addnew(StudentInfo student)
	{
		try {
			JdbcUtils.executeUpdate("Insert into T_Students(Name,Gender,BirthDay,ClassId,TeChangSheng,MinZuId) values(?,?,?,?,?,?)",
					student.getName(),student.isGender(),student.getBirthDay(),student.getClassId(),student.isTeChangSheng(),student.getMinZuId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void update(StudentInfo student)
	{
		try {
			JdbcUtils.executeUpdate("Update T_Students set Name=?,Gender=?,BirthDay=?,ClassId=?,TeChangSheng=?,MinZuId=? where Id=?", 
					student.getName(),student.isGender(),student.getBirthDay(),student.getClassId(),student.isTeChangSheng(),student.getMinZuId(),student.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void delete(int id)
	{
		try {
			JdbcUtils.executeUpdate("delete from T_Students where Id=? ", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public StudentInfo toModel(ResultSet rs) throws SQLException
	{
		StudentInfo info = new StudentInfo();
		info.setId(rs.getInt("Id"));
		info.setName(rs.getString("Name"));
		info.setGender(rs.getBoolean("Gender"));
		info.setBirthDay(rs.getDate("BirthDay"));
		info.setClassId(rs.getInt("ClassId"));
		info.setTeChangSheng(rs.getBoolean("TeChangSheng"));
		info.setMinZuId(rs.getInt("MinZuId"));
		return info;
	}
	
	public StudentInfo getById(int id)
	{
		ResultSet rs = null;
		try
		{
			rs = JdbcUtils.executeQuery("select * from T_Students where Id=?", id);
			if(rs.next())
			{
				return toModel(rs);
			}
			else
			{
				return null;
			}
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}
	
	public List<StudentInfo> getAll()
	{
		ResultSet rs = null;
		try
		{

			rs = JdbcUtils.executeQuery("select * from T_Students");
			List<StudentInfo> list = new LinkedList<StudentInfo>();
			while(rs.next())
			{
				list.add(toModel(rs));
			}
			return list;
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}
}
