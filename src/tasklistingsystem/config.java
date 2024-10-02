package tasklistingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class config {
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            con = DriverManager.getConnection("jdbc:sqlite:tls.db"); 
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
        public void addAcc(String sql, String... values) {
        try (Connection conn = this.connectDB(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setString(i + 1, values[i]); 
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
    }
        
        public void viewEmpAcc() {
        String sql = "SELECT * FROM employee-acc";
        config conf = new config();
        try (Connection conn = conf.connectDB(); // Use the connectDB method
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("| %-5s | %-20s | %-12s | %-25s | %-10s | %-10s |\n", "Account ID", "Firstname", "LastNAme", "Email", "Department", "Role");
            System.out.println("--------------------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("acc_id");
                String fname = rs.getString("e_fname");
                String lname = rs.getString("e_lname");
                String email = rs.getString("e_email");
                String dpt = rs.getString("e_department");
                String role = rs.getString("e_department");
                System.out.printf("| %-5d | %-20s | %-12s | %-25s | %-10s | %-10s|\n", id, fname, lname, email, dpt, role);
            }

            System.out.println("--------------------------------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println("Error retrieving citizens: " + e.getMessage());
        }
    }
}
