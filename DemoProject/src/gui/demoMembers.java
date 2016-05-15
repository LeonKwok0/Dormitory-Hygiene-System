package gui;

import dao.Deduct;
import entity.Dormitory;

public class demoMembers {

	public static void main(String[] args) {
		Deduct ded=new Deduct();
		Dormitory dor=new Dormitory();
		dor.setDorId("06104");
		String s="Empty";
		try {
		s=ded.queryMemebers(dor);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(s);
	}

}
