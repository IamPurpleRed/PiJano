import javax.swing.*;
import java.awt.*;

public class FinishPage extends JPanel {

    JLabel background = new JLabel(new ImageIcon("src/img/gameover.jpg"));
    JLabel MyScore = new JLabel();
    JLabel Champion = new JLabel(new ImageIcon("src/img/unnamed.png"));

    FinishPage() {
        setLayout(null);

        background.setBounds(0, 0, 1600, 1000);

        Champion.setBounds(160, 100, 400, 300);

        MyScore.setText(Main.PiJano.Final_M_Score.toString());
        MyScore.setForeground(Color.YELLOW);
        MyScore.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 150));
        MyScore.setBounds(600, 120, 500, 300);

        add(Champion);
        add(MyScore);
        add(background);

    }
}
