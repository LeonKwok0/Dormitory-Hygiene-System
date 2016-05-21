package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextPane;
import javax.swing.JLabel;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

public class AboutFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	

	/**
	 * Create the frame.
	 */
	public AboutFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AboutFrame.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setTitle("About Us");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		


		

		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnOurProgramIs = new JTextPane();
		txtpnOurProgramIs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnOurProgramIs.setBackground(UIManager.getColor("Button.background"));
		txtpnOurProgramIs.setBounds(1, 23, 483, 102);
		txtpnOurProgramIs.setText("Our program is a dormitory hygiene management system that used to deduct marks of dormitory hygiene. You can also find your dormitory's points, resons for deducting marks, rank and alarm here.");
		panel.add(txtpnOurProgramIs);
		
		JLabel lblNewLabel = new JLabel("Group Members");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(1, 130, 154, 33);
		panel.add(lblNewLabel);
		
		JTextPane txtpnLeonLeonguogmailcomPaul = new JTextPane();
		txtpnLeonLeonguogmailcomPaul.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnLeonLeonguogmailcomPaul.setBackground(UIManager.getColor("Button.background"));
		txtpnLeonLeonguogmailcomPaul.setText("Leon                           leonguo08@gmail.com\r\nPaul                            463092650@qq.com\r\nHarry                          873891323@qq.com\r\nLeo                             1206637207@qq.com");
		txtpnLeonLeonguogmailcomPaul.setBounds(-1, 164, 485, 118);
		panel.add(txtpnLeonLeonguogmailcomPaul);
		
		JLabelURL lblNewLabel_1 = new JLabelURL("https://github.com/LeonKwok0/Dormitory-Hygiene-System","https://github.com/LeonKwok0/Dormitory-Hygiene-System");

		lblNewLabel_1.setBounds(12, 316, 409, 38);
		panel.add(lblNewLabel_1);
		
		JTextPane txtpnEnterOurProgram = new JTextPane();
		txtpnEnterOurProgram.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnEnterOurProgram.setBackground(UIManager.getColor("Button.background"));
		txtpnEnterOurProgram.setText("Enter our program address:");
		txtpnEnterOurProgram.setBounds(0, 293, 264, 22);
		panel.add(txtpnEnterOurProgram);
		
		JTextPane txtpnAboutProgram = new JTextPane();
		txtpnAboutProgram.setBackground(UIManager.getColor("Button.background"));
		txtpnAboutProgram.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtpnAboutProgram.setText("About Program");
		txtpnAboutProgram.setBounds(1, 0, 173, 22);
		panel.add(txtpnAboutProgram);
		
		
		
		
		
	}
}
