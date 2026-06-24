import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        PlayerService service =
            new PlayerService();

        Player latestPlayer =
            service.getPlayerById(
                player.getId()
            );

        setTitle("Statistics");
        setSize(300,250);
        setLocationRelativeTo(null);

        JPanel panel =
            new JPanel();

        panel.setLayout(
            new GridLayout(5,1)
        );

        panel.add(
            new JLabel(
                "Username: " +
                latestPlayer.getUsername()
            )
        );

        panel.add(
            new JLabel(
                "Wins: " +
                latestPlayer.getWins()
            )
        );

        panel.add(
            new JLabel(
                "Losses: " +
                latestPlayer.getLosses()
            )
        );

        panel.add(
            new JLabel(
                "Draws: " +
                latestPlayer.getDraws()
            )
        );

        panel.add(
            new JLabel(
                "Score: " +
                latestPlayer.getScore()
            )
        );

        add(panel);

        setVisible(true);
    }
}