import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;

public class HomePage extends JFrame {

    GamingPage frame;
    BetaStart start;
    JButton button;
    JFrame close = this;

    HomePage() {
        start = new BetaStart();
        this.setTitle("Beta");
        this.setSize(1600, 1000);
        this.setResizable(false); // 固定視窗大小
        //this.setLocation(screen_Size.width / 2 - this.getSize().width / 2, screen_Size.height / 2 - this.getSize().height / 2);
        this.setLocation(150, 0);
        ImageIcon image = new ImageIcon("res/logo.jpg"); // create a image icon
        this.setIconImage(image.getImage()); // change frame's icon
        this.getContentPane().setBackground(Color.black); //背景顏色(消除panel邊框)
        this.getContentPane().setLayout(new BorderLayout());
        //this.add(panel, BorderLayout.CENTER);
        button = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("src/img/roller.png"));
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
                frame = new GamingPage();
                close.dispose();
                frame.setVisible(true);

            }

        });

        this.add(button);
        this.add(start, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
