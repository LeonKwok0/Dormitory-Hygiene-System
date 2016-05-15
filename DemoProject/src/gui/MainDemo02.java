package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Dormitory;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainDemo02 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	static MainDemo02 frame1 ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1= new MainDemo02();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainDemo02() {
		setTitle("Manage Panel");
		setSize(600,370); //(width,heigth) set size 
		setLocationRelativeTo(null); //center a frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel LeftPanel = new JPanel();
		contentPane.add(LeftPanel, BorderLayout.WEST);
		LeftPanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				Dormitory dor=new Dormitory();
				dor.setDorId("06104");
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							StudentFram frame = new StudentFram(dor);
							frame.setVisible(true);
							frame.setSize(500,600);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setSize(10, 10);
		LeftPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			panel_1.setVisible(true);
			contentPane.repaint();
			}
		});
		LeftPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		LeftPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		LeftPanel.add(btnNewButton_3);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		centerPanel.add(panel, "name_15964253609458");
		
		JLabel lblNewLabel = new JLabel("panel1");
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		centerPanel.add(panel_1, "name_15964266680375");
		
		JLabel lblNewLabel_1 = new JLabel("panel2");
		panel_1.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		centerPanel.add(panel_2, "name_15964279482228");
		panel.setVisible(false);
		panel_1.setVisible(false);
		panel_2.setVisible(false);
		
	}

}
