import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    Dimension frame_size = new Dimension(1600, 1000);
    static Dimension user_size = Toolkit.getDefaultToolkit().getScreenSize();

    MainFrame() {
        this.setTitle("Beta"); // TODO: 缺一個酷名字
        this.setSize(frame_size);
        this.setLocation(user_size.width / 2 - frame_size.width / 2, user_size.height / 2 - frame_size.height / 2); // 置中
        this.getContentPane().add(new GamingPage()); // TODO: 之後要切成主畫面
        ImageIcon image = new ImageIcon("src/img/logo.png"); // create a image icon
        this.setIconImage(image.getImage()); // change frame's icon
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // 關閉視窗即退出程式
    }
}
