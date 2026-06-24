import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {

        setTitle("Tic Tac Toe Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panel.add(txtUsername);

        panel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        btnLogin = new JButton("Login");
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {

        String username =
                txtUsername.getText();

        String password =
                new String(
                        txtPassword.getPassword()
                );

        PlayerService service =
                new PlayerService();

        Player player =
                service.login(
                        username,
                        password
                );

        if(player != null) {

            JOptionPane.showMessageDialog(
                this,
        "Login Success!"
        );

        new MainMenuFrame(player);

        dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username/password"
            );
        }
    }
}