package util;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class BackGroundFrame extends JFrame {
	private JPanel imagePanel;
	private ImageIcon background;
	public BackGroundFrame() {
		// TODO Auto-generated constructor stub
	}
	public BackGroundFrame(ImageIcon background) {
		this.background = background;
		Image img=background.getImage();
		background.setImage(img.getScaledInstance(this.getWidth(),this.getHeight(),img.SCALE_DEFAULT));
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		// 把标签的大小位置设置为窗体大小
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		getLayeredPane().setLayout(null);
		// 把背景图片添加到分层窗格的最底层作为背景
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//		setSize(background.getIconWidth(), background.getIconHeight());
	}
	
	public void setBackground(ImageIcon background) {
		this.background = background;
		Image img=background.getImage();
		background.setImage(img.getScaledInstance(this.getWidth(),this.getHeight(),img.SCALE_DEFAULT));
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		// 把标签的大小位置设置为窗体大小
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		getLayeredPane().setLayout(null);
		// 把背景图片添加到分层窗格的最底层作为背景
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//		setSize(background.getIconWidth(), background.getIconHeight());
		
	}
	
	
	
	   public void paintComponent(Graphics g)  
	    {  
	        super.paintComponents(g);  
	        g.drawImage(background.getImage(),0,0,this.getWidth(),this.getHeight(),this);  
	          
	    } 
	
	
}
