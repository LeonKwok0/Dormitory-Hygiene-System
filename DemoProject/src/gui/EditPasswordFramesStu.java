package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;

import dao.AdminIpm;
import dao.ConnectionFactory;
import dao.Deduct;
import entity.User;

public class EditPasswordFramesStu extends JFrame {


	User user;

	JPanel j1 = new JPanel();

	JLabel jb1 = new JLabel();

	JLabel txtUserName = new JLabel();

	JLabel jb2 = new JLabel();

	JPasswordField txtPassWord = new JPasswordField();

	JLabel jb3 = new JLabel();
	JPasswordField newpass = new JPasswordField();
	JLabel jb4 = new JLabel();

	JPasswordField newpass2 = new JPasswordField();

	JTextArea jt1 = new JTextArea();
	JButton button = new JButton();
	ButtonGroup group = new ButtonGroup();
	JRadioButton r1 = new JRadioButton("student");
	JRadioButton r2 = new JRadioButton("admin");
	
	
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				User user=new User();
				user.setName("admin1");
					EditPasswordFramesStu frame = new EditPasswordFramesStu(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditPasswordFramesStu(User user) {

		setTitle("Modify the password");
		setSize(400, 300);
		// setLayout(new GridLayout(2,1));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setVisible(true);
		j1.setLayout(null);
		jb1.setText("raw ID:");

		jb1.setBounds(50, 20, 100, 26);

		txtUserName.setText(user.getName());

		txtUserName.setBounds(200, 20, 100, 26);

		jb2.setText("old password:");

		jb2.setBounds(50, 50, 100, 26);
		txtPassWord.setText("");

		txtPassWord.setBounds(200, 50, 100, 26);

		jb3.setText("new password:");

		jb3.setBounds(50, 80, 100, 26);

		newpass.setText("");

		newpass.setBounds(200, 80, 100, 26);

		jb4.setText("confirm password:");

		jb4.setBounds(50, 110, 150, 26);

		newpass2.setText("");

		newpass2.setBounds(200, 110, 100, 26);

		button.setText("change the password");

		button.setBounds(90, 180, 185, 26);

		r1.setBounds(50, 140, 100, 26);

		r2.setBounds(200, 140, 100, 26);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dao.Deduct dec = new Deduct();
				Connection conn = ConnectionFactory.getInstance().makeConnection();

				user.setPassword(txtPassWord.getText());
				System.out.println(user.getPassword());
				if (dec.checkStudent(conn, user)){
					
					if (newpass.getText().equals(newpass2.getText())) {
						if (newpass.getText().equals("") | newpass2.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "newpassword is empty", "Tip",
									JOptionPane.ERROR_MESSAGE);

						} else if (newpass.getText().length() < 6) {
							JOptionPane.showMessageDialog(null, "newpassword can't shorter than 6", "Tip",
									JOptionPane.ERROR_MESSAGE);

						} else if (hasSpecialChars(newpass.getText())) {
							JOptionPane.showMessageDialog(null,
									"illegal password��password should not contain special chars", "Tip",
									JOptionPane.ERROR_MESSAGE);

						} else {

							user.setPassword(newpass.getText());
							System.out.println(user.getPassword());
							try {
								dec.updatePassword(conn, user);
								JOptionPane.showMessageDialog(null, "password is modified successfully", "Tip",
										JOptionPane.INFORMATION_MESSAGE);
							   
								conn.close();
								dispose();
								
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "input are not corresponded", "Tip",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Old password is wrong", "Tip", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		j1.add(jb1);
		j1.add(txtUserName);

		j1.add(jb2);
		j1.add(txtPassWord);
		j1.add(jb3);
		j1.add(newpass);
		j1.add(jb4);
		j1.add(newpass2);

		group.add(r1);
		group.add(r2);
		// j1. add(r1);
		// j1. add(r2);
		add(j1);

		j1.add(button);

	}

	public JPasswordField getNewpass() {
		return newpass;
	}

	public JPasswordField getNewpass2() {
		return newpass2;
	}

	public static boolean hasSpecialChars(String a) {
		boolean f = false;

		char c;
		for (int i = 0; i <= a.length() - 1; i++) {
			c = a.charAt(i);
			switch (c) {
			case '>':
				f = true;
				break;
			case '<':
				f = true;
				break;
			case '"':
				f = true;
				break;
			case '&':
				f = true;
				break;

			case '\'':
				f = true;
				break;

			case '%':
				f = true;
				break;
			case '_':
				f = true;
				break;
			case '#':
				f = true;
				break;
			case '?':
				f = true;
				break;
			case '!':
				f = true;
				break;
			case '@':
				f = true;
				break;
			case '~':
				f = true;
				break;
			case '*':
				f = true;
				break;
			case ':':
				f = true;
				break;
			case ';':
				f = true;
				break;
			case '(':
				f = true;
				break;
			case ')':
				f = true;
				break;
			case '+':
				f = true;
				break;
			case '|':
				f = true;
				break;

			case '[':
				f = true;
				break;
			case ']':
				f = true;
				break;
			}
		}

		return f;
	}
}
