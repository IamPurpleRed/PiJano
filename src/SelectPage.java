import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SelectPage extends JPanel {
    JLabel background = new JLabel(new ImageIcon("src/img/bg_homepage.png"));
    JLabel title = new JLabel();
    Integer page = 1;
    JLabel page_text = new JLabel();
    JButton songlist_prev_btn = new JButton();
    JButton songlist_next_btn = new JButton();
    JButton[] songlist_content_btn = new JButton[5];
    Dimension songlist_content_btn_size = new Dimension(450, 50);
    JButton start_btn = new JButton(); // 暫時的

    SelectPage() {
        setLayout(null);

        background.setBounds(0, 0, MainFrame.frame_size.width, MainFrame.frame_size.height);

        title.setText("SELECT");
        title.setFont(new Font("Arial", Font.BOLD, 80));
        title.setBounds(90, 50, 500, 100);
        title.setForeground(Color.WHITE);

        songlist_prev_btn.setIcon(new ImageIcon("src/img/prev_page.png"));
        songlist_prev_btn.setBounds(100, 180, 100, 100);
        songlist_prev_btn.setOpaque(false); // 顯示出來
        songlist_prev_btn.setContentAreaFilled(false); // 背景透明
        songlist_prev_btn.setBorderPainted(false); // 除去button邊框
        songlist_prev_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page > 1) {
                    page -= 1;
                    updatePage(page);
                }
            }
        });

        page_text.setFont(new Font("Arial", Font.BOLD, 60));
        page_text.setBounds(250, 180, 100, 100);
        page_text.setForeground(Color.WHITE);

        songlist_next_btn.setIcon(new ImageIcon("src/img/next_page.png"));
        songlist_next_btn.setBounds(350, 180, 100, 100);
        songlist_next_btn.setOpaque(false); // 顯示出來
        songlist_next_btn.setContentAreaFilled(false); // 背景透明
        songlist_next_btn.setBorderPainted(false); // 除去button邊框
        songlist_next_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page < Math.ceil(Main.PiJano.available_list.size() / 5)) {
                    page += 1;
                    updatePage(page);
                }
            }
        });

        updatePage(page);
        //setComponentZOrder(title, 0);

        /* 以下東西是暫時的 */
        start_btn.setIcon(new ImageIcon("src/img/roller.png"));
        start_btn.setBounds(1200, 200, 234, 150);
        start_btn.setOpaque(false); // 顯示出來
        start_btn.setContentAreaFilled(false); // 背景透明
        start_btn.setBorderPainted(false); // 除去button邊框
        start_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                new FileChecker();
                Main.PiJano.removePage(Main.PiJano.current, "GamingPage");
            }
        });
    }

    void updatePage(Integer page) {
        page_text.setText(page.toString());

        int x = 100, y = 300;
        for (int i = 5 * (page - 1); i < 5 * page - 1; i++) {
            if (i >= Main.PiJano.available_list.size())
                break;

        }

        add(songlist_prev_btn);
        add(page_text);
        add(songlist_next_btn);
        add(title);
        add(start_btn); // 暫時的
        add(background);
    }
}
