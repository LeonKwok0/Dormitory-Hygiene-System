package gui;

/**
 * main 主界面
 * 用来添加扣分记录 以及 排名和警告 
 * 问题： 
 * 扣分记录部分 需要增加空值判断。 （在界面上显示但是 并没有初始一个值）
 * 
 */
import entity.Dormitory;
import entity.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import dao.Deduct;
import dao.QueryTable;

import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOtherReason;
	private JComboBox comboBoxReason;
	private JComboBox comboBoxBuliding;
	private JComboBox comboBoxRoom;
	private JTextField textFieldPoint;

	private Dormitory dor = new Dormitory();
	private String dorId;
	private String time = "1th ";
	private String reasons1 = "Pool is dirty ";
	private int deductPoints;
	private String buliding = "01";
	private String room = "101";
	private JLabel checkPoints;

	private Vector columnHeads;
	private Vector rowdata;
	private JLabel labelReturnResult;
	private JTable tableRank;
	private JScrollPane scrollPane;
	private JTable tableAlarm;
	private JScrollPane scrollPane_alram;
	private boolean pointIsTrue = true;
	private JLabel returnResult2;
	private JLabel labelResetResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user = new User();
					user.setName("admin1");
					Main frame = new Main(user);
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
	public Main(User user) {
		setTitle("Dormitory Health Management System-Remote Version\r");

		try {
			// set Beauty Eye as look&feel
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			/*
			 * set frameBorderStyle 
			 * 强立体半透明 translucencyAppleLike 
			 * 弱立体感半透明
			 * translucencySmallShadow 普通不透明 
			 * generalNoTranslucencyShadow 系统默认样式
			 * osLookAndFeelDecorated
			 */
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
			UIManager.put("RootPane.setupButtonVisible", false);// hide setting
																// button
			UIManager.put("TabbedPane.tabAreaInsets"
				    , new javax.swing.plaf.InsetsUIResource(3,20,2,20));// set TabbedPane to leading
			
//			btnInstance.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setSize(800, 500); // (width,heigth) set size
		setLocationRelativeTo(null); // center a frame

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Deduct", null, panel, null);

		JLabel lblNewLabel = new JLabel("Buliding:");

		comboBoxBuliding = new JComboBox();
		comboBoxBuliding.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					buliding = comboBoxBuliding.getSelectedItem().toString();
				}
			}
		});
		comboBoxBuliding.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15" }));
		// comboBoxBuliding.setSelectedIndex(0);
		comboBoxBuliding.setSelectedItem(comboBoxBuliding.getSelectedItem());

		JLabel lblNewLabel_1 = new JLabel("Room:");

		comboBoxRoom = new JComboBox();
		comboBoxRoom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					room = comboBoxRoom.getSelectedItem().toString();
				}
			}
		});
		comboBoxRoom.setModel(new DefaultComboBoxModel(
				new String[] { "101", "102", "103", "104", "201", "202", "203", "204", "301", "302", "303", "304" }));
		comboBoxRoom.setSelectedIndex(0);

		JLabel lblNewLabel_2 = new JLabel("Reasons:");

		comboBoxReason = new JComboBox();
		comboBoxReason.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				/**
				 * 就是item的状态发生改变时触发该事件，item在这里的状态有两个，Selected
				 * 和deSelected（即选中和未被选中 所以，当改变下拉列表中被选中的项的时候，其实是触发了两次事件
				 * 第一次是上次被选中的项的 State 由 Selected 变为 deSelected ，即取消选择，
				 * 二次是本次被选中的项的 State 由 deSelected 变为 Selected ，即新选中，
				 */
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (comboBoxReason.getSelectedItem().toString().equals("Other")) {
						textFieldPoint.setText("");
						textFieldOtherReason.setText("");
					}

					if (comboBoxReason.getSelectedItem().toString().equals("Pool is dirty")) {
						textFieldOtherReason.setText("Detial:null");
						textFieldPoint.setText("5");

					}
					if (comboBoxReason.getSelectedItem().toString().equals("Tolite is dirty")) {
						textFieldOtherReason.setText("  Detial:null");
						textFieldPoint.setText("5");

					}
					if (comboBoxReason.getSelectedItem().toString().equals("Unallowable things")) {
						textFieldOtherReason.setText("  Detial:null");
						textFieldPoint.setText("10");

					}
					if (comboBoxReason.getSelectedItem().toString().equals("Ground is dirty")) {
						textFieldOtherReason.setText("  Detial:null");
						textFieldPoint.setText("5");

					}
					reasons1 = comboBoxReason.getSelectedItem().toString();
					System.out.println("comboBoxReason selected:" + reasons1);
				}
			}
		});

		comboBoxReason.setModel(new DefaultComboBoxModel(
				new String[] { "Pool is dirty", "Tolite is dirty", "Ground is dirty", "Unallowable things", "Other" }));
		comboBoxReason.setSelectedIndex(0);

		textFieldOtherReason = new JTextField("   Detail:null");
		textFieldOtherReason.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldOtherReason.setEditable(true);
		textFieldOtherReason.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Points:");

		JLabel lblNewLabel_4 = new JLabel("Time:");

		JLabel lblNewLabel_5 = new JLabel("the");

		JComboBox comboBoxTime = new JComboBox();
		comboBoxTime.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					time = "The" + comboBoxTime.getSelectedItem().toString() + " Week";

				}
			}
		});
		comboBoxTime.setModel(new DefaultComboBoxModel(new String[] { "1th", "2nd", "3rd", "4th", "5th", "6th", "7th",
				"8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th" }));
		comboBoxTime.setSelectedIndex(0);

		JLabel lblNewLabel_6 = new JLabel("Week");

		/**
		 * submit button event
		 */
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cast string point to int
				CastPoints(textFieldPoint.getText());

				// comfirm dialog
				if (pointIsTrue) {
					String message = "Dormitory: " + buliding + room + "\n" + "reason: " + reasons1
							+ textFieldOtherReason.getText() + "\n" + "time: " + time + "\n" + "Duct points:"
							+ deductPoints;
					int option = JOptionPane.showConfirmDialog(null, message, "Are you sure?",
							JOptionPane.OK_CANCEL_OPTION);
					if (option == 0) {
						System.out.println(option);
						addRecord();
					}
				}
			}

		});

		JSeparator separator = new JSeparator();

		textFieldPoint = new JTextField();

		textFieldPoint.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("");

		checkPoints = new JLabel("");

		labelReturnResult = new JLabel("Result:");

		returnResult2 = new JLabel("");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
						.createSequentialGroup().addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
								gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
										.createParallelGroup(Alignment.TRAILING)
										.addComponent(separator, GroupLayout.DEFAULT_SIZE, 757,
												Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
														.addComponent(lblNewLabel_2)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblNewLabel_4)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(lblNewLabel_5)))
												.addComponent(lblNewLabel).addComponent(lblNewLabel_3))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(comboBoxBuliding, 0, 272, Short.MAX_VALUE)
														.addComponent(comboBoxTime, 0, 272, Short.MAX_VALUE)
														.addComponent(comboBoxReason, 0, 272, Short.MAX_VALUE)
														.addComponent(textFieldPoint, GroupLayout.DEFAULT_SIZE, 272,
																Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblNewLabel_1)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(comboBoxRoom, GroupLayout.PREFERRED_SIZE,
																		145, GroupLayout.PREFERRED_SIZE))
														.addComponent(textFieldOtherReason, GroupLayout.DEFAULT_SIZE,
																412, Short.MAX_VALUE)
														.addComponent(lblNewLabel_6)
														.addGroup(gl_panel.createSequentialGroup()
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblNewLabel_7)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addGap(29).addComponent(checkPoints,
																						GroupLayout.DEFAULT_SIZE, 289,
																						Short.MAX_VALUE)))
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(btnNewButton))))))
								.addGroup(gl_panel.createSequentialGroup().addGap(53).addComponent(returnResult2))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap()
										.addComponent(labelReturnResult)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(comboBoxBuliding, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1).addComponent(comboBoxRoom, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(comboBoxReason, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldOtherReason, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
								.addComponent(comboBoxTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5).addComponent(lblNewLabel_6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3).addComponent(btnNewButton).addComponent(lblNewLabel_7)
								.addComponent(checkPoints))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelReturnResult)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(returnResult2)
						.addContainerGap(223, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		/**
		 * code for rank tag
		 */
		JPanel panelRank = new JPanel();
		tabbedPane.addTab("Ranking", null, panelRank, null);
		panelRank.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panelRank.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_8 = new JLabel("This is the dormitory Rank order by total points:");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);

		JButton buttonRefresh = new JButton("Refresh");
		buttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rank();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
					.addComponent(buttonRefresh)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
					.addComponent(buttonRefresh)
					.addComponent(lblNewLabel_8, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);

		scrollPane = new JScrollPane();
		panelRank.add(scrollPane, BorderLayout.CENTER);

		tableRank = new JTable();
		scrollPane.setViewportView(tableRank);

		JPanel panelAlarn = new JPanel();
		tabbedPane.addTab("Alarm", null, panelAlarn, null);
		panelAlarn.setLayout(new BorderLayout(0, 0));

		JPanel panelAlaram_North = new JPanel();
		panelAlarn.add(panelAlaram_North, BorderLayout.NORTH);

		JLabel labelalram = new JLabel("Points uder 60 will be shown here:");

		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alarm();
			}
		});

		// group layout for alram
		GroupLayout gl_panelAlaram_North = new GroupLayout(panelAlaram_North);
		gl_panelAlaram_North.setHorizontalGroup(gl_panelAlaram_North.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlaram_North.createSequentialGroup().addContainerGap().addComponent(labelalram)
						.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE).addComponent(btnNewButton_1)
						.addContainerGap()));
		gl_panelAlaram_North.setVerticalGroup(
				gl_panelAlaram_North.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panelAlaram_North.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelalram, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
								.addComponent(btnNewButton_1)));
		panelAlaram_North.setLayout(gl_panelAlaram_North);

		scrollPane_alram = new JScrollPane();
		panelAlarn.add(scrollPane_alram, BorderLayout.CENTER);
		tableAlarm = new JTable();
		scrollPane_alram.setViewportView(tableAlarm);

		// add jtabbedpane to frame
		contentPane.add(tabbedPane);

		/**
		 * Manage tag is from here
		 * 
		 */
		JPanel panelManage = new JPanel();
		tabbedPane.addTab("Manage", null, panelManage, null);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String message = "All the Points wil be reset as 100!";
				int option = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.OK_CANCEL_OPTION);
				if (option == 0) {
					new Deduct().Reset();
					labelResetResult.setText("Result:Sucessfully!");
				}
			}

		});

		JLabel lblNewLabel_9 = new JLabel(
				"Click Reset Button will reset all dormitories' Points.(will be add to 100 points)");

		labelResetResult = new JLabel("Result:");

		JSeparator separator_1 = new JSeparator();

		JSeparator separator_2 = new JSeparator();

		JButton btnNewButton_3 = new JButton("  Edit  ");

		// editbutton event
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditPasswordFrame frame = new EditPasswordFrame(user);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JLabel lblNewLabel_11 = new JLabel("Click Edit Button to change Your Password");

		JSeparator separator_3 = new JSeparator();

		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							addAdmin frame = new addAdmin();
							// frame.setSize(400, 400);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		JLabel lblNewLabel_12 = new JLabel("Click Add Button  to admin account. ");

		JSeparator separator_4 = new JSeparator();

		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AboutFrame frame = new AboutFrame();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}

		});
		GroupLayout gl_panelManage = new GroupLayout(panelManage);
		gl_panelManage.setHorizontalGroup(
			gl_panelManage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelManage.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelManage.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
						.addComponent(separator_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
						.addGroup(gl_panelManage.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_12))
						.addGroup(gl_panelManage.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_11))
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbout, Alignment.TRAILING)
						.addGroup(gl_panelManage.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
						.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9)
						.addComponent(labelResetResult)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelManage.setVerticalGroup(
			gl_panelManage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelManage.createSequentialGroup()
					.addGap(27)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelResetResult)
					.addGap(12)
					.addGroup(gl_panelManage.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_12)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnAbout)
					.addGap(18))
		);
		panelManage.setLayout(gl_panelManage);
	}

	/**
	 * CastPoints(String points) is used to cast String Type(come from jtextfild
	 * input) to int
	 */
	private int CastPoints(String points) {
		checkPoints.setText("");
		pointIsTrue = true;
		try {
			this.deductPoints = Integer.parseInt(points);
			if (this.deductPoints <= 0 || this.deductPoints >= 100) {
				checkPoints.setText("Exceed Range");
				pointIsTrue = false;
			}
		} catch (NumberFormatException e1) {
			checkPoints.setText(" Only Enter Interger");
			pointIsTrue = false;
		} catch (Exception e) {
			checkPoints.setText(" UnKnwon Error");
			pointIsTrue = false;
		}
		return deductPoints;

	}

	/**
	 * add deductrecord and return result
	 */
	private void addRecord() {
		// set duct points record
		dor.setDorId(buliding + room);
		dor.setReasons(reasons1 + "" + textFieldOtherReason.getText());
		dor.setDeductPoints(deductPoints);
		dor.setTime(time);
		Deduct deduct = new Deduct();

		// add record to database
		try {
			if (deduct.idExists(dor)) {
				deduct.update(dor);
				deduct.checkCurrentPoints(dor);
				labelReturnResult.setText("Result:" + "Deduct Successfully !");
				returnResult2.setText("Dormitory:" + dor.getDorId() + " Current Points: " + deduct.getCurrentPoints());
				labelReturnResult.setForeground(Color.black);
			} else {
				labelReturnResult.setText("Result:" + "Error: No this Dormitory!");
				labelReturnResult.setForeground(Color.red);
				returnResult2.setText(" ");
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * this method is used to show table from Database
	 */
	public void rank() {
		QueryTable query = new QueryTable();
		query.Query("SELECT dorId, address, points FROM Dormitory ORDER BY points DESC");
		columnHeads = query.getColumnHeads();
		rowdata = query.getRowdata();
		tableRank = new JTable(rowdata, columnHeads);
		scrollPane.setViewportView(tableRank);
		query.closeConn();
	}

	public void alarm() {
		Vector columnHeads2;
		Vector rowdata2;
		QueryTable query = new QueryTable();
		query.Query("SELECT dorId, address, points FROM Dormitory WHERE points<60 ORDER BY points ");
		columnHeads2 = query.getColumnHeads();
		rowdata2 = query.getRowdata();
		tableAlarm = new JTable(rowdata2, columnHeads2);
		scrollPane_alram.setViewportView(tableAlarm);
		query.closeConn();
	}
}
