import javax.swing.*;
import java.awt.*;

public class FinishPage extends JPanel {

    JLabel background = new JLabel(new ImageIcon("src/img/gameover.jpg"));
    JLabel Winner = new JLabel();
    JLabel Lose = new JLabel();
    JLabel Winner_f = new JLabel();
    JLabel Lose_f = new JLabel();
    JLabel Champion = new JLabel(new ImageIcon("src/img/winner.png"));
    JLabel Loser = new JLabel(new ImageIcon("src/img/loser.png"));

    FinishPage() {
        setLayout(null);

        background.setBounds(0, 0, 1600, 1000);

        Loser.setBounds(120, 300, 150, 150);
        Champion.setBounds(0, 0, 400, 300);

        if (Main.PiJano.Final_M_Score >= Main.PiJano.Final_E_Score) {
            Winner.setText(Main.PiJano.Final_M_Score.toString());
            Winner_f.setText("1P ");
            Winner_f.setForeground(Color.YELLOW);
            Winner_f.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 100));
            Winner_f.setBounds(450, 0, 500, 300);
            Lose_f.setText("2P ");
            Lose_f.setForeground(Color.RED);
            Lose_f.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 100));
            Lose_f.setBounds(300, 220, 500, 300);
            Lose.setText(Main.PiJano.Final_E_Score.toString());
        } else {
            Winner.setText(Main.PiJano.Final_E_Score.toString());
            Winner_f.setText("2P ");
            Winner_f.setForeground(Color.YELLOW);
            Winner_f.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 100));
            Winner_f.setBounds(450, 0, 500, 300);
            Lose_f.setText("1P ");
            Lose_f.setForeground(Color.RED);
            Lose_f.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 100));
            Lose_f.setBounds(300, 220, 500, 300);
            Lose.setText(Main.PiJano.Final_M_Score.toString());
        }

        Winner.setForeground(Color.YELLOW);
        Winner.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 150));
        Winner.setBounds(650, -10, 500, 300);

        Lose.setForeground(Color.RED);
        Lose.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 150));
        Lose.setBounds(500, 210, 500, 300);

        add(Winner_f);
        add(Lose_f);
        add(Loser);
        add(Lose);
        add(Champion);
        add(Winner);
        add(background);

    }
}
