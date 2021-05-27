import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BetaStart extends JPanel implements ActionListener {

    MainFrame frame;

    Timer timer = new Timer(100, this);

    int posx = -20;
    int posy = 410;
    int vx = 10;
    int vy = 10;

    JLabel label;
    JLabel label1;
    JButton button;
    JFrame begin;

    BetaStart() {
        label = new JLabel(new ImageIcon("src/img/start.png"));
        label1 = new JLabel(new ImageIcon("src/img/t.png"));
        label.setSize(1600, 1000);
        label1.setSize(640, 590);

        this.setLayout(null);

        this.add(label1);
        this.add(label);

        timer.start();

    }

    public void actionPerformed(ActionEvent e) {

        if (posx < 0 || posx > 1600) {
            vx = -vx;
        }
        if (posy < 370 || posy > 400) {
            vy = -vy;
        }
        //posx += vx;
        posy += vy;
        label1.setLocation(posx, posy);
    }
}
