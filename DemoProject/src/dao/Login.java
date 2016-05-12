package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.User;

public class Login {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private boolean login=false;
	public boolean check(User user, int kind) {
		// judge what kind of user student or admin 
		if(kind==0){
			sql="SELECT * FROM  admin WHERE name=? AND password=?";
		}else if(kind==1){
			sql="SELECT * FROM  student WHERE name=? AND password=?";
		}
		
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
}
