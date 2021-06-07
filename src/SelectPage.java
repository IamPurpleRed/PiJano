import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectPage extends JPanel {
    JLabel background = new JLabel(new ImageIcon("src/img/bg_homepage.png"));
    JLabel title = new JLabel();
    Integer page = 1; // 顯示當前頁數
    JLabel page_text = new JLabel();
    JButton songlist_prev_btn = new JButton();
    JButton songlist_next_btn = new JButton();
    static int songlist_per_page = 5; // 每頁會顯示幾個選項
    JButton[] songlist_content_btn = new JButton[songlist_per_page];
    Dimension songlist_content_btn_size = new Dimension(1000, 80);

    SelectPage() {
        setLayout(null);

        background.setBounds(0, 0, MainFrame.frame_size.width, MainFrame.frame_size.height);

        title.setText("SELECT");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
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

        page_text.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
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
                if (page < Math.ceil(Main.PiJano.available_list.size() / 5.0)) {
                    page += 1;
                    updatePage(page);
                }
            }
        });

        updatePage(page);

        add(songlist_prev_btn);
        add(page_text);
        add(songlist_next_btn);
        add(title);
        add(background);
    }

    void updatePage(Integer page) {
        page_text.setText(page.toString());

        for (int i = 0; i < songlist_per_page; i++) {
            if (songlist_content_btn[i] != null) remove(songlist_content_btn[i]);  // 先隱藏按鈕
        }

        Point current_position = new Point(100, 300);  // 第一個按鈕左上角的位置
        for (int i = songlist_per_page * (page - 1), j = 0; i < songlist_per_page * page; i++, j++) {
            if (i >= Main.PiJano.available_list.size()) break;

            String name = Main.PiJano.available_list.get(i); // 該button所連接的音樂名稱
            songlist_content_btn[j] = new JButton();
            songlist_content_btn[j].setText(name);
            songlist_content_btn[j].setFont(new Font("Comic Sans MS", Font.BOLD, 60));
            songlist_content_btn[j].setSize(songlist_content_btn_size);
            songlist_content_btn[j].setLocation(current_position);
            add(songlist_content_btn[j]);
            setComponentZOrder(songlist_content_btn[j], 0); // 抬升按鈕元件到最上面
            songlist_content_btn[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    new FileChecker();
                    Main.PiJano.now_playing = name;  // 將按鈕按鍵上的字串(歌曲名稱)回傳PiJano全域
                    Main.PiJano.removePage(Main.PiJano.current, "GamingPage");
                }
            });

            current_position.y += (songlist_content_btn_size.height + 10);  // 更新current_position，定位到下一個按鈕的左上座標
        }

        repaint();
    }
}