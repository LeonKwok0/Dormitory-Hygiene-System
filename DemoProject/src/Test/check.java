package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.ConnectionFactory;

public class check {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	String [] [] table;
	
	public static void main(String[] args) {
		check obj=new check();
		Object [][] list=obj.tblData();
		for (int i = 0; i<list.length-1; i++) {
			System.out.println("第"+i+""+list[i][i]+""+list[i][i+1]+""+list[i][i+2]);
		}
	}
	
//
//	public void inquire() {
//		try {
//			conn = ConnectionFactory.getInstance().makeConnection();
//			String sql = "SELECT *  FROM points ";
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//
//				System.out.println(rs.getString("dorId") + rs.getString("address") + rs.getInt("points"));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	public String [][] tblData() {
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			String sql = "SELECT time,address,points FROM points ";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int i=0;
			int row=0;
			
			while (rs.next()) {
				table[i][i]=rs.getString("time");
				table[i][i+1]=rs.getString("address");
				table[i][i+2]=String.valueOf(rs.getInt("points"));
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return table;
	}

}
