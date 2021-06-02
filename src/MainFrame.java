import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static Dimension frame_size = new Dimension(1600, 1000);
    public static Dimension user_size = Toolkit.getDefaultToolkit().getScreenSize();
    public JPanel current;

    MainFrame() {
        setTitle("PiJano");
        setSize(frame_size);
        setLocation(user_size.width / 2 - frame_size.width / 2, user_size.height / 2 - frame_size.height / 2); // 置中
        setResizable(false); // 固定視窗大小
        ImageIcon image = new ImageIcon("src/img/logo.png"); // create a image icon
        setIconImage(image.getImage()); // change frame's icon
        switchTo("HomePage"); // 前往HomePage
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 關閉視窗即退出程式
    }

    public void switchTo(String target) {
        switch (target) {
            case "HomePage" -> switchToHomePage();
            case "GamingPage" -> switchToGamingPage();
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
