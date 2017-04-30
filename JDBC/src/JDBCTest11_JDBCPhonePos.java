import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest11_JDBCPhonePos {

	public static void main(String[] args) {
		
		/*
		//csv�������ݿ�
		
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffReader = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			fis = new FileInputStream("d:\\2014��7�·��ֻ�������������ݿ�.csv");
			reader = new InputStreamReader(fis);
			buffReader = new BufferedReader(reader);
			
			buffReader.readLine(); //������һ�С�����ͷ
			conn = JdbcUtils.createConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into T_PhonePos(PhonePrefix,Area,MobileType) values(?,?,?)");
			
			long startms = System.currentTimeMillis();
			String line;
			int count = 0;
			while((line=buffReader.readLine()) != null)
			{
				//System.out.println(line);
				String[] segments = line.split(",");
				String phonePrefix = segments[1].replaceAll("\"", ""); //ȥ��˫����
				String area = segments[2].replaceAll("\"", "");
				String yys = segments[3].replaceAll("\"", "");
				//System.out.println("�ֻ�ǰ׺"+phonePrefix+";"+area+yys);
				
				ps.clearParameters();
				ps.setString(1, phonePrefix);
				ps.setString(2, area);
				ps.setString(3, yys);
				ps.addBatch();
				count++;
				if(count%2000 ==0)
				{
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			conn.commit();
			long endms = System.currentTimeMillis();
			System.out.println("����ɹ�,��ʱ"+(endms-startms)); //����ɹ�,��ʱ59060
		}
		catch(IOException e)
		{
			JdbcUtils.rollback(conn);
			System.out.println("����"+e);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			JdbcUtils.rollback(conn);
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(conn);
			//���úʹ�����˳���෴
			JdbcUtils.closeQuietly(buffReader);
			JdbcUtils.closeQuietly(reader);
			JdbcUtils.closeQuietly(fis);
		}
		*/
		
		System.out.println("�������ֻ���");
		Scanner sc = new Scanner(System.in);
		String phoneNum = sc.nextLine();//�����ֻ���
		sc.close();
		
		String prefix = phoneNum.substring(0,7);
		System.out.println(prefix);
		ResultSet rs = null;
		try {
			rs = JdbcUtils.executeQuery("select * from T_PhonePos where PhonePrefix=?", prefix);
			if(!rs.next())
			{
				System.out.println("�鲻��");
				return;
			}
			String area = rs.getString("Area");
			String mobileType = rs.getString("MobileType");
			System.out.println(area+mobileType);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(rs);
		}
	}

}
