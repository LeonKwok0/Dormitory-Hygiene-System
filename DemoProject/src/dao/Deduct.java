package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Dormitory;
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
     * 在方法update 这里存在一个问题
     *之后有时间再解决
     * @param dormitory
     * @throws SQLException
     */
	public boolean idExists(Dormitory dormitory) throws SQLException{
		conn=ConnectionFactory.getInstance().makeConnection();
		String sql="SELECT * FROM  Dormitory WHERE dorId=?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, dormitory.getDorId());
		ResultSet rs2=ps.executeQuery();
		record = rs2.next();
		return record;
	}
	
	
	public void update(Dormitory dormitory) throws SQLException {
		// 向 表deduction_record 中添加记录 （这里是扣分记录）
	
		conn=ConnectionFactory.getInstance().makeConnection();
					
	    String sql="insert into deduction_record(time,reason,points,dorId) values(?,?,?,?);";
		PreparedStatement ps = conn
				.prepareCall(sql);
		ps.setString(1, dormitory.getTime());
		ps.setString(2, dormitory.getReasons());
		ps.setInt(3, dormitory.getDeductPoints());
		ps.setString(4, dormitory.getDorId());
		ps.execute();
		
		
		// 向 表Dormitory 修改记录 总分减去相应的值
		String sql2="UPDATE Dormitory SET points=(points-?) WHERE dorId=?";
		PreparedStatement ps2 = conn
				.prepareCall(sql2);
		ps2.setInt(1, dormitory.getDeductPoints());
		ps2.setString(2, dormitory.getDorId());
		ps2.execute();
		
		/* there is a problem here 
		 * if the dorid is not exist in Dormitory, jvm dont return error 
		 * 
		 * 一个问题： 这里即使在Dormitory表没有指定的宿舍id 也不会报错
		 *有空再解决。 
		 */
		ps.close();
		ps2.close();
		
	}
	
	
	public  void checkCurrentPoints(Dormitory dormitory) throws SQLException {
		conn=ConnectionFactory.getInstance().makeConnection();
		String sql3="SELECT points FROM  Dormitory WHERE dorId=?";
		PreparedStatement ps3 = conn.prepareCall(sql3);
		ps3.setString(1, dormitory.getDorId());
		 ResultSet rs=ps3.executeQuery();
		record = rs.next();
		if (!record) {
			System.out.println("Error: no this Dor id");
		}else{
			this.currentPoints=rs.getInt("points");
		}	
		conn.close();
	}
	
	
}
