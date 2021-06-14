import javax.swing.*;
import java.awt.*;

public class FinishPage extends JPanel {

    JLabel background = new JLabel(new ImageIcon("src/img/gameover.jpg"));
    JLabel Winner = new JLabel();
    JLabel Champion = new JLabel(new ImageIcon("src/img/winner.png"));

    FinishPage() {
        setLayout(null);

        background.setBounds(0, 0, 1600, 1000);

        Champion.setBounds(160, 100, 400, 300);

        if (Main.PiJano.Final_M_Score >= Main.PiJano.Final_E_Score) {
            Winner.setText(Main.PiJano.Final_M_Score.toString());
        } else {
            Winner.setText(Main.PiJano.Final_E_Score.toString());
        }
        Winner.setForeground(Color.YELLOW);
        Winner.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 150));
        Winner.setBounds(600, 120, 500, 300);

        add(Champion);
        add(Winner);
        add(background);

    }
}
