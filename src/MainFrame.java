import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public static Dimension frame_size = new Dimension(1600, 1000);
    public static Dimension user_size = Toolkit.getDefaultToolkit().getScreenSize();
    public JPanel current;

    public ArrayList<String> available_list = new ArrayList<String>();
    public String now_playing;
    public MusicPlayer mp;

    public Controlls ps4;

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

        ps4 = new Controlls();
    }

    public void switchTo(String target) {
        switch (target) {
            case "HomePage":
                switchToHomePage();
                break;
            case "SelectPage":
                switchToSelectPage();
                break;
            case "GamingPage":
                switchToGamingPage();
                break;
        }
    }

    public void removePage(JPanel panel, String target) {
        panel.removeAll();
        switchTo(target);
        current.repaint();
        current.revalidate();
    }

    public void switchToHomePage() {
        current = new HomePage();
        add(current);
    }

    public void switchToSelectPage() {
        current = new SelectPage();
        add(current);
    }

    public void switchToGamingPage() {
        mp = new MusicPlayer("YEEYEEYEEYEEYEE");
        current = new GamingPage();
        add(current);
    }
}
