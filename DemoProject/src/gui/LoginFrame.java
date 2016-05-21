package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Login;
import entity.Dormitory;
import entity.User;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private Login login;
	private Dormitory dor;
	private User user;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFrame();
					frame.setSize(400, 400);
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
		setTitle("Dormitory Hygiene System-Login ");
		ImageIcon im=new ImageIcon("images/bg1.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new BackGroundPanel(im.getImage());   
		//BackGroundPanel is JPanel 's subclass 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		
		txtEnterYourId = new JTextField();
		txtEnterYourId.setText("Enter Your ID");
		txtEnterYourId.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterYourId.setForeground(Color.LIGHT_GRAY);
		txtEnterYourId.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				frame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main frame = new Main(user);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		
		ImageIcon logo=new ImageIcon("images/logo22.jpg");
		logo.setImage(logo.getImage().getScaledInstance(90, 90,
			    Image.SCALE_DEFAULT));
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setText("");
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("");
		
		JRadioButton labelAdmin = new JRadioButton("Admin");
		labelAdmin.setForeground(Color.WHITE);
		JRadioButton labelStudent = new JRadioButton("Student");
		labelStudent.setForeground(Color.WHITE);
	
		ButtonGroup group=new ButtonGroup(); 
		group.add(labelAdmin); 
		group.add(labelStudent);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.LIGHT_GRAY);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(257)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(159)
							.addComponent(logoLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(163)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(116)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(6)
									.addComponent(labelAdmin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(labelStudent))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
									.addComponent(txtEnterYourId, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))))
					.addGap(156))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addGap(71)
					.addComponent(logoLabel)
					.addGap(33)
					.addComponent(txtEnterYourId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelAdmin)
						.addComponent(labelStudent))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(113))
		);
		panel.setLayout(gl_panel);
	}
	
	
	
}



