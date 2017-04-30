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
		//csv导入数据库
		
		FileInputStream fis = null;
		InputStreamReader reader = null;
		BufferedReader buffReader = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try
		{
			fis = new FileInputStream("d:\\2014年7月份手机号码归属地数据库.csv");
			reader = new InputStreamReader(fis);
			buffReader = new BufferedReader(reader);
			
			buffReader.readLine(); //丢弃第一行——表头
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
				String phonePrefix = segments[1].replaceAll("\"", ""); //去掉双引号
				String area = segments[2].replaceAll("\"", "");
				String yys = segments[3].replaceAll("\"", "");
				//System.out.println("手机前缀"+phonePrefix+";"+area+yys);
				
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
			System.out.println("导入成功,耗时"+(endms-startms)); //导入成功,耗时59060
		}
		catch(IOException e)
		{
			JdbcUtils.rollback(conn);
			System.out.println("错误"+e);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			JdbcUtils.rollback(conn);
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeQuietly(conn);
			//正好和创建的顺序相反
			JdbcUtils.closeQuietly(buffReader);
			JdbcUtils.closeQuietly(reader);
			JdbcUtils.closeQuietly(fis);
		}
		*/
		
		System.out.println("请输入手机号");
		Scanner sc = new Scanner(System.in);
		String phoneNum = sc.nextLine();//读入手机号
		sc.close();
		
		String prefix = phoneNum.substring(0,7);
		System.out.println(prefix);
		ResultSet rs = null;
		try {
			rs = JdbcUtils.executeQuery("select * from T_PhonePos where PhonePrefix=?", prefix);
			if(!rs.next())
			{
				System.out.println("查不到");
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
