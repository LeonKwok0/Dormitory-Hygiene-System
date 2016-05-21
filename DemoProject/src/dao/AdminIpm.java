package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import entity.Dormitory;
import entity.User;

public class AdminIpm {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	
	public void updatePassword(Connection conn, User user) throws SQLException {
		String sql = "UPDATE admin SET password=? WHERE name=?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(2, user.getName());
		ps.setString(1, user.getPassword());
		ps.execute();
		ps.close();
	}

	// add new member
	public void saveNewAdmin(Connection conn, User user) throws SQLException {
		String sql = "insert into admin(name,password) values(?,?)";
   //	conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.execute();
		ps.close();
	}
	
	public boolean checkAdmin(Connection conn,User user) {
		String sql="SELECT * FROM  admin WHERE name=? AND password=?";
		boolean login = false;
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1,user.getName());
			ps.setString(2,user.getPassword());
		    rs=ps.executeQuery();
		    login = rs.next();
		    ps.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
//	public void Query(String sql) {
//		try {
//			conn = ConnectionFactory.getInstance().makeConnection();
//			// 建立数据库连接
//			st = conn.createStatement();
//			// 获取statement实例
//			rs = st.executeQuery(sql);
//			// 获取结果集
//			getResultset(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	public void getResultset(ResultSet rs) throws SQLException {
//		// 返回是否有第一条记录
//		boolean record = rs.next();
//		if (!record) {
//			System.out.println("表中无值 Empaty table");
//			return;
//		}
//
//	}

	public boolean idExists(Connection conn,User user) throws SQLException {
		String sql = "SELECT * FROM  Dormitory WHERE dorId=?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, user.getName());
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		boolean option=rs.next();
		
		rs.close();
		ps.close();
		return option;
	}

}
