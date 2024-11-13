import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/playlist";
        String user = "root";
        String password = "raj1122";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO songs (artist, song_name, release_date) VALUES (?, ?, ?)")) {

            // Inserting a new song
            stmt.setString(1, "Artist 1");
            stmt.setString(2, "AAkash");
            stmt.setDate(3, java.sql.Date.valueOf("2023-11-10"));
            stmt.executeUpdate();

            // Inserting another song
            stmt.setString(1, "Artist 2");
            stmt.setString(2, "Dev");
            stmt.setDate(3, java.sql.Date.valueOf("2024-05-22"));
            stmt.executeUpdate();

            System.out.println("Songs inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());  // Print error message for debugging
        }
    }
}
