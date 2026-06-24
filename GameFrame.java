import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private JButton[] buttons;
    private GameLogic game;

    private Player player;
    private PlayerService service;

    public GameFrame(Player player) {

        this.player = player;
        this.service = new PlayerService();

        game = new GameLogic();

        setTitle("Tic Tac Toe");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,3));

        buttons = new JButton[9];

        for(int i = 0; i < 9; i++) {

            buttons[i] = new JButton("");

            buttons[i].setFont(
                new Font(
                    "Arial",
                    Font.BOLD,
                    40
                )
            );

            final int index = i;

            buttons[i].addActionListener(
                e -> playerMove(index)
            );

            add(buttons[i]);
        }

        setVisible(true);
    }

    private void playerMove(int index) {

        if(!game.makeMove(index,'X')) {
            return;
        }

        buttons[index].setText("X");

        if(game.checkWinner('X')) {

            service.recordWin(
                player.getId()
            );

            JOptionPane.showMessageDialog(
                this,
                "You Win!"
            );

            dispose();
            return;
        }

        if(game.isDraw()) {

            service.recordDraw(
                player.getId()
            );

            JOptionPane.showMessageDialog(
                this,
                "Draw!"
            );

            dispose();
            return;
        }

        int computerMove =
            game.computerMove();

        buttons[computerMove]
            .setText("O");

        if(game.checkWinner('O')) {

            service.recordLoss(
                player.getId()
            );

            JOptionPane.showMessageDialog(
                this,
                "Computer Wins!"
            );

            dispose();
            return;
        }

        if(game.isDraw()) {

            service.recordDraw(
                player.getId()
            );

            JOptionPane.showMessageDialog(
                this,
                "Draw!"
            );

            dispose();
        }
    }
}