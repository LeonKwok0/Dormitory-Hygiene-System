package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import dao.QueryTable; // 插入数据库查询类

public class Rank extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector columnHeads;
	private Vector rowdata;
	private QueryTable query = new QueryTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rank frame = new Rank();
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
	public Rank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("宿舍卫生排名(Rank)");
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		query.Query("SELECT dorId, address, points FROM Dormitory ORDER BY points DESC");
		columnHeads = query.getColumnHeads();
		rowdata = query.getRowdata();
		table = new JTable(rowdata,columnHeads );
		scrollPane.setViewportView(table);
		query.closeConn();
	}

}
