import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private Player player;

    public MainMenuFrame(Player player) {

        this.player = player;

        setTitle("Main Menu");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblWelcome =
            new JLabel(
                "Welcome " +
                player.getUsername(),
                SwingConstants.CENTER
            );

        JButton btnGame =
            new JButton("Start Game");

        JButton btnStats =
            new JButton("Statistics");

        JButton btnTop =
            new JButton("Top Scorers");

        JButton btnExit =
            new JButton("Exit");

        JPanel panel =
            new JPanel();

        panel.setLayout(
            new GridLayout(5,1)
        );

        panel.add(lblWelcome);
        panel.add(btnGame);
        panel.add(btnStats);
        panel.add(btnTop);
        panel.add(btnExit);

        add(panel);

        btnGame.addActionListener(
            e -> new GameFrame(player)
        );

        btnStats.addActionListener(
            e -> new StatisticsFrame(player)
        );

        btnTop.addActionListener(
            e -> new TopScorersFrame()
        );

        btnExit.addActionListener(
            e -> System.exit(0)
        );

        setVisible(true);
    }
}