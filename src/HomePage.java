import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

public class HomePage extends JFrame {
    Dimension frame_size = new Dimension(1600, 1000);
    static Dimension user_size = Toolkit.getDefaultToolkit().getScreenSize();
    BetaStart start;
    MainFrame mainFrame;
    JButton button;
    JFrame close = this;

    HomePage() {
        start = new BetaStart();
        this.setTitle("Beta");
        this.setSize(frame_size);
        this.setResizable(false); // 固定視窗大小
        this.setLocation(user_size.width / 2 - frame_size.width / 2, user_size.height / 2 - frame_size.height / 2); // 置中
        ImageIcon image = new ImageIcon("src/img/logo.png"); // create a image icon
        this.setIconImage(image.getImage()); // change frame's icon
        this.getContentPane().setBackground(Color.black); //背景顏色(消除panel邊框)
        this.getContentPane().setLayout(new BorderLayout());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // 關閉視窗即退出程式

        button = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img/roller.png"));
            button.setIcon(new ImageIcon(img));
            button.setOpaque(false); //透明化
            button.setContentAreaFilled(false); //button整個都透明
            button.setSize(234, 150);
            button.setLocation(800, 600);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame = new MainFrame();
                close.dispose();
                mainFrame.setVisible(true);
            }
        });
        this.add(button);
        this.add(start, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
