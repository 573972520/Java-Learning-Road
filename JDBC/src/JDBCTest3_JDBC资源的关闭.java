import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest3_JDBC��Դ�Ĺر� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//������JDBC����
			System.out.println("����JDBC�����ɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql��JDBC��������ʧ��"+e.getMessage());
			return; //��������ˣ���ô�����û�б�Ҫ����ִ���ˣ�����ʹ��return�����ó���������ִ�С���
		}
		
		Connection conn = null; //�������ݿ�֮��һ���ǵ���Ҫ�رգ����Է�������
		PreparedStatement stmt = null; //׼��ִ�����֮��һ���ǵ���Ҫ�رգ����Է�������
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncoding=UTF-8","root","root");
			//prepareStatement:׼��ִ��,����PreparedStatement����
			stmt = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values('carl',20,0)");
			int i = stmt.executeUpdate();//ִ��
			System.out.println("ִ�гɹ���Ӱ����"+i+"������");
		} catch (SQLException e) {
			System.out.println("��������ʧ��"+e.getMessage());
		}
		finally
		{
			/*
			if(stmt != null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					// do nothing 
				}
			}
			
			if(conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// do nothing 
				}
			}
			*/
			JdbcUtils.closeQuietly(stmt);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
