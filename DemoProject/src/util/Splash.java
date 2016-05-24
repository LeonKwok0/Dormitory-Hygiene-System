package util;

import javax.swing.*;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import gui.LoginFrame;

import java.awt.*;
import java.awt.image.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Splash {
	static Logger logger = Logger.getLogger(Splash.class.getSimpleName());
	final SplashScreen splash = SplashScreen.getSplashScreen();
	Rectangle splashBounds;
	Graphics2D splashGraphics;

	protected void initSplash() throws Exception {
		if (splash == null) {
			throw new Exception("no splash image specified eg. -splash:nanyou.jpg");
		}
		splashBounds = splash.getBounds();
		splashGraphics = (Graphics2D) splash.createGraphics();
		if (splashGraphics == null)
			throw new Exception("no SplashScreen Graphics2D");
		splashGraphics.setColor(Color.YELLOW);
		splashGraphics.drawRect(0, 0, splashBounds.width - 1, splashBounds.height - 1);
	}

	protected void updateSplash(String status, int progress) {
		if (splash == null)
			return;
		if (splashGraphics == null)
			return;
		drawSplash(splashGraphics, status, progress);
		splash.update();
	}

	protected void drawSplash(Graphics2D splashGraphics, String status, int progress) {
		int barWidth = splashBounds.width * 60 / 100;
		splashGraphics.setComposite(AlphaComposite.Clear);
		splashGraphics.fillRect(110, 280, splashBounds.width - 2, 20);
		splashGraphics.setPaintMode();
		splashGraphics.setColor(Color.RED);
		splashGraphics.drawString(status, 150, 300);
		splashGraphics.setColor(Color.BLACK);

		splashGraphics.setColor(Color.WHITE);
		int width = progress * barWidth / 100;
		splashGraphics.fillRect(130, 280, width + 1, 9);
		splashGraphics.setColor(Color.DARK_GRAY);
		splashGraphics.fillRect(200 + width + 1, 400, barWidth - width, 9);
	}

	protected void loadApplication() {
		try {
			initSplash();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
		}
		final String[] stages = { "dao/conncetionFacory", "dao/adminIpm", "gui/mainframe", "gui/studentfram",
				"entity/user" };
		int stage = 0;
		for (int i = 0; i <= 100; i += 5) {
			String status = "Loading " + stages[stage] + "...";
			if (splash != null)
				updateSplash(status, i);
			try {
				Thread.sleep(100);
				if (i == 30)
					stage = 1;
				else if (i == 60)
					stage = 2;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (splash != null)
			splash.close();
//		 try {
//			// set Beauty Eye as look&feel
//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//		
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//			UIManager.put("RootPane.setupButtonVisible", false);// hide setting button
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String args[]) {
		new Splash().loadApplication();
	}
}
