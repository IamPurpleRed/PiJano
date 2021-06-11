import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;

public class HomePage extends JPanel {
    class MoveText implements ActionListener {
        Timer timer = new Timer(100, this);
        Random rd = new Random();
        int loadingText_x = 1240;
        int loadingText_y = 860;
        int loadingText_x_speed = 3;
        int game_name_x = 100;
        int game_name_y = 450;
        int game_name_y_speed = 5;

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if (loadingText_x < 1190 || loadingText_x > 1280) {
                loadingText_x_speed *= -1;
            }
            if (game_name_y < 445 || game_name_y > 455) {
                game_name_y_speed *= -1;
            }

            loadingText_x += loadingText_x_speed;
            game_name_y += game_name_y_speed;

            int R = rd.nextInt(256);
            int G = rd.nextInt(256);
            int B = rd.nextInt(256);
            game_name.setForeground(new Color(R, G, B));

            loading_text.setBounds(loadingText_x, loadingText_y, 500, 100);
            game_name.setBounds(game_name_x, game_name_y, 580, 150);
            start_btn.setBounds(game_name_x,game_name_y,580,150);
        }
    }

    JLabel background = new JLabel(new ImageIcon("src/img/bg_Homepage.jpg"));
    JLabel game_name = new JLabel();
    JLabel loading_gif = new JLabel(new ImageIcon("src/img/loading.gif"));
    JLabel loading_text = new JLabel();
    JLabel bottomwave_gif = new JLabel(new ImageIcon("src/img/bottomwave.gif"));
    JButton start_btn = new JButton();

    HomePage() {
        setLayout(null);

        game_name.setText("P i J a n o");
        game_name.setFont(new Font("Playlist", Font.TRUETYPE_FONT, 150));
        background.setBounds(0, 0, MainFrame.frame_size.width, MainFrame.frame_size.height);
        loading_gif.setBounds(1300, 650, 240, 240);
        loading_text.setText("L o a d i n g . . .");
        loading_text.setFont(new Font("Lemon Tuesday", Font.ROMAN_BASELINE, 60));
        loading_text.setForeground(Color.WHITE);
        bottomwave_gif.setBounds(50, 700, 1000, 400);

        start_btn.setOpaque(false); // 顯示出來
        start_btn.setContentAreaFilled(false); // 背景透明
        start_btn.setBorderPainted(false); // 除去button邊框
        start_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e){
                new FileChecker();
                Main.PiJano.removePage(Main.PiJano.current, "SelectPage");
            }
        });

        add(game_name);
        add(loading_gif);
        add(loading_text);
        add(bottomwave_gif);
        add(start_btn);
        add(background);

        MoveText mt = new MoveText();
        mt.timer.start();
    }

}
