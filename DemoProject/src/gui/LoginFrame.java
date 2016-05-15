package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.acl.Group;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Color;

public class LoginFrame extends JFrame {

	private BackGroundPanel contentPane;
	private static LoginFrame frame;
	private JTextField textField;
	private JTextField textField_1;
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
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.BLACK);
		
		ImageIcon logo=new ImageIcon("images/logo.jpg");
		logo.setImage(logo.getImage().getScaledInstance(90, 90,
			    Image.SCALE_DEFAULT));
		JLabel logoLabel = new JLabel(logo);
		logoLabel.setText("");
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Admin");
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Student");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(257)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(129)
							.addComponent(rdbtnNewRadioButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnNewRadioButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(178)
							.addComponent(btnNewButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(125)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(159)
							.addComponent(logoLabel)))
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(label)
					.addGap(71)
					.addComponent(logoLabel)
					.addGap(33)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
					.addGap(6)
					.addComponent(btnNewButton))
		);
		panel.setLayout(gl_panel);
		
		
	
	}
}



