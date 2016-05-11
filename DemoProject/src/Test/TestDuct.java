package Test;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionFactory;
import dao.Deduct;
import entity.Dormitory;

public class TestDuct {

	public static void main(String[] args) {
		Dormitory dor=new Dormitory();
		dor.setDorId("gg15304");
		dor.setDeductPoints(5);
		dor.setReasons("Other : AAAAAa");
		dor.setTime("the 1th week");
		
		Connection conn=ConnectionFactory.getInstance().makeConnection();
		Deduct r1=new Deduct();
		try {
			r1.update(dor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
