package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Deduct;
import dao.QueryTable;
import entity.Dormitory;
import entity.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 * this is Student Windows where student can query ther deduction record 
 * and current; 
 * a place need to improve that, in this calss ,need to creat 6 SQL connection 
 * it is terrible . improve it (if i have time)
 * @author moxjane
 *
 */
public class StudentFram extends JFrame {

	private JPanel contentPane;
	private JTable tableDuct;
	private JLabel points_Label;
	private QueryTable query=new QueryTable();
	private  Vector columnHeads;
	private  Vector rowdata;
	private JScrollPane scrollPane;
	private Dormitory dor;
	private Deduct deduct;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// new a dormitory object for test 
					Dormitory dor =new Dormitory();
					dor.setDorId("01101");
					StudentFram frame = new StudentFram(dor);
					frame.setVisible(true);
					frame.setSize(500,600);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentFram(Dormitory dor) {
		this.dor=dor;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		
		points_Label = new JLabel("Current Points:"+ShowCurrentPoints());
		
		JLabel Members_label = new JLabel("Members:"+ShowMembers());
		
		JLabel lblNewLabel_2 = new JLabel("Deduction Record：");
		
		JLabel Id_Label = new JLabel("Dormitory ID:  "+dor.getDorId());
		
		/**
		 * Refresh Button Event
		 */
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDuctTable();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addComponent(Id_Label)
						.addComponent(points_Label)
						.addComponent(Members_label))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(Id_Label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(points_Label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Members_label)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(btnNewButton)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		getDuctTable();
		scrollPane.setViewportView(tableDuct);
	}
	
	
	
	
	public void getDuctTable(){
		query.Query("SELECT time,reason,points FROM  deduction_record order by time DESC");
		columnHeads = query.getColumnHeads();
		rowdata = query.getRowdata();
		tableDuct = new JTable(rowdata, columnHeads);
		scrollPane.setViewportView(tableDuct);
		query.closeConn();
	}
	
	
	
	
	 /*
	  * query student current all points 
	  */
	public String ShowCurrentPoints(){
		deduct=new Deduct();
		try {
			// if points low than 60 will be alarmed
			deduct.checkCurrentPoints(dor);
			if(deduct.getCurrentPoints()<60){
				return deduct.getCurrentPoints()+"  Alarm : Points too low";
			}else {
				return ""+deduct.getCurrentPoints();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	 /*
	  * query student current all points 
	  */
	public String ShowMembers(){
		try {
		return deduct.queryMemebers(dor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Null,Unknown Reason";
	}
	
	

}
