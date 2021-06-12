import javax.swing.*;
import java.awt.*;

public class FinishPage extends JPanel {

    JLabel background = new JLabel(new ImageIcon("src/img/gameover.jpg"));
    JLabel MyScore = new JLabel();
    JLabel EnemyScore = new JLabel();
    JLabel MyScore_f = new JLabel();
    JLabel EnemyScore_f = new JLabel();

    FinishPage() {
        setLayout(null);

        background.setBounds(0, 0, 1600, 1000);

        MyScore_f.setText("Winner is ____");
        MyScore_f.setForeground(Color.YELLOW);
        MyScore_f.setFont(new Font("Tekton Pro Ext", Font.BOLD, 70));
        MyScore_f.setBounds(0, 150, 700, 200);

        MyScore.setText(Main.PiJano.Final_M_Score.toString());
        MyScore.setForeground(Color.YELLOW);
        MyScore.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 100));
        MyScore.setBounds(560, 100, 500, 200);

        EnemyScore_f.setText("Loser is ____");
        EnemyScore_f.setForeground(Color.RED);
        EnemyScore_f.setFont(new Font("Tekton Pro Ext", Font.BOLD, 70));
        EnemyScore_f.setBounds(0, 250, 700, 200);

        EnemyScore.setText(Main.PiJano.Final_M_Score.toString());
        EnemyScore.setForeground(Color.RED);
        EnemyScore.setFont(new Font("Playlist", Font.ROMAN_BASELINE, 100));
        EnemyScore.setBounds(560, 200, 500, 200);

        add(MyScore_f);
        add(EnemyScore_f);
        add(MyScore);
        add(EnemyScore);
        add(background);

    }
}
