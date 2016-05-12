package Test;

import dao.Login;
import entity.User;

public class testLogin {
	public static void main(String[] args) {
		User user=new User();
		user.setName("admin1");
		user.setPassword("admin1");
		System.out.println(new Login().check(user, 0));
	}
}
