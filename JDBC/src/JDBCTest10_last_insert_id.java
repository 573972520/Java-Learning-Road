import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest10_last_insert_id {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Connection conn = null;
		try
		{
			//����ͬһ��������
			conn = JdbcUtils.createConnection();
			
			/*
			JdbcUtils.executeUpdate("insert into T_Persons2(Name,Age) values(?,?)", "cc",2);
			//����Ĵ��������Ĵ�����в������� ,�����û�ͬʱ�����������Ĳ�����ʹ�����maxid���ִ���
			rs = JdbcUtils.executeQuery("select max(id) maxid from T_Persons2");
			*/
			
			JdbcUtils.executeUpdate(conn,"insert into T_Persons2(Name,Age) values(?,?)", "cc",2);
			//last_insert_id() ��õ�ǰ���������һ���������Զ������ֶε�ֵ
			rs = JdbcUtils.executeQuery(conn, "select last_insert_id() maxid");
			rs.next();
			long id = rs.getLong("maxid");
			System.out.println(id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeAll(rs);
		}
	}

}
