package com.rupeng.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * �Խ�ʦ����ɾ�Ĳ���з�װ
 * @author Volcano
 *
 */
public class TeacherDAO {
	//�����Ĳ���һ�㲻Ҫ����5��
	//private void addnew(String name,String phoneNum) //���õ�д��
	
	
	/**
	 * ��������
	 * @param teacher
	 */
	private void addnew(TeacherInfo teacher)
	{
		try {
			JdbcUtils.executeUpdate("Insert into T_Teachers(Name,PhoneNum,BirthDay) values(?,?,?)", 
									teacher.getName(),teacher.getPhoneNum(),teacher.getBirthDay());
			
		} catch (SQLException e) {
			throw new RuntimeException();
			//��װ��RuntimeException��ҪΪ�˵����ߵķ���
		}
		
	}
	
	/**
	 * �������ݣ�Ҫ��ID�ֶ���ȷ���ģ������޸ģ�
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
	 * ɾ������ΪID����ʦ
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
	 * ��ID��Ӧ�����ݿ���Ϣ�������Ȼ����ܳ�TeacherInfo��ôһ���������ͨ��������󷵻�����
	 * 
	 * ��������Ϊ����IDֵ����ʦ
	 * @param id
	 * @return ��ʦ����
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
				return null; //һ�����ݶ�û�У�Ҳ����û���ҵ�id=id������
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
	 * ��ȡ��ǰ�е����ݣ�Ȼ���γ�һ�����󷵻�
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
	 * ���������ʦ����
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
