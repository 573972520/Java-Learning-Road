import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCTest1_������JDBC�������������ݿ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");//������JDBC����
			System.out.println("����JDBC�����ɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql��JDBC��������ʧ��"+e.getMessage());
			return; //��������ˣ���ô�����û�б�Ҫ����ִ���ˣ�����ʹ��return�����ó���������ִ�С���
		}
		
		try {
			DriverManager.getConnection("jdbc:mysql://localhost/study1?seUnicode=true&characterEncoding=UTF-8","root","root");
			System.out.println("����mysql�ɹ�");
		} catch (SQLException e) {
			System.out.println("����mysqlʧ��"+e.getMessage());
		}
		
	}

}
