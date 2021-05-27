import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.border.Border;
import java.util.*;
import java.util.Timer;

class stuff{
    public double xpos;
    public double ypos;
    public double speed;
    public void setValue(double _xpos,double _ypos,double _speed)
    {
        xpos = _xpos;
        ypos = _ypos;
        speed = _speed;
    }
    public void initial()
    {
        xpos = -1000;
        ypos = 0;
        speed = 0;
    }
}
public class GamingPage extends JPanel{
    boolean ready1 = true;
    boolean ready2 = true;
    boolean ready3 = true;
    boolean ready4 = true;

    stuff o1 = new stuff();     //o1 to o4 are used to set the first row
    stuff o2 = new stuff();
    stuff o3 = new stuff();
    stuff o4 = new stuff();

    stuff o5 = new stuff();     // o5 to o8 are used to set the second row
    stuff o6 = new stuff();
    stuff o7 = new stuff();
    stuff o8 = new stuff();

    stuff o9 = new stuff();     // o9 to o12 are used to set the third row
    stuff o10 = new stuff();
    stuff o11 = new stuff();
    stuff o12 = new stuff();

    stuff o13 = new stuff();    //o13 to o16 are used to set the fourth row
    stuff o14 = new stuff();
    stuff o15 = new stuff();
    stuff o16 = new stuff();

    String str[]=new String[100];
    int counter = 0;


