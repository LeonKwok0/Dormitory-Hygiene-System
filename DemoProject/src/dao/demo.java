package dao;

import java.sql.Connection;
import java.sql.SQLException;

import entity.User;

public class demo {

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		AdminIpm ipm = new AdminIpm();
		User user = new User();
		user.setName("admin1");
		user.setPassword("admin09876");
		try {
			if (ipm.checkAdmin(conn, user)) {
				user.setPassword("123");
				ipm.updatePassword(conn, user);
				conn.close();
			} else {
				System.out.println("wrong password");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
