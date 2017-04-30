import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest6_���ȡ�����ݿ��е�null {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("��������ʧ��"+e.getMessage());
			return;
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncode=UTF-8","root","root");
			ps = conn.prepareStatement("select * from T_Persons");
			resultSet = ps.executeQuery();
			while(resultSet.next())//�α꣨��ȥ���ݿ�������������һ������
			{
				/*
				String s = resultSet.getString("name");
				int age = resultSet.getInt("Age");	 //��Ϊint����Ϊnull,����ֻ�ܷ���һ��Ĭ��ֵ0
				boolean gender = resultSet.getBoolean("gender");//��Ϊboolean����Ϊnull,����ֻ�ܷ���һ��Ĭ��ֵ0
				System.out.println("������"+s+"  "+"���䣺"+age+"  "+"�Ա�"+(gender?"man":"woman"));
				*/
				String name = resultSet.getString("Name");
				System.out.println("�����ǣ�"+(name==null?"��֪��":name));
				
				Integer iAge = (Integer)resultSet.getObject("Age");
				if(iAge == null)
				{
					System.out.println("����Ϊ����֪��");
				}
				else
				{
					int age = iAge;//��ʽ����ת�� (����)
					System.out.println("����Ϊ��"+iAge);
				}
				Boolean bGender = (Boolean)resultSet.getObject("Gender");
				if(bGender == null)
				{
					System.out.println("�Ա�֪��");
				}
				else
				{
					boolean Gender = bGender;
					System.out.println(Gender?"man":"woman");
				}
				
			}
		} catch (SQLException e) {
			System.err.println("���ݿ����ʧ��"+e.getMessage());
		}
		finally
		{
			JdbcUtils.closeQuietly(resultSet);
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
