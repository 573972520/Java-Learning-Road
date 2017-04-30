import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest8_JDBC����Transaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try
		{
			//Ҫ��ͬһ��������
			conn = JdbcUtils.createConnection();
			conn.setAutoCommit(false); // Ĭ���ύ��Ϊfalse
			JdbcUtils.executeUpdate(conn,"Update T_Accounts set Amount=Amount-1000 where Number='0001'");
			//ģ���1000Ԫ֮�������쳣�����¼�1000û�гɹ�
			String s = null;
			System.out.print(s.length());
			JdbcUtils.executeUpdate(conn,"Update T_Accounts set Amount=Amount+1000 where Number='0002'");
			conn.commit();//�ύ����
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			try {
				conn.rollback(); //�ع����� ���� �ֵ��ǣ��ղŵ��޸Ķ������������˻�ȥ
			} catch (SQLException e1) {
				System.out.println("�ع�ʧ��");
			}
		}
		finally
		{
			JdbcUtils.closeQuietly(conn);
		}
	}

}
