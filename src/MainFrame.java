import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public static Dimension frame_size = new Dimension(1600, 1000);
    public static Dimension user_size = Toolkit.getDefaultToolkit().getScreenSize();
    public JPanel current;

    MainFrame() {
        setTitle("P i J a n o");
        setSize(frame_size);
        setLocation(user_size.width / 2 - frame_size.width / 2, user_size.height / 2 - frame_size.height / 2); // 置中
        setResizable(false); // 固定視窗大小
        ImageIcon image = new ImageIcon("src/img/logo.png"); // create a image icon
        setIconImage(image.getImage()); // change frame's icon
        switchTo("HomePage"); // 前往HomePage
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 關閉視窗即退出程式
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.out.println("esc");
                    //TODO: 按了ESC之後音樂以及程式都應該暫停
                    String[] option = { "退出", "取消" };
                    ImageIcon icon = new ImageIcon("src/img/return.gif");
                    int opt = JOptionPane.showOptionDialog(null, null, "請選擇", JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.YES_NO_CANCEL_OPTION, icon, option, option[0]);
                    if (opt == JOptionPane.YES_OPTION) {
                        Main.PiJano.removePage(current, "HomePage");
                    }

                }
            }
        });
    }

    public void switchTo(String target) {
        switch (target) {
            case "HomePage":
                switchToHomePage();
                break;
            case "GamingPage":
                switchToGamingPage();
                break;
        }
    }

    public void removePage(JPanel panel, String target) {
        panel.removeAll();
        panel.repaint();
        panel.revalidate();
        switchTo(target);
    }

    public void switchToHomePage() {
        current = new HomePage();
        add(current);
    }

    public void switchToGamingPage() {
        current = new GamingPage();
        add(current);
    }
}
