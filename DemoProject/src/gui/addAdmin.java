package gui;

import javax.swing.*;

import dao.AdminIpm;
import entity.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.*;

public class addAdmin extends JFrame {
	private User user2 = new User();

	public addAdmin() {
		setTitle("Add Addministrator");
		setSize(300, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		JPanel adduser = new JPanel();
		adduser.setLayout(new GridLayout(3, 2, 20, 20));
		JTextField ID = new JTextField(8);
		JTextField Password = new JTextField(8);
		JTextField Passwordagain = new JTextField(8);
		adduser.add(new JLabel("Enter ID :        "));
		adduser.add(ID);
		adduser.add(new JLabel("Enter Password:  "));
		adduser.add(Password);
		adduser.add(new JLabel("Confirm Password:"));
		adduser.add(Passwordagain);
		JPanel adduser2 = new JPanel();
		adduser2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton sure = new JButton("Sure");
		adduser2.add(sure);
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((ID.getText()).equals("") | (Password.getText()).equals("")
						| (Passwordagain.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "cotent can not be empty!");
				} else {
					boolean a = ID.getText().matches("[^0-9a-zA-Z]");
					boolean b = Password.getText().matches("[^0-9a-zA-Z]");
					if (a|| b) {
						JOptionPane.showMessageDialog(null, "Only numbers and alphabet are allowable");
					} else {
						if ((Password.getText()).equals(Passwordagain.getText())) {
							user2.setName(ID.getText());
							user2.setPassword(Password.getText());

							Connection conn = dao.ConnectionFactory.getInstance().makeConnection();
							AdminIpm ipm = new AdminIpm();
							try {
								ipm.saveNewAdmin(conn, user2);
								JOptionPane.showMessageDialog(null, "Add New admin accout Sucessfully!");
								conn.close();
								dispose();
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Error:Can not save user in Database!");
								e1.printStackTrace();
							}

						} else {
							JOptionPane.showMessageDialog(null, "two passwords must be same!");
						}
					}
				}
			}
		});
		add(adduser, BorderLayout.NORTH);
		add(adduser2, BorderLayout.SOUTH);
	}
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					addAdmin frame = new addAdmin();
////					frame.setSize(400, 400);
//					frame.setLocationRelativeTo(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
