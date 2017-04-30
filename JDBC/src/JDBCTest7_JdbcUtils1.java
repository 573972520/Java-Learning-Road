import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTest7_JdbcUtils1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		try {
			JdbcUtils.executeUpdate("Insert into T_Persons(Name,Age,Gender) values(?,?,?)",
					"360",45,false);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		
		long startms = System.currentTimeMillis();
		Connection conn = null;
		try {
			conn = JdbcUtils.createConnection();
			for(int i =0;i<100;i++)
			{
				JdbcUtils.executeUpdate(conn,"Insert into T_Persons(Name,Age,Gender) values(?,?,?)",
						"360",45,false);
			}
			long endms = System.currentTimeMillis();
			System.out.println("ִ�к�ʱ"+(endms-startms)); //10��SQL��ʱ��1083    100��SQL��ʱ3991
		} catch (SQLException e) {
			System.err.println(e);
		}
		finally
		{
			JdbcUtils.closeQuietly(conn);
		}
		*/
		
		long startms = System.currentTimeMillis();
		try {
			for(int i =0;i<100;i++)
			{
				JdbcUtils.executeUpdate("Insert into T_Persons(Name,Age,Gender) values(?,?,?)",
						"360",45,false);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		long endms = System.currentTimeMillis();
		System.out.println("ִ�к�ʱ"+(endms-startms)); //10��SQL��ʱ��1448   100��SQL��ʱ6426  �����ʱ������Ϊ����ִ��ʱ��һֱ���ظ�ִ����SQL������"���ӡ����Ͽ�����"��һ����
		
	}

}
