import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest9_JDBC�����ύaddBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Connection conn = null;
		PreparedStatement ps = null;
		long startms = System.currentTimeMillis();
		try
		{
			conn = JdbcUtils.createConnection();
			ps = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values(?,?,?)");
			for(int i=0;i<1000;i++)
			{
				ps.clearParameters();//Statement�ظ�ʹ�ã����ϴ����õĲ�ѯ������ֵ�����
				ps.setString(1, "Tom"+i);
				ps.setInt(2, i);
				ps.setBoolean(3, true);
				ps.executeUpdate();
			}
			long endms = System.currentTimeMillis();
			System.out.println("��ʱΪ��"+(endms-startms)); //��ʱΪ��50168
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
		*/
		Connection conn = null;
		PreparedStatement ps = null;
		long startms = System.currentTimeMillis();
		try
		{
			conn = JdbcUtils.createConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into T_Persons(Name,Age,Gender) values(?,?,?)");
			for(int i=0;i<1000;i++)
			{
				ps.clearParameters();//Statement�ظ�ʹ�ã����ϴ����õĲ�ѯ������ֵ�����
				ps.setString(1, "Tom"+i);
				ps.setInt(2, i);
				ps.setBoolean(3, true);
				//ps.executeUpdate();//ÿһ�ζ�֪ͨ��������һ����¼�����������ܲ�
				ps.addBatch(); //���ύ���ݵ�����װ��������
				if(i%1000 == 0) //ÿװ��1000������ύһ��
				{
					ps.executeBatch(); 
				}
			}
			//��ʣ��ģ�û����1000��������ύһ��
			ps.executeBatch(); //�������������һ���ύ��mysql
			conn.commit();
			long endms = System.currentTimeMillis();
			System.out.println("��ʱΪ��"+(endms-startms)); //��ʱΪ��1285
		}
		catch(SQLException e)
		{
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("�ع�ʧ��");
			}
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(ps);
			JdbcUtils.closeQuietly(conn);
		}
	}

}
