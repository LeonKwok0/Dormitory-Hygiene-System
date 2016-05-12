package gui;

import javax.swing.JOptionPane;

public class Error {
	public Error() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Dialog("test");
	}
	public static void Dialog(String title,String message){
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE); 
	}
	
	public static void Dialog(String message){
		JOptionPane.showMessageDialog(null, message, "Error:", JOptionPane.ERROR_MESSAGE); 
	}
}
