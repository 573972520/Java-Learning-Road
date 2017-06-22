package dataSourceDemo;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

    // 使用C3P0数据库连接池管理数据库连接
    private static DataSource dataSource = new ComboPooledDataSource();

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 关闭连接
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    // 关闭statement
    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
    }

    // 关闭结果集
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    // 关闭结果集、statement、连接
    public static void closeAll(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            close(rs);
            // 如果先关掉statement再关conn，会抛出“You cannot operate on a closed
            // Statement!”的异常，导致conn没有关闭
            close(rs.getStatement().getConnection());
            close(rs.getStatement());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 关闭结果集、statement
    public static void closeResultSetAndStatement(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            close(rs);
            close(rs.getStatement());
        } catch (SQLException e) {

        }
    }

    // 执行insert、update、delete等sql语句
    public static int executeUpdate(String sql, Object... parameters) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            return executeUpdate(conn, sql, parameters);
        } finally {
            close(conn);
        }
    }

    // 执行insert、update、delete等sql语句
    public static int executeUpdate(Connection conn, String sql, Object... parameters) throws 
	SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            return ps.executeUpdate();
        } finally {
            close(ps);
        }
    }

    // 执行查询
    public static ResultSet executeQuery(String sql, Object... parameters) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            return executeQuery(conn, sql, parameters);
        } catch (SQLException ex) {
            close(conn);
            throw ex;
        }
    }

    // 执行查询
    public static ResultSet executeQuery(Connection conn, String sql, Object... parameters) throws 
	SQLException {
        PreparedStatement ps = null;
        try {
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            close(ps);
            throw ex;
        }
    }

    // 回滚
    public static void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {

        }
    }
}
