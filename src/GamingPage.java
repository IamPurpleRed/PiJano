import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Timer;

public class GamingPage extends JPanel {
    final int block_interval = 100;
    final int block_number = (1000/block_interval + 3) * 4;
    final int dead_line_y = 1000 + block_interval;
    int current_load = block_number/4;
    ArrayList <Integer> trail_number = new ArrayList<Integer>();
    Stuff objects[] = new Stuff[block_number];
    String str[] = new String[100];
    boolean drawblock[] = new boolean[block_number];
    int index = 0;
    int counter = 0;
    int status = 0;
    double fall_speed = 1;
    Stroke stroke1 = new BasicStroke(6f);
    JLabel Mogu_pos = new JLabel(new ImageIcon("src/img/MOGU.png"));
    int upper_upper_str;
    public int upper_str_ypos = 0;
    public String upper_str = "1000";
    int temp = 0;
    int cur = 1;
    GamingPage() {

        setLayout(null);
        JLabel back = new JLabel(new ImageIcon("src/img/bg_GamingPage.png"));
        back.setOpaque(true);
        back.setBounds(0, 0, 1600, 1000);
        back.setBackground(new Color(0x123456));
        setMOGU(635, 830);
        add(Mogu_pos);
        add(back);

        readfile(); //read sheet.txt to str array
        initial();
        check_if_buttom();
    }
    // public void check()
    // {
    //     String temp;
    //     Timer t3 = new Timer();
    //     TimerTask check_y = new TimerTask(){
    //         public void run() {

    //         }
    //     };
    //     t3.schedule(check_y, 0,5);
    //}

    public void setMOGU(int x, int y) {
        /*
            第一軌道: 635,830
            第二軌道: 835,830
            第三軌道: 1035,830
            第四軌道: 1235,830
        */
        Mogu_pos.setBounds(x, y, 100, 100);
    }

    public void initial() {
        for(int i=0;i < block_number;i++)
        {
            objects[i] = new Stuff();
            objects[i].ypos = -200;
            drawblock[i] = true;
        }
        double time = 0;
        for(int line = 0; line < block_number/4; line++)
        {
            for(int at = 0; at < 4; at++){

                if(str[line].charAt(at)=='1'){
                    objects[at + 4 * line].set_value(585 + (200 * at), time,fall_speed);
                }
                else {
                    objects[at + 4 * line].set_value(-200, time,fall_speed);
                }
                block(objects[at + 4 * line]);
            }
            time -= block_interval;
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

        for(int i = 0; i < block_number; i++){
            if(drawblock[i])
                objects[i].paintBlock(g);
        }
        paintline(g);
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

    public void paintline(Graphics g) {
        Stroke stroke2 = new BasicStroke(20f);
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.ORANGE);
        g2d_1.setStroke(stroke2);
        for(int i=0;i< index-1;i++)
        {
            g2d_1.drawLine((int)objects[trail_number.get(i)].xpos, (int)objects[trail_number.get(i)].ypos, (int)objects[trail_number.get(i + 1)].xpos, (int)objects[trail_number.get(i + 1)].ypos);
        }
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
        TimerTask check_y = new TimerTask(){
            public void run() {
                upper_str_ypos = 919 - (int)objects[temp].ypos;
                if(objects[temp].ypos==919)
                {
                    upper_str = str[cur];
                    temp += 4;
                    cur++;
                }
                if(temp >= block_number)
                    temp = 0;
                if(index > 0)
                {
                    if(objects[trail_number.get(0)].ypos>= dead_line_y)
                    {
                        drawblock[trail_number.get(0)] = true;
                        trail_number.remove(0);
                        index--;
                    }
                }
                if(current_load < counter) {
                    for (int i = 0; i < counter; i++) {
                        int line = i % (block_number / 4);                                //第i列資料
                        if (objects[line * 4].ypos >= dead_line_y) {
                            for (int track = 0; track < 4; track++) {
                                if (str[current_load].charAt(track) == '2') {
                                    if (index >= (block_number / 4)) {
                                        trail_number.remove(0);
                                        index--;
                                    }
                                    trail_number.add(track + 4 * line);
                                    objects[track + 4 * line].set_value(660 + 200 * track, -180, fall_speed);
                                    index++;
                                    drawblock[track + 4 * line] = false;
                                } else if (str[current_load].charAt(track) == '1') {
                                    objects[track + 4 * line].set_value(585 + 200 * track, -200, fall_speed);
                                } else {
                                    objects[track + 4 * line].set_value(-200, -200, fall_speed);
                                }
                            }
                            current_load++;
                        }
                    }
                    repaint();
                }
            }
        };
        t3.schedule(check_y, 0,1);
    }
}