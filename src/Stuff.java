import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

class Stuff extends JComponent {
    public double xpos;
    public double ypos;
    public double speed;
    Stroke stroke1 = new BasicStroke(6f);

    public void set_value(double _xpos, double _ypos, double _speed) {
        this.xpos = _xpos;
        this.ypos = _ypos;
        this.speed = _speed;
    }

    public void paintComponent(Graphics g) { // 左邊數過來第一個行
        Graphics2D g2d_1 = (Graphics2D) g;
        g2d_1.setColor(Color.CYAN);
        g2d_1.setStroke(stroke1);
        g2d_1.setPaint(Color.CYAN);
        Rectangle2D.Double rect1 = new Rectangle2D.Double(xpos, ypos, 150, 50); // 宣告2D長方形才能用小數點
        g2d_1.fill(rect1); // 畫圖案
    }
}