    Stroke stroke1 = new BasicStroke(6f);
    GamingPage() {

        JLayeredPane layeredPane = new JLayeredPane();// 新建一個分層器
        JLabel back = new JLabel(new ImageIcon("res/back.png"));
        back.setOpaque(true);
        back.setBackground(new Color(0x123456));
        this.add(back);
        layeredPane.add(this, JLayeredPane.DEFAULT_LAYER);// 將背景圖放在最底層 
        readfile();             //read sheet.txt to str array
        initial();

    }
    public void initial()
    {
/*
        setValue形式 => (x座標,y座標,速度)
        x座標 => 第一軌道:490
                 第二軌道:690
                 第三軌道:890
                 第四軌道:1090
        y座標 => 之所以放time變數而不是直接放0是因為一開始初始化時各排我預設相間300 pixel的高度(後端先不要改比較好)
        速度  => 下降速度(先預設為1，快慢後端可以設定)

        如果要測試掀開一個sheet.txt，內容放
        1111
        1111
        1111
        1111        => 4行資料
 */
        double time = 0;
        for(int i=0;i<counter;i++)
        {
            if(i%4==0)                                      //假如行數mod 4 = 1，就把資料丟進o1~o4
            {
                if(str[i].charAt(0) == '1')                 //如果該行第一個字元為1，設定o1資料，並呼叫function
                {
                    o1.setValue(490, time, 1);
                    block_1();
                }
                else
                    o1.setValue(-200, 0, 0);                //如果該行第一個字元是0，設定o1資料至視窗外面
                if(str[i].charAt(1) == '1')                 //如果該行第2個字元為1，設定o2資料，並呼叫function
                {
                    o2.setValue(690, time, 1);
                    block_2();
                }
                else
                    o2.setValue(-200, 0, 0);                //如果該行第一個字元是0，設定o2資料至視窗外面
                if(str[i].charAt(2) == '1')                 //如果該行第一個字元為1，設定o3資料，並呼叫function
                {
                    o3.setValue(890, time, 1);
                    block_3();
                }
                else
                    o3.setValue(-200, 0, 0);                //如果該行第一個字元是0，設定o3資料至視窗外面
                if(str[i].charAt(3) == '1')                 //如果該行第一個字元為1，設定o4資料，並呼叫function
                {
                    o4.setValue(1090, time, 1);
                    block_4();
                }
                else
                    o4.setValue(-200, 0, 0);                //如果該行第一個字元是0，設定o4資料至視窗外面
            }
            else if(i%4==1)                                 //以下都同上
            {
                if(str[i].charAt(0) == '1')
                {
                    o5.setValue(490, time, 1);
                    block_5();
                }
                else
                    o5.setValue(-200, 0, 0);
                if(str[i].charAt(1) == '1')
                {
                    o6.setValue(690, time, 1);
                    block_6();
                }
                else
                    o6.setValue(-200, 0, 0);
                if(str[i].charAt(2) == '1')
                {
                    o7.setValue(890, time, 1);
                    block_7();
                }
                else
                    o7.setValue(-200, 0, 0);
                if(str[i].charAt(3) == '1')
                {
                    o8.setValue(1090, time, 1);
                    block_8();
                }
                else
                    o8.setValue(-200, 0, 0);
            }
            else if(i%4==2)
            {
                if(str[i].charAt(0) == '1')
                {
                    o9.setValue(490, time, 1);
                    block_9();
                }
                else
                    o9.setValue(-200, 0, 0);
                if(str[i].charAt(1) == '1')
                {
                    o10.setValue(690, time, 1);
                    block_10();
                }
                else
                    o10.setValue(-200, 0, 0);
                if(str[i].charAt(2) == '1')
                {
                    o11.setValue(890, time, 1);
                    block_11();
                }
                else
                    o11.setValue(-200, 0, 0);
                if(str[i].charAt(3) == '1')
                {
                    o12.setValue(1090, time, 1);
                    block_12();
                }
                else
                    o12.setValue(-200, 0, 0);
            }
            else if(i%4==3)
            {
                if(str[i].charAt(0) == '1')
                {
                    o13.setValue(490, time, 1);
                    block_13();
                }
                else
                    o13.setValue(-200, 0, 0);
                if(str[i].charAt(1) == '1')
                {
                    o14.setValue(690, time, 1);
                    block_14();
                }
                else
                    o14.setValue(-200, 0, 0);
                if(str[i].charAt(2) == '1')
                {
                    o15.setValue(890, time, 1);
                    block_15();
                }
                else
                    o15.setValue(-200, 0, 0);
                if(str[i].charAt(3) == '1')
                {
                    o16.setValue(1090, time, 1);
                    block_16();
                }
                else
                    o16.setValue(-200, 0, 0);
            }
            time -= 300;
        }

    }
    public void readfile()
    {
        try {
            FileReader fr = new FileReader("sheet.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true)
            {
                str[counter] = br.readLine();
                if(str[counter] == null)
                    break;
                counter++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fail read file!!", "Default",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void paint(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Graphics2D g2D = (Graphics2D) g;
        super.paint(g);
        paintComponent1(g);
        paintComponent2(g);
        paintComponent3(g);
        paintComponent4(g);
        paintComponent5(g);
        paintComponent6(g);
        paintComponent7(g);
        paintComponent8(g);
        paintComponent9(g);
        paintComponent10(g);
        paintComponent11(g);
        paintComponent12(g);
        paintComponent13(g);
        paintComponent14(g);
        paintComponent15(g);
        paintComponent16(g);
        paintMyScore(g);
        paintCombo(g);
        paintEnemyScore(g);
    }
    public void paintComponent1(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o1.xpos, o1.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_1()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o1.ypos = o1.ypos + o1.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent2(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o2.xpos, o2.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_2()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o2.ypos = o2.ypos + o2.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent3(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o3.xpos, o3.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_3()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o3.ypos = o3.ypos + o3.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent4(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o4.xpos, o4.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_4()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o4.ypos = o4.ypos + o4.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent5(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o5.xpos, o5.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_5()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o5.ypos = o5.ypos + o5.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent6(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o6.xpos, o6.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_6()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o6.ypos = o6.ypos + o6.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent7(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o7.xpos, o7.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_7()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o7.ypos = o7.ypos + o7.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent8(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o8.xpos, o8.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_8()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o8.ypos = o8.ypos + o8.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent9(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o9.xpos, o9.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_9()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o9.ypos = o9.ypos + o9.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent10(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o10.xpos, o10.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_10()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o10.ypos = o10.ypos + o10.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent11(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o11.xpos, o11.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_11()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o11.ypos = o11.ypos + o11.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent12(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o12.xpos, o12.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_12()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o12.ypos = o12.ypos + o12.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent13(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o13.xpos, o13.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_13()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o13.ypos = o13.ypos + o13.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent14(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o14.xpos, o14.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_14()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o14.ypos = o14.ypos + o14.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent15(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o15.xpos, o15.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_15()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o15.ypos = o15.ypos + o15.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void paintComponent16(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(o16.xpos, o16.ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
    public void block_16()
    {
        Timer t2 = new Timer();
        TimerTask ttt = new TimerTask(){
            public void run(){
                o16.ypos = o16.ypos + o16.speed;
                repaint(); // 重繪panel
            }
        };
        t2.schedule(ttt, 0,5);
    }
    public void ss()                //uesd to debug
    {
        JOptionPane.showMessageDialog(null, counter, "Default",
                JOptionPane.ERROR_MESSAGE);
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
}