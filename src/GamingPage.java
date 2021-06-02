import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Timer;

public class GamingPage extends JPanel {
    Stuff[] objects = new Stuff[16];
    String[] str = new String[100];
    int counter = 0;
    int current_load = 4; // 前四行已initial//load行
    int dead_line_y = 1200;
    Stroke stroke1 = new BasicStroke(6f);

    GamingPage() {
        JLayeredPane layeredPane = new JLayeredPane(); // 新建一個分層器
        JLabel back = new JLabel(new ImageIcon("src/img/bg_GamingPage.png"));
        back.setOpaque(true);
        back.setBackground(new Color(0x123456));
        this.add(back);
        layeredPane.add(this, JLayeredPane.DEFAULT_LAYER); // 將背景圖放在最底層
        readfile(); //read sheet.txt to str array
        initial();
        check_if_buttom();
    }

    public void initial() {
        double time = 0;
        for (int i = 0; i < 4; i++) {
            int line = i % 4;
            for (int at = 0; at < 4; at++) {
                objects[at + 4 * line] = new Stuff();
                if (str[i].charAt(at) == '1') {
                    objects[at + 4 * line].set_value(490 + (200 * at), time, 1);
                } else {
                    objects[at + 4 * line].set_value(-200, time, 1);
                }
                block(objects[at + 4 * line]);
            }
            time -= 300;
        }
    }

    public void readfile() {
        try {
            FileReader fr = new FileReader("beatmap/sheet.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                str[counter] = br.readLine();
                if (str[counter] == null)
                    break;
                counter++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fail read file!!", "Default", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void paint(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Graphics2D g2D = (Graphics2D) g;
        super.paint(g);

        for (int i = 0; i < 16; i++) {
            objects[i].paintComponent(g);
        }

        paintMyScore(g);
        paintCombo(g);
        paintEnemyScore(g);
    }

    public void block(Stuff object) {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask() {
            public void run() {
                object.ypos = object.ypos + object.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0, 5);
    }

    public void paintMyScore(Graphics g) {
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.black);
        g2d_1.setStroke(stroke1);
        g2d_1.setFont(new Font("Comic Sans MC", Font.BOLD, 60));
        String score = "S C O R E";
        g2d_1.drawString(score, 90, 200);
    }

    public void paintEnemyScore(Graphics g) {
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.red);
        g2d_1.setStroke(stroke1);
        g2d_1.setFont(new Font("Comic Sans MC", Font.BOLD, 60));
        String score = "S C O R E";
        g2d_1.drawString(score, 90, 800);
    }

    public void paintCombo(Graphics g) {
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.black);
        g2d_1.setStroke(stroke1);
        g2d_1.setFont(new Font("Comic Sans MC", Font.BOLD, 60));
        String combo = "C O M B O";
        g2d_1.drawString(combo, 80, 400);
    }

    public void check_if_buttom() {
        Timer t3 = new Timer();
        TimerTask check_y = new TimerTask() {
            public void run() {
                repaint();
                for (int i = 0; i < 4; i++) {
                    int line = i % 4;
                    if (objects[line * 4].ypos >= dead_line_y) {
                        for (int track = 0; track < 4; track++) {
                            if (str[current_load].charAt(track) == '1') {
                                objects[track + 4 * line].set_value(490 + 200 * track, 0, 1);
                            } else {
                                objects[track + 4 * line].set_value(-200, 0, 1);
                            }
                        }
                        current_load++;
                    }
                }
            }
        };
        t3.schedule(check_y, 0, 5);
    }
}