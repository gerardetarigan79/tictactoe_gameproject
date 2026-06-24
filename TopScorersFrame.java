import javax.swing.*;
import java.util.List;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame() {

        setTitle("Top Scorers");
        setSize(300,250);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        PlayerService service =
            new PlayerService();

        List<Player> players =
            service.getTopPlayers();

        int rank = 1;

        for(Player player : players) {

            area.append(
                rank + ". " +
                player.getUsername() +
                " - Score: " +
                player.getScore() +
                "\n"
            );

            rank++;
        }

        add(new JScrollPane(area));

        setVisible(true);
    }
}