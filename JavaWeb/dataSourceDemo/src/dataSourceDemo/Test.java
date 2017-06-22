package dataSourceDemo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {
	public static void main(String[] args) throws SQLException {
		
		/*//创建了一个数据库连接池对象
		DataSource dataSource = new ComboPooledDataSource();
		
		//ֱ直接向连接池对象获取连接
		Connection conn = dataSource.getConnection();
		
		
		//做需要做的事情
		System.out.println(conn);
		
		//归还连接给连接池
		conn.close();
		*/
		
		//ֱ直接向连接池对象获取连接
		Connection conn = JDBCUtils.getConnection();
		
		//做需要做的事情
		System.out.println(conn);
		
		//归还连接给连接池
		conn.close();
		
		
	}
}
