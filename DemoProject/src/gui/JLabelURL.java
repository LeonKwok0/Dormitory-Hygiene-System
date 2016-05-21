package gui;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelURL extends JLabel {
 String text, url;
 boolean isSupported;
public JLabelURL(String text, String url) {
     this.text = text;
     this.url = url;
     
     try {
      this.isSupported = Desktop.isDesktopSupported()
        && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
     } catch (Exception e) {
      this.isSupported = false;
     }
     setText(false);
     addMouseListener(new MouseAdapter() {
      public void mouseEntered(MouseEvent e) {
       setText(isSupported);
       if (isSupported)
        setCursor(new Cursor(Cursor.HAND_CURSOR));
      }
      public void mouseExited(MouseEvent e) {
       setText(false);
      }
      public void mouseClicked(MouseEvent e) {
       try {
        Desktop.getDesktop().browse(
          new java.net.URI(JLabelURL.this.url));
       } catch (Exception ex) {
       }
      }
     });
}
private void setText(boolean b) {
     if (!b)
      setText("<html><font color=blue><u>" + text);
     else
      setText("<html><font color=red><u>" + text);
}
//public static void main(String[] args) {
//     JFrame jf = new JFrame("About Us");
//     JPanel jp = new JPanel();
//     jp.add(new test1("Our Project Address", "https://github.com/LeonKwok0/Dormitory-Hygiene-System"));
//     jf.setContentPane(jp);
//     jf.pack();
//     jf.setVisible(true);
//     
//}
}