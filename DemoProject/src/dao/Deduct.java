package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import entity.Dormitory;
import entity.User;
import gui.Error;

public class Deduct {
	Connection conn;

	private int currentPoints;

	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	boolean record;

	/**
	 * check dormitory id if exisits
	 * 
	 * @param dormitory
	 * @return
	 * @throws SQLException
	 */
	public boolean idExists(Dormitory dormitory) throws SQLException {
		conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "SELECT * FROM  Dormitory WHERE dorId=?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, dormitory.getDorId());
		ResultSet rs2 = ps.executeQuery();
		record = rs2.next();
		return record;
	}

	public void update(Dormitory dormitory) throws SQLException {
		// 向 表deduction_record 中添加记录 （这里是扣分记录）

		conn = ConnectionFactory.getInstance().makeConnection();

		String sql = "insert into deduction_record(time,reason,points,dorId) values(?,?,?,?);";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, dormitory.getTime());
		ps.setString(2, dormitory.getReasons());
		ps.setInt(3, dormitory.getDeductPoints());
		ps.setString(4, dormitory.getDorId());
		ps.execute();

		// 向 表Dormitory 修改记录 总分减去相应的值
		String sql2 = "UPDATE Dormitory SET points=(points-?) WHERE dorId=?";
		PreparedStatement ps2 = conn.prepareCall(sql2);
		ps2.setInt(1, dormitory.getDeductPoints());
		ps2.setString(2, dormitory.getDorId());
		ps2.execute();

		ps.close();
		ps2.close();

	}

	public void checkCurrentPoints(Dormitory dormitory) throws SQLException {
		conn = ConnectionFactory.getInstance().makeConnection();
		String sql3 = "SELECT points FROM  Dormitory WHERE dorId=?";
		PreparedStatement ps3 = conn.prepareCall(sql3);
		ps3.setString(1, dormitory.getDorId());
		ResultSet rs = ps3.executeQuery();
		record = rs.next();
		if (!record) {
			System.out.println("Error: no this Dor id");
		} else {
			this.currentPoints = rs.getInt("points");
		}
		conn.close();
	}

	/**
	 * this very bad design of dao class write same code for 2 times just
	 * because this is my frist time to do this and dont have an example (i am
	 * very sorry ) if i have time i will redesign this class
	 */
	public String queryMemebers(Dormitory dor) throws SQLException {
		if (idExists(dor)) {
			System.out.println("ID Exist");
			conn = ConnectionFactory.getInstance().makeConnection();
			String sql3 = "SELECT student FROM  Dormitory WHERE dorId=?";
			PreparedStatement ps3 = conn.prepareCall(sql3);
			ps3.setString(1, dor.getDorId());
			ResultSet rs = ps3.executeQuery();
			if (rs.next()) {
				return rs.getString("student");
			} else {
				return "query Successfully but the table is empty";
			}

		}

		return "No this Dor ID";
	}

	public void Reset() {

		conn = ConnectionFactory.getInstance().makeConnection();
		String sql = "UPDATE Dormitory SET points='100'";
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Can not reset the points!", "Error", JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}

	}

	public boolean checkStudent(Connection conn, User user) {
		String sql = "SELECT * FROM  Dormitory  WHERE dorId=? AND password=?";
		boolean login = false;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			login = rs.next();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return login;
	}

	public void updatePassword(Connection conn, User user) throws SQLException {
		String sql = "UPDATE Dormitory SET password=? WHERE dorId=?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(2, user.getName());
		ps.setString(1, user.getPassword());
		ps.execute();
		ps.close();
	}

}
