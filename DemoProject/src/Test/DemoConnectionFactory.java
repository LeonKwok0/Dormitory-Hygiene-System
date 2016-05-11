package Test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionFactory;

public class DemoConnectionFactory {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf=ConnectionFactory.getInstance();
		Connection conn=cf.makeConnection();
		System.out.println("数据库连接成功"+conn.getAutoCommit());		
	}
}
