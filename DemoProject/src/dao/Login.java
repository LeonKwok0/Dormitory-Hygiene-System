package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Dormitory;
import entity.User;

public class Login {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private boolean login=false;
	public boolean checkAdmin(User user) {
		sql="SELECT * FROM  admin WHERE name=? AND password=?";
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1,user.getName());
			ps.setString(2,user.getPassword());
		    rs=ps.executeQuery();
		    login = rs.next();
		    ps.close();
		    rs.close();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
	
	public boolean checkStudent(Dormitory dor) {
	   sql="SELECT * FROM  Dormitory  WHERE dorId=? AND password=?";
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1,dor.getName());
			ps.setString(2,dor.getPassword());
		    rs=ps.executeQuery();
		    login = rs.next();
		    ps.close();
		    rs.close();
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return login;
	}
	
	
	public void checkInput(){
		
	}
	
	
}
