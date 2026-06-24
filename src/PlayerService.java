import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    public Player login(String username, String password) {
        String sql = "SELECT * FROM players WHERE username=? AND password=?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                    );
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void recordWin(int playerId) {
        String sql = "UPDATE players SET wins = wins + 1, score = score + 10 WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, playerId);
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void recordLoss(int playerId) {

    System.out.println("LOSS RECORDED");
    System.out.println("PLAYER ID = " + playerId);

    String sql = "UPDATE players SET losses = losses + 1 WHERE id = ?";

    try (Connection conn = DatabaseManager.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, playerId);

        int rows = stmt.executeUpdate();

        System.out.println("ROWS UPDATED = " + rows);

    } catch(Exception e) {
        e.printStackTrace();
        }
    }

    public void recordDraw(int playerId) {
        String sql = "UPDATE players SET draws = draws + 1, score = score + 3 WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, playerId);
            stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Player getPlayerById(int playerId) {
        String sql = "SELECT * FROM players WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, playerId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                    );
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // FIXED: Moved INSIDE the class brackets, and safely maps to a List 
    public List<Player> getTopPlayers() {
        List<Player> topPlayers = new ArrayList<>();
        String sql = "SELECT * FROM players ORDER BY score DESC LIMIT 5";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Player player = new Player(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getInt("wins"),
                    rs.getInt("losses"),
                    rs.getInt("draws"),
                    rs.getInt("score")
                );
                topPlayers.add(player);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return topPlayers; 
    }
} 