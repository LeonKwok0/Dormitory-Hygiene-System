package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Login;
import entity.Dormitory;
import entity.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.security.acl.Group;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private BackGroundPanel contentPane;
	private static LoginFrame frame;
	private JTextField txtEnterYourId;
	private JPasswordField passwordField;
	private Login login = new Login();
	private Dormitory dor = new Dormitory();
	private User user;
	private JRadioButton labelAdmin;
	private JRadioButton labelStudent;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFrame();
//					frame.setSize(400, 400);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setFocusable(true);// set focuseable or it will focuse on textfield it
							// not beautiful
		setResizable(false);
		setTitle("Dormitory Hygiene System-Login ");
		URL imgURL=LoginFrame.class.getResource("/images/bg1.jpg");
		ImageIcon im = new ImageIcon(imgURL);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 362);
		contentPane = new BackGroundPanel(im.getImage());
		// BackGroundPanel is JPanel 's subclass
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);

		txtEnterYourId = new JTextField();
		txtEnterYourId.setToolTipText("Student use Dormitory id to login Example:01101 defult password is your id");
		txtEnterYourId.setText("Enter Your ID");
		txtEnterYourId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterYourId.setForeground(Color.LIGHT_GRAY);
		txtEnterYourId.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = txtEnterYourId.getText();
				String userpa = passwordField.getText();

				if (userid.equals("") || userid.equals("Enter Your ID") || userpa.equals("")) {
					JOptionPane.showMessageDialog(null, "User nam or password should not be empty!", "Error: ",
							JOptionPane.ERROR_MESSAGE);
				} else {
					dor.setName(userid);
					dor.setPassword(userpa);
					dor.setDorId(userid);
					/** 
					 * the design of dao class have a problme 
					 * dorid==name this bad
					 */

					if (labelAdmin.isSelected()) {
						if (login.checkAdmin(dor)) {
							dispose();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Main frame = new Main(dor);
										frame.setVisible(true);
										frame.setLocationRelativeTo(null);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
						} else {
							JOptionPane.showMessageDialog(null, "ID or Password is wrong!", "Error: ",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						System.out.println(dor.getName() + " " + dor.getPassword());
						if (login.checkStudent(dor)) {
							dispose();
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										StudentFram frame = new StudentFram(dor);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
									
								}
							});
						} else {

							JOptionPane.showMessageDialog(null,
									"ID or Password is wrong\nStudent use Dormitory id to login \nExample:01101 defult password is 123456",
									"Error: ", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			}
		});
		btnNewButton.setForeground(Color.BLACK);
		URL logURL=LoginFrame.class.getResource("/images/logo1.png");
		ImageIcon logo = new ImageIcon(logURL);
		logo.setImage(logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setText("");

		JLabel label_1 = new JLabel("");

		labelAdmin = new JRadioButton("Admin",true);
		labelAdmin.setForeground(Color.WHITE);
		labelStudent = new JRadioButton("Student");
		labelStudent.setForeground(Color.WHITE);

		ButtonGroup group = new ButtonGroup();
		group.add(labelAdmin);
		group.add(labelStudent);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.LIGHT_GRAY);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(91)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(labelAdmin)
									.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
									.addComponent(labelStudent))
								.addComponent(passwordField)
								.addComponent(txtEnterYourId, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
								.addComponent(logoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(151)
							.addComponent(btnNewButton)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEnterYourId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelAdmin)
						.addComponent(labelStudent))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(27))
		);
		panel.setLayout(gl_panel);
	}

}
