import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SelectPage extends JPanel {
    JLabel background = new JLabel(new ImageIcon("src/img/bg_homepage.png"));
    Integer page = 61000;
    JLabel page_text = new JLabel(page.toString());
    JButton songlist_prev_btn = new JButton();
    JButton songlist_next_btn = new JButton();
    ArrayList<JButton> songlist_content_btn = new ArrayList<JButton>();
    Dimension songlist_content_btn_size = new Dimension(450, 150);

    SelectPage() {
        setLayout(null);

        background.setBounds(0, 0, MainFrame.frame_size.width, MainFrame.frame_size.height);
        songlist_prev_btn.setIcon(new ImageIcon("src/img/prev_page.png"));
        songlist_prev_btn.setBounds(300, 300, 300, 300);
        songlist_prev_btn.setOpaque(false); // 顯示出來
        songlist_prev_btn.setContentAreaFilled(false); // 背景透明
        songlist_prev_btn.setBorderPainted(false); // 除去button邊框
        songlist_prev_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page > 1)
                    updatePage(page - 1);
            }
        });

        page_text.setText(page.toString());
        page_text.setFont(new Font("Playlist", Font.BOLD, 60));
        page_text.setBounds(1000, 300, 300, 300);
        page_text.setForeground(Color.WHITE);

        songlist_next_btn.setIcon(new ImageIcon("src/img/next_page.png"));
        songlist_next_btn.setBounds(500, 300, 300, 300);
        songlist_next_btn.setOpaque(false); // 顯示出來
        songlist_next_btn.setContentAreaFilled(false); // 背景透明
        songlist_next_btn.setBorderPainted(false); // 除去button邊框
        songlist_next_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page < 100)
                    updatePage(page - 1);
            }
        });

        add(songlist_prev_btn);
        add(songlist_next_btn);
        add(page_text);

        add(background);
        repaint();

    }

    void updatePage(Integer page) {
        page_text.setText(page.toString());
    }
}
